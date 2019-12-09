package edu.umb.cs680.hw13;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsElement extends FSElement {
    private String ownerName;
    private LocalDateTime modifiedDate;
    // Apfs Children
    private LinkedList<ApfsElement> ApfsChildren =  new LinkedList<ApfsElement>();

    

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime modifiedDate) {
        super(parent, name, size, creationTime);
        this.ownerName = ownerName;
        this.modifiedDate = modifiedDate;
    }

    // get childern that return all ApfsElement
    public LinkedList<ApfsElement> getChildren() {
        return this.ApfsChildren;
    }

    // add child
    public void appendChild(ApfsElement child) {
        this.ApfsChildren.add(child);
    }

    // is Directory
    public boolean isDirectory() {
        return false;
    };
    // is File
    public boolean isFile() {
        return false;
    }
    // is Link
    public boolean isLink() {
        return false;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}