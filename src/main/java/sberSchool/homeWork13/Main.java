package sberSchool.homeWork13;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        File file = new FileImpl();

        String[] paths = new String[]{"http://www.google.ru/intl/en_com/images/logo_plain.png",
                "https://e7.pngegg.com/pngimages/178/925/png-clipart-cartoon-graphy-the-little-boy-wanted-to-question-child-photography-thumbnail.png",
                "https://e7.pngegg.com/pngimages/152/1021/png-clipart-lion-cartoon-animation-lion-lion-mammal-animals-thumbnail.png"};
        file.download(paths);

//        String fileName = "D:\\java\\sberSchool\\src\\main\\java\\sberSchool\\homeWork13\\DownloadFiles\\img3-.png";
//        try (FileOutputStream fout = new FileOutputStream(fileName);
//             BufferedInputStream in = new BufferedInputStream(new URL(url).openStream())) {
//            byte data[] = new byte[1024];
//            int count;
//            while ((count = in.read(data, 0, 64)) != -1) {
//                fout.write(data, 0, count);
//                fout.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
