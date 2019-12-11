package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private LocalDateTime createDate;
    private int size;
    private FSElement parent;

    // constructor
    public FSElement(FSElement parent, String name, int size, LocalDateTime createDate) {
        this.name = name;
        if (parent != null) {
            parent.appendChild(this);
        } else {
            // the directory is root, then the parent of root is itself
            this.parent = null;
        }
        this.size = size;
        this.createDate = createDate;
    }

    // is Directory
    public abstract boolean isDirectory();

    // is File
    public abstract boolean isFile();

    // is Link
    public abstract boolean isLink();
    // append child
    public abstract void appendChild(FSElement parent);
    
    // get parent
    public FSElement getParent() {
        return this.parent;
    }

    // set parent
    public void setParent(FSElement parent) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}