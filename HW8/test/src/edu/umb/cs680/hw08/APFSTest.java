package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class APFSTest {

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
        String actual = APFS.getName();
        String expected = "myapfs";
        assertSame(actual, expected);
    }

}