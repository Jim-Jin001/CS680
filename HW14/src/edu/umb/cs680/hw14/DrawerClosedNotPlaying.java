package edu.umb.cs680.hw14;

public class DrawerClosedNotPlaying implements State {

	private DrawerClosedNotPlaying() {};
	
	private static DrawerClosedNotPlaying instance = null;
	
	public static DrawerClosedNotPlaying getInstance() {
		if (instance == null) { 
			instance = new DrawerClosedNotPlaying();	
		}
		return instance;
	}
	

	@Override
	public void openCloseButtonPushed() {
		player.open();
		player.changeState(DrawerOpen.getInstance());			
	}

	@Override
	public void playButtonPushed() {
	}

	@Override
	public void stopButtonPushed() {
	}
}