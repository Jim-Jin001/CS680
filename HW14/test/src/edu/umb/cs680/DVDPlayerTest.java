package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class DVDPlayerTest {
    @Test
    public void sameInstanceTest() {
        DVDPlayer dvdlayer1= DVDPlayer.getInstance();
        DVDPlayer dvdlayer2 = DVDPlayer.getInstance();
        assertSame(dvdlayer1, dvdlayer2);
    }

    @Test
    public void changeStateTest() {
        State actual = DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
    @Test
    public void openCloseButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        DVDPlayer.openCloseButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerOpen.getInstance();
        assertEquals(actual,expected);
    }
    @Test
    public void playButtonPushedTest() {
        DVDPlayer.changeState(DrawerOpen.getInstance());
        DVDPlayer.playButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedPlaying.getInstance();
        assertEquals(actual,expected);
    }
    @Test
    public void stopButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
        DVDPlayer.stopButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
}