package edu.umb.cs680.hw07;

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
public class LinkTest {

    static private LocalDateTime testDate1 = LocalDateTime.now();
    static private LocalDateTime testDate2 = LocalDateTime.now();
    static Directory root = new Directory(null, "Root", 0, testDate1);
    static Directory home = new Directory(null, "Home", 0, testDate1);
    static Directory applications = new Directory(null, "Applications", 0, testDate1);
    static Directory code = new Directory(null, "Code", 0, testDate2);
    static File a = new File(null, "a", 1, testDate1);
    static File b = new File(null, "b", 2, testDate2);
    static File c = new File(null, "c", 3, testDate1);
    static File d = new File(null, "d", 4, testDate2);
    static File e = new File(null, "e", 5, testDate2);
    static File f = new File(null, "f", 6, testDate2);
    static Link x = new Link(null, "x", 6, testDate1, null);
    static Link y = new Link(null, "y", 6, testDate2, null);

    // private String[] dirToStringArray(Directory d) {
    //     String parentName = null;
    //     Directory parent = d.getParent();
    //     if(parent != null) {
    //         parentName = parent.getName();
    //     }
    //     // isFile, getName, getSize, getCreationTime, getParent, isDirectory,
    //     // getTotalSize,countChildren
    //     String[] dirInfo = {String.valueOf(d.isFile()), d.getName(), Integer.toString(d.getSize()),
    //             d.getCreationTime().toString(), parentName, String.valueOf(d.isDirectory()),
    //             Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren())};
    //     return dirInfo;
    // }

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

    @Test
    public void verifyLinkEqualityX() {
        Directory expected = applications;
        FSElement actual = x.getTarget();
        assertSame(actual, expected);
    }

    @Test
    public void verifyLinkEqualityY() {
        Directory expected = b;
        FSElement actual = x.getTarget();
        assertSame(actual, expected);
    }
}