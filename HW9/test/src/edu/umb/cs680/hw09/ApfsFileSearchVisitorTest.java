package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class ApfsFileSearchVisitorTest {
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

    @Test
    public void fileSearchATest() {
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");
        root.accept(visitor);
        LinkedList<ApfsFile> files =  visitor.getFoundFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected= {a};
        assertArrayEquals(actual, expected);
    }
    @Test
    public void fileSearchBTest() {
        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("b");
        root.accept(visitor);
        LinkedList<ApfsFile> files =  visitor.getFoundFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected= {b};
        assertArrayEquals(actual, expected);
    }
}
