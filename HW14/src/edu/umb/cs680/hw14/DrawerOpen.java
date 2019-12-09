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
		player.close();
		player.play();
		player.changeState(DrawerClosedPlaying.getInstance());

	}
	@Override
	public void openCloseButtonPushed() {
		player.close();
		player.changeState(DrawerClosedNotPlaying.getInstance());
	}

	@Override
	public void stopButtonPushed() {
    }
}