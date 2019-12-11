package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;


public class ApfsElementTest {

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
    public void getChildrenTest() {
        ApfsElement apfse1 = new ApfsElement(null, "root", 0, testDate1, "admin", testDate2);
        apfse1.appendChild(root);
        apfse1.appendChild(home);
        apfse1.appendChild(applications);
        apfse1.appendChild(code);
        apfse1.appendChild(a);
        apfse1.appendChild(b);
        apfse1.appendChild(c);
        apfse1.appendChild(d);
        apfse1.appendChild(e);
        apfse1.appendChild(f);
        apfse1.appendChild(x);
        apfse1.appendChild(y);
        LinkedList<ApfsElement> apfsChildren = apfse1.getChildren();
        ApfsElement[] actual = apfsChildren.toArray(new ApfsElement[apfsChildren.size()]);
        ApfsElement[] expected = {root,
                            home,
                            applications,
                            code,
                            a,
                            b,
                            c,
                            d,
                            e,
                            f,
                            x,
                            y};
        assertArrayEquals(actual, expected);
    }
}