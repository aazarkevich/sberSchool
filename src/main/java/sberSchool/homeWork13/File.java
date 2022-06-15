package sberSchool.homeWork13;

import java.util.List;
import java.util.Map;

public interface File {
    String getUrlFile(String url,String fileName);
    void download(String[] paths);
    String getPathFiles();

}
