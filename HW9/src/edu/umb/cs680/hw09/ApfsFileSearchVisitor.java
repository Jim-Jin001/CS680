package edu.umb.cs680.hw09;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsFSVisitor {
    
    private String fileName;
    private LinkedList<ApfsFile> foundFiles = new LinkedList<ApfsFile>();
    
    
    public ApfsFileSearchVisitor(String name) {
        this.fileName = name;
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
		if (file.getName().equals(fileName)) {
			foundFiles.add(file);
		}
	}
	
	public LinkedList<ApfsFile> getFoundFiles() {
		return this.foundFiles;
	}
}