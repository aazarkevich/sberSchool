package sberSchool.homeWork7.task2;
import sberSchool.homeWork7.task1.plugins.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        File file = new File("C:\\Users\\Артем\\IdeaProjects\\sberSchool\\src\\main\\java\\sberSchool\\homeWork7\\task2\\encryptClass.class");
        EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader(5,file, null);
        Plugin plugin = (Plugin) encryptedClassLoader.findClass("sberSchool.homeWork7.task1.plugins.PluginHello").newInstance();
        plugin.doUsefull();
    }

    static byte[] readFile(Path path) throws IOException {
        return Files.readAllBytes(path);
    }
    static void writeFile(Path path, byte[] bytes) throws IOException {
        Files.write(path, bytes);
    }
}
