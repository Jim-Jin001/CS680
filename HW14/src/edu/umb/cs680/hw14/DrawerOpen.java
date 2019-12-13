package edu.umb.cs680.hw14;

public class DrawerOpen implements State {
    private DrawerOpen() {};
	
	private static DrawerOpen instance = null;
	
	public static DrawerOpen getInstance( ) {
		if (instance == null) {
            instance = new DrawerOpen();
        }
		return instance;
	}
	
	@Override
	public void playButtonPushed() {
		DVDPlayer.close();
		DVDPlayer.play();
		DVDPlayer.changeState(DrawerClosedPlaying.getInstance());

	}
	@Override
	public void openCloseButtonPushed() {
		DVDPlayer.close();
		DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
	}

	@Override
	public void stopButtonPushed() {
    }
}