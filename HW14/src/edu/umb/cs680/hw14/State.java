  package edu.umb.cs680.hw14;

public interface State {
    
    public DVDPlayer player =DVDPlayer.getInstance();
    public void openCloseButtonPushed();
    public void playButtonPushed();
    public void stopButtonPushed(); 
	
}