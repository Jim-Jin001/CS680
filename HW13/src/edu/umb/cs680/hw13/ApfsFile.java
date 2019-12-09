package edu.umb.cs680.hw13;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

    // constructor
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
                    String ownerName, LocalDateTime modifiedDate){
        super(parent, name, size, creationTime, ownerName, modifiedDate);
    }

    // is file
    @Override
    public boolean isFile() {
        return true;
    }
}