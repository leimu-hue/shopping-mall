package com.leimu.mallcommon.utils;

import jodd.util.StringUtil;

public class FileUtil {

    public static String concatFile(String directory, String fileName) {
        if (directory == null || directory.isEmpty()) {
            return fileName;
        }
        return directory.endsWith("/") ? directory + fileName : directory + "/" + fileName;
    }

    public static String delFirstFilePath(String filePath) {
        return filePath.startsWith("/") ? filePath.substring(1) : filePath;
    }

    public static String readFilePathByOSSFile(String fileUrl) {
        if (StringUtil.isBlank(fileUrl)) {
            return "";
        }
        int firstPathIndex = fileUrl.replace("https://", "").indexOf("/");
        return fileUrl.substring(firstPathIndex);
    }

}
