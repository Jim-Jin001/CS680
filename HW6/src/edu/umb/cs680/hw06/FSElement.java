package edu.umb.cs680.hw06;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        if (parent != null) {
            parent.appendChild(this);
        } else {
            // the directory is root, then the parent of root is itself
            this.parent = null;
        }
    }

    public Directory getParent() {
        return parent;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return name;
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
    public void setParent(Directory parent) {
        this.parent = parent;
    }

    abstract public boolean isDirectory();

    abstract public boolean isFile();
}