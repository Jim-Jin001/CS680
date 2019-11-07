package edu.umb.cs680.hw06;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime){
        super(parent, name, size, creationTime);
    }

    public LinkedList<FSElement>getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
    }

    public int countChildren() {
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirectories = new LinkedList<Directory>();
        for(FSElement fse: children) {
            if(fse.isDirectory())
                subDirectories.add((Directory) fse);
        }
        return subDirectories;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<File>();
        for(FSElement fse: children) {
            if(fse.isDirectory())
                files.add((File) fse);
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for(FSElement fse: children) {
            if(fse.isDirectory()) 
                totalSize += ((Directory) fse).getTotalSize();
            totalSize += fse.getSize();
        }
        return totalSize;
    }

    public boolean isDirectory() {
        return true;
    }

    public boolean isFile() {
        return false;
    }
}