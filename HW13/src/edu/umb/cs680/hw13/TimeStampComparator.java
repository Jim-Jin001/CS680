package edu.umb.cs680.hw13;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement> {

	@Override
	public int compare(ApfsElement o1, ApfsElement o2)
	{	
		return o2.getModifiedDate().compareTo(o1.getModifiedDate());
	}

}