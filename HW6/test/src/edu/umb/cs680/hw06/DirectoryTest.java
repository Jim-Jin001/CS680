package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class DirectoryTest {
    private LocalDateTime testDate1 = LocalDateTime.now();
    private LocalDateTime testDate2 = LocalDateTime.now();
    Directory root = new Directory(null, "Root", 0, testDate1);
    Directory home = new Directory(root, "Home", 0, testDate1);
    Directory applications = new Directory(root, "Applications", 0, testDate1);
    Directory code = new Directory(home, "Code", 0, testDate2);
    File a = new File(applications, "a", 1, testDate1);
    File b = new File(applications, "b", 2, testDate2);
    File c = new File(home, "c", 3, testDate1);
    File d = new File(home, "d", 4, testDate2);
    File e = new File(code, "e", 5, testDate2);
    File f = new File(code, "f", 6, testDate2);

    private String[] dirToStringArray(Directory d) {
        String[] dirInfo = { String.valueOf(d.isFile()), d.getName(), Integer.toString(d.getSize()),
                d.getCreationTime().toString(), d.getParent().getName(), String.valueOf(d.isDirectory()),
                Integer.toString(d.getTotalSize())
                };
        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = { "false", "Root", "0", testDate1.toString(), "Root", "true", "21"};
        Directory dir = this.root;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = { "false", "Home", "0", testDate1.toString(), "Root", "true", "18" };
        Directory dir = this.home;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyDirectoryEqualityCode() {
        String[] expected = { "false", "Code", "0", testDate2.toString(), "Home", "true", "11" };
        Directory dir = this.code;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(actual, expected);
    }
}