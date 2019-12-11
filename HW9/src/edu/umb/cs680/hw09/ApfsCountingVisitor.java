package edu.umb.cs680.hw09;


public class ApfsCountingVisitor implements ApfsFSVisitor {
	int directoryNum = 0;
	int fileNum = 0;
	int linkNum = 0;

	@Override
	public void visit(ApfsDirectory directory) {
		directoryNum++;
	}

	@Override
	public void visit(ApfsFile file) {
		fileNum++;
	}
	
	@Override
	public void visit(ApfsLink link) {
		linkNum++;
	}
	
	public int getDirectoryNum() {
		return this.directoryNum;
	}
	
	public int getFileNum() {
		return this.fileNum;
	}
	public int getLinkNum() {
		return this.linkNum;
	}

}