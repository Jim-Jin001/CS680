package edu.umb.cs680.hw13;
import java.util.Comparator;

public class ElementComparator implements Comparator<ApfsElement> 
{
    int fse1Value;
    int fse2Value;
    
	@Override
	public int compare(ApfsElement fse1, ApfsElement fse2) 
	{
        if(fse1.isDirectory()) {
            fse1Value = 1;
        } else if(fse1.isFile()){
            fse1Value = 2;
        } else if(fse1.isLink()){
            fse1Value = 3;
        }
        if(fse2.isDirectory()) {
            fse2Value = 1;
        } else if(fse2.isFile()){
            fse2Value = 2;
        } else if(fse2.isLink()){
            fse2Value = 3;
        }
        return ( (Integer) fse1Value).compareTo( (Integer) fse2Value);
	}
}