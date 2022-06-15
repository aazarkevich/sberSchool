package sberSchool.homeWork13;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FileImpl implements File {
    private Map<String, List> files = new ConcurrentHashMap<>();

    @Override
    public String getUrlFile(String url, String fileName) {
        String pathFilename = "D:\\java\\sberSchool\\src\\main\\java\\sberSchool\\homeWork13\\DownloadFiles\\" + fileName;
        try (FileOutputStream fout = new FileOutputStream(pathFilename);
             BufferedInputStream in = new BufferedInputStream(new URL(url).openStream())) {
            synchronized (in) {
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
        return pathFilename;
    }

    @Override
    public void download(String[] paths) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (String path : paths) {
            int count = 1;
            String fileName = "img" + count + ".png";
            count++;
            System.out.println(count);
            service.submit(() -> {
                String urlFile = getUrlFile(path, fileName);
                System.out.printf("Поток %s, загрузил файл по пути %s и сохранил %s", Thread.currentThread().getName(),path, urlFile);
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
