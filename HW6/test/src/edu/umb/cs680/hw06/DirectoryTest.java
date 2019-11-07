package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class DirectoryTest {

    private LocalDateTime testDate = LocalDateTime.now();
    private String[] dirToStringArray(Directory d) {
        String[] dirInfo = {String.valueOf(d.isFile()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), d.getParent().getName(), String.valueOf(d.isDirectory())};
        return dirInfo;
    }

    @Test
    public void  verifyDirectoryEqualityRoot() {
        String[] expected = {"false", "root", "0", testDate.toString(), "root", "true"};
        Directory dir = new Directory(null, "root", 0, testDate);
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(actual, expected);
    }
}