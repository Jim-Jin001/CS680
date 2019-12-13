package edu.umb.cs680.hw13;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {

    // children list
    private LinkedList<ApfsElement> children =  new LinkedList<ApfsElement>();

    // contructor
    public ApfsDirectory(ApfsDirectory parent, 
                            String name, 
                            int size, 
                            LocalDateTime creationTime,
                            String ownerName, 
                            LocalDateTime modifiedDate){
        super(parent, name, size, creationTime, ownerName, modifiedDate);
    }
    // return first level children that whose parent is this diretory.
    @Override
    public LinkedList<ApfsElement> getChildren() {
        return this.children;
    }
    // get children with comparators
    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
        Collections.sort(this.children, comparator);
        return this.children;
    }
    // append child
    @Override
    public void appendChild(FSElement child) {
        this.children.add((ApfsElement) child);
        child.setParent(this);
        Collections.sort(this.children, new AlphabeticalComparator());
    }
    // count the number of children
    public int countChildren() {
        return this.children.size();
    }
    
    // return first level directories that whose parent is this diretory.
    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsDirectory> subDirectories = new LinkedList<ApfsDirectory>();
        for(ApfsElement apfse: children) {
            if(apfse.isDirectory())
                subDirectories.add((ApfsDirectory) apfse);
        }
        Collections.sort(subDirectories, comparator);
        return subDirectories;
    }
    // get subdirectories with comparators
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
    // getfiles with comparators
    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
        for(ApfsElement apfse: children) {
            if(apfse.isFile())
                files.add((ApfsFile) apfse);
        }
        Collections.sort(files, comparator);
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