package edu.umb.cs680.hw09;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {

    // target
    private ApfsElement target;


    // constructor
    public ApfsLink(ApfsDirectory parent, 
                    String name, 
                    int size, 
                    LocalDateTime creationTime, 
                    ApfsElement target, 
                    String ownerName, 
                    LocalDateTime modifiedDate) {
        super(parent, name, size, creationTime, ownerName, modifiedDate);
        this.target = target;
    }
    // is link
    @Override
    public boolean isLink() {
        return true;
    }

    // get target size
    public int getTargetSize(){
        if(target.isDirectory()) {
            return ((ApfsDirectory) target).getTotalSize();
        } else if(target.isLink()) {
            return 0;
        } else {
            return target.getSize();
        }
    }

    // check if target is link or not.
    public boolean targetisLink() {
        return target.isLink();
    }
    // check if target is file or not.
    public boolean targetisFile() {
        return target.isFile();
    }
    // check if target is Directory or not.
    public boolean targetisDirectory() {
        return target.isDirectory();
    }
    // set target
    public void setTarget(ApfsElement target){
        this.target = target;
    }
    // get target
    public ApfsElement getTarget(){
        return this.target;
    }
    //acept visitor
    public void accept(ApfsFSVisitor v) {
        v.visit(this);
    }
}