package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    public boolean isLink() {
        return true;
    }
    public boolean isDirectory() {
        return false;
    }
    public boolean isFile() {
        return false;
    }
    public int getTargetSize(){
        return target.getSize();
    }
    public boolean targetisLink() {
        return target.isLink();
    }
    public boolean targetisFile() {
        return target.isFile();
    }
    public boolean targetisDirectory() {
        return target.isDirectory();
    }
    public void setTarget(FSElement target){
        this.target = target;
    }
    public FSElement getTarget(){
        return this.target;
    }
}