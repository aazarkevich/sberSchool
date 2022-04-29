package sberSchool.homeWork7.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class EncryptedClassLoader extends ClassLoader {
    private final int key;
    private final File dir;
    private ClassLoader parent;

    public EncryptedClassLoader(int key, File dir, ClassLoader parent) {
//        super(parent);
        this.key = key;
        this.dir = dir;
        this.parent = parent;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] decodeBytes = new byte[0];
        try {
            decodeBytes = Chipher.decode(Files.readAllBytes(dir.toPath()),key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name,decodeBytes,0,decodeBytes.length);
    }
}
