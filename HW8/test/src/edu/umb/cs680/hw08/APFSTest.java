package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class APFSTest {

    private String[] apfsElementToArray(ApfsElement e) {
        // 
        String[] eInfo = {e.getName(), 
                            e.getOwnerName(), 
                            Integer.toString(e.getSize())};
        return eInfo;
    }
    @Test
    public void sameAPFSTest() {
        APFS APFS1 = APFS.getInstance();
        APFS APFS2 = APFS.getInstance();
        assertSame(APFS1, APFS2);
    }

    @Test
    public void getRootDirTest() {
        APFS APFS1 = APFS.getInstance();
        APFS1.initFileSystem("myapfs", 100);
        String[] actual = this.apfsElementToArray(APFS1.getRootDir());
        String[] expected = {"myapfs", "admin", "0"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void createDefaultRootTest() {
        APFS APFS1 = APFS.getInstance();
        ApfsDirectory root = APFS1.getRootDir();
        String[] actual = this.apfsElementToArray(APFS1.getRootDir());
        String[] expected = {"myapfs", "admin", "0"};
        assertArrayEquals(actual, expected);
    }

}