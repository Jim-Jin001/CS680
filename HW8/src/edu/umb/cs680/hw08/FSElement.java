package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private LocalDateTime createDate;
    private int size;
    private ApfsDirectory parent;

    // constructor
    public FSElement(ApfsDirectory parent, String name, int size, LocalDateTime createDate) {
        this.name = name;
        this.parent = parent;
        this.size = size;
        this.createDate = createDate;
    }

    // is Directory
    public abstract boolean isDirectory();

    // is File
    public abstract boolean isFile();

    // is Link
    public abstract boolean isLink();
    
    // get parent
    public ApfsDirectory getParent() {
        return this.parent;
    }

    // set parent
    public void setParent(ApfsDirectory parent) {
        this.parent = parent;
    }

    // get size
    public int getSize() {
        return this.size;
    }

    // set size
    public void setSize(int size) {
        this.size = size;
    }

    // get createDate
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    // set createDate
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

}