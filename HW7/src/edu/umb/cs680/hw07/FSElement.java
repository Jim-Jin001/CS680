package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private Directory parent;
    

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        if (parent != null) {
            parent.appendChild(this);
        } else {
            // the directory is root, then the parent of root is itself
            this.parent = null;
        }
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        return this.parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }
    
    public int getSize() {
        return this.size;
    }

    abstract public boolean isDirectory();

    abstract public boolean isFile();

    abstract public boolean isLink();
}