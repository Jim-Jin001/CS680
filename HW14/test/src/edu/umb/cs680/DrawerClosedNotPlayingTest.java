package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DrawerClosedNotPlayingTest {

    @Test
    public void sameInstanceTest() {
        DrawerClosedNotPlaying dcnp1= DrawerClosedNotPlaying.getInstance();
        DrawerClosedNotPlaying dcnp2 = DrawerClosedNotPlaying.getInstance();
        assertSame(dcnp1, dcnp2);
    }
    @Test
    public void openCloseButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        DrawerClosedNotPlaying.getInstance().openCloseButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerOpen.getInstance();
        assertEquals(actual,expected);
    }
    @Test
    public void playButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        DrawerClosedNotPlaying.getInstance().playButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
    @Test
    public void stopButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        DrawerClosedNotPlaying.getInstance().stopButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
}