package ru.otus.java.basic.homework20;

import java.io.File;
import java.io.FilenameFilter;

public class FileTypeFilter implements FilenameFilter {
    private String ext;
    public FileTypeFilter(String ext) {
        this.ext = ext.toLowerCase();
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(ext);
    }
}
