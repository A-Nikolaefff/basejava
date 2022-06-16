package ru.javawebinar.basejava;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File dir = new File("./src/ru/javawebinar/basejava");
        printFileList(dir);
    }

    public static void printFileList(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printFileList(file);
                }
            }
        }
    }
}
