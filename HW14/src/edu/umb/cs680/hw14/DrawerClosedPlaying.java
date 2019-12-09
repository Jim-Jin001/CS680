package edu.umb.cs680.hw14;

public class DrawerClosedPlaying implements State {

	private DrawerClosedPlaying() {};
	
	private static DrawerClosedPlaying instance = null;
	
	public static DrawerClosedPlaying getInstance() {
		if (instance == null) 
			instance = new DrawerClosedPlaying();
		return instance;
	}
	

	@Override
	public void openCloseButtonPushed() {
	}

	@Override
	public void playButtonPushed() {
	}

	@Override
	public void stopButtonPushed() {
		player.stop();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}
}