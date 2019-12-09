package edu.umb.cs680.hw13;

import java.time.LocalDateTime;

public class APFS extends FileSystem {
    private static LocalDateTime date = LocalDateTime.now();
    private static APFS instance = null;
    private static ApfsDirectory root; 

    private APFS(){}

    public static APFS getInstance() {
		if (instance == null) {
			instance = new APFS();
		}
		return instance;
    }
    
    protected FSElement createDefaultRoot() {
        APFS.root = new ApfsDirectory(null, "root", 0, date,
                "admin", date);
        return APFS.root;
    }

    public static ApfsDirectory getRootDir() {
        return root;
    }
}