package app.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileService {


    public List<String> getFileNames(String path) {
        //todo: modify not to allow browsing the whole machine ("/home/user/......" or "../../")
        File[] files = new File(path).listFiles();
        List<String> names = new ArrayList<>();
        for(File f : files) names.add(f.getName());
        return names;
    }
}
