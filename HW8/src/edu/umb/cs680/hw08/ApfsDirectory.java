package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {

    // children list
    private LinkedList<ApfsElement> children =  new LinkedList<ApfsElement>();

    // contructor
    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                        String ownerName, LocalDateTime modifiedDate){
        super(parent, name, size, creationTime, ownerName, modifiedDate);
    }
    // return first level children that whose parent is this diretory.
    @Override
    public LinkedList<ApfsElement> getChildren() {
        return this.children;
    }
    // append child
    @Override
    public void appendChild(ApfsElement child) {
        this.children.add(child);
        child.setParent(this);
    }
    // count the number of children
    public int countChildren() {
        return this.children.size();
    }
    
    // return first level directories that whose parent is this diretory.
    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> subDirectories = new LinkedList<ApfsDirectory>();
        for(ApfsElement apfse: children) {
            if(apfse.isDirectory())
                subDirectories.add((ApfsDirectory) apfse);
        }
        return subDirectories;
    }

    // return first level files that whose parent is this diretory.
    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
        for(ApfsElement apfse: children) {
            if(apfse.isFile())
                files.add((ApfsFile) apfse);
        }
        return files;
    }
    // get total size
    public int getTotalSize() {
        int totalSize = 0;
        for(ApfsElement apfse: children) {
            if(apfse.isDirectory()) {
                totalSize += ((ApfsDirectory) apfse).getTotalSize();
            } else {
                totalSize += apfse.getSize();
            }
        }
        return totalSize;
    }
    // is Directory
    @Override
    public boolean isDirectory() {
        return true;
    }
}