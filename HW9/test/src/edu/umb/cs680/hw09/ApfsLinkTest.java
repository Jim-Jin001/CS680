package edu.umb.cs680.hw09;

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
public class ApfsLinkTest {

    static private LocalDateTime testDate1 = LocalDateTime.now();
    static private LocalDateTime testDate2 = LocalDateTime.now();
    static ApfsDirectory root = new ApfsDirectory(null, "root", 0, testDate1, "admin", testDate2);
    static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, testDate1, "admin", testDate2);
    static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, testDate1, "admin", testDate2);
    static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, testDate2, "admin", testDate2);
    static ApfsFile a = new ApfsFile(null, "a", 1, testDate1, "admin", testDate2);
    static ApfsFile b = new ApfsFile(null, "b", 2, testDate2, "admin", testDate2);
    static ApfsFile c = new ApfsFile(null, "c", 3, testDate1, "admin", testDate2);
    static ApfsFile d = new ApfsFile(null, "d", 4, testDate2, "admin", testDate2);
    static ApfsFile e = new ApfsFile(null, "e", 5, testDate2, "admin", testDate2);
    static ApfsFile f = new ApfsFile(null, "f", 6, testDate2, "admin", testDate2);
    static ApfsLink x = new ApfsLink(null, "x", 0, testDate1, null, "admin", testDate2);
    static ApfsLink y = new ApfsLink(null, "y", 0, testDate2, null, "admin", testDate2);

    @BeforeAll
    static void init() {
        // append child directory to root
        root.appendChild(home);
        root.appendChild(applications);
        // append child directory to home
        home.appendChild(code);
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
    @Order(1)
    @Test
    public void verifyLinkTest() {
        Boolean actual = x.isLink();
        Boolean expected = true;
        assertSame(actual, expected);
    }
    @Order(2)
    @Test
    public void verifyTargetSizeTest() {
        int actual = x.getTargetSize();
        int expected = 3;
        assertSame(actual, expected);
    }
    @Order(3)
    @Test
    public void verifyTargetIsLinkTest() {
        Boolean actual = x.targetisLink();
        Boolean expected = false;
        assertSame(actual, expected);
    }
    @Order(4)
    @Test
    public void verifyTargetIsFileTest() {
        Boolean actual = x.targetisFile();
        Boolean expected = false;
        assertSame(actual, expected);
    }
    @Order(5)
    @Test
    public void verifyTargetIsDirectoryTest() {
        Boolean actual = x.targetisDirectory();
        Boolean expected = true;
        assertSame(actual, expected);
    }
    @Order(6)
    @Test
    public void setTargetTest() {
        x.setTarget(code);
        ApfsElement actual = x.getTarget();
        ApfsDirectory expected = code;
        assertSame(actual, expected);
    }
    @Order(7)
    @Test
    public void verifyLinkEqualityX() {
        ApfsDirectory expected = code;
        ApfsElement actual = x.getTarget();
        assertSame(actual, expected);
    }
    @Order(8)
    @Test
    public void verifyLinkEqualityY() {
        ApfsFile expected = b;
        ApfsElement actual = y.getTarget();
        assertSame(actual, expected);
    }
}