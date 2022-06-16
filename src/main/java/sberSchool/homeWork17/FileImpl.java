package sberSchool.homeWork17;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class FileImpl implements File {
    private String pathFileSave;

    public FileImpl(@Value("${path.fileSave}") String pathFileSave) {
        this.pathFileSave = pathFileSave;
    }

    @Override
    public String getUrlFile(String url, String fileName) {
        String pathFileName = pathFileSave + fileName;
        try (FileOutputStream fout = new FileOutputStream(pathFileName);
             BufferedInputStream in = new BufferedInputStream(new URL(url).openStream())) {
            synchronized (fout) {
                byte data[] = new byte[1024];
                int count;
                while ((count = in.read(data, 0, 64)) != -1) {
                    fout.write(data, 0, count);
                    fout.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathFileName;
    }

    @Override
    public void download(String[] paths) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        int count = 1;
        for (String path : paths) {
            StringBuffer fileName = new StringBuffer("img").append(count).append(".png");
            count++;
            System.out.println(count);
            service.submit(() -> {
                String urlFile = getUrlFile(path, fileName.toString());
                System.out.printf("Поток %s, загрузил файл по пути %s и сохранил %s \n", Thread.currentThread().getName(),path, urlFile);
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPathFiles() {
        return "";
    }
}
