package com.szxs.utils;

import java.io.File;

public class FileUtil {
    public static void createDirectory(String path){
        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    }
}
