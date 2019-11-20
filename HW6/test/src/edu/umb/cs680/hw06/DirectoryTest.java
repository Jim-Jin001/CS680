package edu.umb.cs680.hw06;

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
public class DirectoryTest {

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

    private String[] dirToStringArray(Directory d) {
        String parentName = null;
        Directory parent = d.getParent();
        if(parent != null) {
            parentName = parent.getName();
        }
        // isFile, getName, getSize, getCreationTime, getParent, isDirectory,
        // getTotalSize,countChildren
        String[] dirInfo = {String.valueOf(d.isFile()), d.getName(), Integer.toString(d.getSize()),
                d.getCreationTime().toString(), parentName, String.valueOf(d.isDirectory()),
                Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren())};
        return dirInfo;
    }

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
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"false", "Root", "0", testDate1.toString(), null, "true", "21", "2"};
        Directory dir = root;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = { "false", "Home", "0", testDate1.toString(), "Root", "true", "18", "3"};
        Directory dir = home;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(actual, expected);
    }

    @Test
    public void verifyDirectoryEqualityCode() {
        String[] expected = { "false", "Code", "0", testDate2.toString(), "Home", "true", "11", "2"};
        Directory dir = code;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(actual, expected);
    }
}