package com.stc;


import java.io.File;
import java.util.Stack;

public class FileProcessor {
    private Stack<File> fileStack;

    public FileProcessor() {
        fileStack = new Stack<>();
    }


    public void pushFilesFromFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileStack.push(file);
                      //  fileStack.pop();
                    }
                }
            }
        }
    }


    public File processFiles() {
        while (!fileStack.isEmpty()) {
            File file = fileStack.pop();
            System.out.println("Processing file: " + file.getName());
            return file;
        }
        return null;
    }




}
