package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DrawerClosedPlayingTest {

    @Test
    public void sameInstanceTest() {
        DrawerClosedPlaying dcp1= DrawerClosedPlaying.getInstance();
        DrawerClosedPlaying dcp2 = DrawerClosedPlaying.getInstance();
        assertSame(dcp1, dcp2);
    }
    @Test
    public void openCloseButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
        DrawerClosedPlaying.getInstance().openCloseButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedPlaying.getInstance();
        assertEquals(actual,expected);
    }
    @Test
    public void playButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
        DrawerClosedPlaying.getInstance().playButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedPlaying.getInstance();
        assertEquals(actual,expected);
    }
    @Test
    public void stopButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
        DrawerClosedPlaying.getInstance().stopButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
}