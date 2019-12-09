package edu.umb.cs680.hw09;

import java.util.ArrayList;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor {

	private String item;
	private ArrayList<ApfsFile> files= new ArrayList<ApfsFile>();
	
	public ApfsFileCrawlingVisitor(String item) {
		this.item = item;
	}
	
 	@Override
	public void visit(ApfsLink link) {
		return;	
	}

	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}

	@Override
	public void visit(ApfsFile file) {
		if (file.getName().contains(item)) {
            files.add(file);
        }
	}
	public ArrayList<ApfsFile> getFiles() {
		return files;	
	}

}