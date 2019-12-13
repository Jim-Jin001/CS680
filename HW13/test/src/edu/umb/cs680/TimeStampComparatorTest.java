package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.BeforeAll;

import java.util.LinkedList;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimeStampComparatorTest {

    static private LocalDateTime testDate1 = LocalDateTime.of(2019, 12, 12, 10, 10);
    static private LocalDateTime testDate2 = LocalDateTime.of(2019, 12, 20, 10, 10);
    static ApfsDirectory root = new ApfsDirectory(null, "root", 0, testDate1, "admin", testDate1);
    static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, testDate1, "admin", testDate2);
    static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, testDate1, "admin", testDate1);
    static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, testDate2, "admin", testDate2);
    static ApfsDirectory barcode = new ApfsDirectory(null, "Barcode", 0, testDate2, "admin", testDate1);
    static ApfsFile a = new ApfsFile(null, "a", 1, testDate1, "admin", testDate1);
    static ApfsFile b = new ApfsFile(null, "b", 2, testDate2, "admin", testDate2);
    static ApfsFile c = new ApfsFile(null, "c", 3, testDate1, "admin", testDate1);
    static ApfsFile d = new ApfsFile(null, "d", 4, testDate2, "admin", testDate2);
    static ApfsFile e = new ApfsFile(null, "e", 5, testDate2, "admin", testDate1);
    static ApfsFile f = new ApfsFile(null, "f", 6, testDate2, "admin", testDate2);
    static ApfsLink x = new ApfsLink(null, "x", 0, testDate1, null, "admin", testDate1);
    static ApfsLink y = new ApfsLink(null, "y", 0, testDate2, null, "admin", testDate2);

    @BeforeAll
    static void init() {
        // append child directory to root
        root.appendChild(home);
        root.appendChild(applications);
        // append child directory to home
        home.appendChild(code);
        home.appendChild(barcode);
        //apend child file to applications
        applications.appendChild(a);
        applications.appendChild(b);
        // apend child file to home
        home.appendChild(c);
        home.appendChild(d);
        // apend child file to code
        code.appendChild(e);
        code.appendChild(f);
        // append link x to home
        home.appendChild(x);
        // append link y to code
        code.appendChild(y);
        // link x to application
        x.setTarget(applications);
        // link y to file b
        y.setTarget(b);
    }
    @Test
    public void GetChildrenTest() {
        ApfsDirectory dir = root;
        LinkedList<ApfsElement> actualList = dir.getChildren(new TimeStampComparator());
        ApfsElement[] actual = actualList.toArray(new ApfsElement[actualList.size()]);
        ApfsElement[] expected = {home, applications};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void getSubDirectoriesTest() {
        ApfsDirectory dir = home;
        LinkedList<ApfsDirectory> actualList = dir.getSubDirectories(new TimeStampComparator());
        ApfsDirectory[] actual = actualList.toArray(new ApfsDirectory[actualList.size()]);
        ApfsDirectory[] expected = {code, barcode};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void getFilesTest() {
        ApfsDirectory dir = home;
        LinkedList<ApfsFile> actualList = dir.getFiles(new TimeStampComparator());
        ApfsFile[] actual = actualList.toArray(new ApfsFile[actualList.size()]);
        ApfsFile[] expected = {d, c};
        assertArrayEquals(expected, actual);
    }
}