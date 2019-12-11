package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class ApfsFileTest {
    static private LocalDateTime testDate1 = LocalDateTime.now();
    static private LocalDateTime testDate2 = LocalDateTime.now();
    static ApfsDirectory root = new ApfsDirectory(null, "root", 0, testDate1, "admin", testDate2);
    static ApfsDirectory home = new ApfsDirectory(root, "Home", 0, testDate1, "admin", testDate2);
    static ApfsDirectory applications = new ApfsDirectory(root, "Applications", 0, testDate1, "admin", testDate2);
    static ApfsDirectory code = new ApfsDirectory(root, "Code", 0, testDate2, "admin", testDate2);
    static ApfsFile a = new ApfsFile(applications, "a", 1, testDate1, "admin", testDate2);
    static ApfsFile b = new ApfsFile(applications, "b", 2, testDate2, "admin", testDate2);
    static ApfsFile c = new ApfsFile(home, "c", 3, testDate1, "admin", testDate2);
    static ApfsFile d = new ApfsFile(home, "d", 4, testDate2, "admin", testDate2);
    static ApfsFile e = new ApfsFile(code, "e", 5, testDate2, "admin", testDate2);
    static ApfsFile f = new ApfsFile(code, "f", 6, testDate2, "admin", testDate2);
    static ApfsLink x = new ApfsLink(home, "x", 0, testDate1, null, "admin", testDate2);
    static ApfsLink y = new ApfsLink(code, "y", 0, testDate2, null, "admin", testDate2);

    private String[] fileToStringArray(ApfsFile f) {
        // isFile, getName, getSize, getCreationTime, getParentName, isDirectory
        String[] fileInfo = { String.valueOf(f.isFile()), 
                                f.getName(), 
                                Integer.toString(f.getSize()),
                                f.getCreateDate().toString(), 
                                f.getParent().getName(), 
                                String.valueOf(f.isDirectory()),
                                d.getOwnerName(),
                                d.getModifiedDate().toString() };
        return fileInfo;
    }

    @Test
    public void verifyFileEqualityA() {
        String[] expected = { "true", 
                                "a", 
                                "1", 
                                testDate1.toString(), 
                                "Applications", 
                                "false",
                                "admin",
                                testDate2.toString()};
        ApfsFile file = a;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityB() {
        String[] expected = { "true", 
                                "b", 
                                "2", 
                                testDate2.toString(), 
                                "Applications", 
                                "false",
                                "admin",
                                testDate2.toString() };
        ApfsFile file = b;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityC() {
        String[] expected = { "true", 
                                "c", 
                                "3", 
                                testDate1.toString(), 
                                "Home", 
                                "false",
                                "admin",
                                testDate2.toString()};
        ApfsFile file = c;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityD() {
        String[] expected = { "true", 
                                "d", 
                                "4", 
                                testDate2.toString(), 
                                "Home", 
                                "false",
                                "admin",
                                testDate2.toString()};
        ApfsFile file = d;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityE() {
        String[] expected = { "true", 
                                "e", 
                                "5", 
                                testDate2.toString(), 
                                "Code", 
                                "false",
                                "admin",
        testDate2.toString() };
        ApfsFile file = e;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyFileEqualityF() {
        String[] expected = { "true", 
                                "f", 
                                "6", 
                                testDate2.toString(),
                                "Code", 
                                "false",
                                "admin",
                                testDate2.toString() };
        ApfsFile file = f;
        String[] actual = fileToStringArray(file);
        assertArrayEquals(actual, expected);
    }
}
