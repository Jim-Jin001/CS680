package edu.umb.cs680.hw14;

public class DVDPlayer {
	
	private static DVDPlayer instance = null;
	public static State state;
	
	private DVDPlayer() {
	};
	public static DVDPlayer getInstance() {
		if (instance == null) {
			instance = new DVDPlayer();
			state = DrawerClosedNotPlaying.getInstance();
		}
		return instance;
	}
	public static State getState() {
		return DVDPlayer.state;
	}
	public static State changeState(State state) {
		DVDPlayer.state = state;
		return DVDPlayer.state;
	}
	public static void openCloseButtonPushed() {
		state.openCloseButtonPushed();
	}
	public static void playButtonPushed() {
		state.playButtonPushed();
	}
	public static void stopButtonPushed() {
		state.stopButtonPushed();
	}
	public static void open() {
		System.out.print("DVD player opened");
	}
	public static void close() {
		System.out.print("DVD player closed");
	}
	public static void play() {
		System.out.print("DVD player playing");
	}
	public static void stop() {
		System.out.print("DVD player stopped");
	}
}