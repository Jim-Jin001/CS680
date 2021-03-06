package edu.umb.cs680.hw16;

import java.util.LinkedList;

public abstract class FileSystem {
    protected static String name;
    protected static int capacity;
    protected static int id;
    private LinkedList<FSElement> rootDirs = new LinkedList<FSElement>();;

    // abstract createDefaultRoot
    protected abstract FSElement createDefaultRoot();

    // init
    public FSElement initFileSystem(String name, int capacity) {
		FileSystem.name = name;
        FileSystem.capacity = capacity;
        
        FSElement root = createDefaultRoot();
        if(root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            FileSystem.id = root.hashCode();
            return root;
        } else {
            return null;
        }
    }

    // set root
    protected void setRoot(FSElement root) {
        rootDirs.add(root);
    }
    
    // get name
    public static String getName() {
        return name;
    }

    // get capacity
    public static int getCapacity() {
        return capacity;
    }

    // get id
    public static int getId() {
        return id;
    }
    
}