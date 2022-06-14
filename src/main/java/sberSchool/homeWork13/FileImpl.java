package sberSchool.homeWork13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileImpl implements File {
    private Map<String, List> files = new ConcurrentHashMap<>();

    @Override
    public List read(String path) {
        List lines = new ArrayList();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void download(String[] paths) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (String path: paths) {
            service.submit(() -> {
                files.put(path,read(path));
            });
        }
    }

    public Map<String, List> getFiles() {
        return files;
    }
}
