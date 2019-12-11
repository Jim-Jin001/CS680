package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class ApfsCountingVisitorTest {
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
    public void countingFileNumberTest() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int actual = visitor.getFileNum();
        int expected = 6; // a,b,c,d,e,f
        assertSame(actual, expected);
    }


    @Test
    public void countingLinkNumberTest() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int actual = visitor.getLinkNum();
        int expected = 2; // x, y
        assertSame(actual, expected);
    }

    @Test
    public void countingDirectoryNumberTest() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int actual = visitor.getDirectoryNum();
        int expected = 4; // root, Home, Applications, Code
        assertSame(actual, expected);
    }
}
