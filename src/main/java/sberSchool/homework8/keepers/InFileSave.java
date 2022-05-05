package sberSchool.homework8.keepers;

import sberSchool.homework8.service.Service;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class InFileSave {
    private Map<Object[], Object> caches = new HashMap<>();
    private Service service;

    public InFileSave(Service service) {
        this.service = service;
    }

    public double SaveFile(boolean[] saveArgs, Method method, Object[] args,
                           String namePrefix) throws InvocationTargetException, IllegalAccessException {
        Object rezult = null;

        try {
            rezult = findRezult(args, namePrefix);
        } catch (Exception e) {
            //save rezult
        }

        if (saveArgs[0] == saveArgs[1] && saveArgs[0] != false) {
            caches.put(args, method.invoke(service, args));

        } else if (saveArgs[0] && !saveArgs[1]) {
            Object[] argsOne = Arrays.copyOf(args, 1);
            caches.put(argsOne, method.invoke(service, args));
        } else {
            Object[] argsTwo = Arrays.copyOfRange(args, 1, 2);
            caches.put(argsTwo, method.invoke(service, args));
        }

        try (FileOutputStream fos = new FileOutputStream(String.format("cache%s.ser", namePrefix));
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(caches);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (double) method.invoke(service, args);
    }


    private double findRezult(Object[] args, String namePrefix) throws Exception {
        try (FileInputStream fis = new FileInputStream(String.format("cache%s.ser", namePrefix));
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            caches = (HashMap) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Object[] key : caches.keySet()) {
            if (Arrays.equals(key, args)) {
                System.out.println("CASHES FILE");
                return (double) caches.get(key);
            }
        }
        throw new Exception("Not found value.");
    }

    public void zip(String namePrefix) {
        File fileToZip = new File(String.format("cache%s.ser", namePrefix));
        try {
            FileOutputStream fos = new FileOutputStream("cacheZip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes,0,length);
            }
            zipOut.close();
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
