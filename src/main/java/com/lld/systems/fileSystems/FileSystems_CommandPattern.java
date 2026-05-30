package com.lld.systems.fileSystems;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class FileSystems_CommandPattern {
    public static void main(String[] args) {
        //Sample Examples
        File movieFile = new File();
        movieFile.setFileName("movie1.text");

        File studyNotes = new File();
        studyNotes.setFileName("study1.text");

        File randomFile = new File();
        randomFile.setFileName("randomFile.jpg");

        Directory movies = new Directory();
        movies.setDirectoryName("Movies");
        movies.addFile(movieFile);

        Directory studies = new Directory();
        studies.setDirectoryName("Studies");

        studies.addFile(studyNotes);

        Directory parentDirectory = new Directory();
        parentDirectory.addDirectory(movies);
        parentDirectory.addDirectory(studies);
        parentDirectory.addFile(randomFile);

        movies.ls();

    }
}

interface FileSystem {
    void ls();
}

@Getter
@Setter
class File implements FileSystem {

    private String fileName;
    private int size;

    @Override
    public void ls() {
        System.out.println("The file is: "+ this.fileName);
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", size=" + size +
                '}';
    }
}

@Getter
@Setter
class Directory implements FileSystem {

    private List<File> files;
    private List<Directory> directories;
    private String directoryName;

    Directory() {
        files = new ArrayList<>();
        directories = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addDirectory(Directory directory) {
        directories.add(directory);
    }

    @Override
    public void ls() {
        for(File file: files) {
            System.out.println("Files: "+ file.getFileName());
        }

        for(Directory directory: directories) {
            System.out.println("Directories: "+ directory.getDirectoryName());
        }
    }
}
