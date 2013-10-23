package org.game;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BowlingTest {

    @Test
    public void testDoCountNoScore() {
        assertThat(Bowling.doCount("0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"),
                is(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    @Test
    public void testDoCountOnlyTens() {
        assertThat(Bowling.doCount("10", "10", "10", "10", "10", "10", "10",
                "10", "10", "10", "10", "10"),
                is(new int[]{30, 60, 90, 120, 150, 180, 210, 240, 270, 300}));
    }

    @Test
    public void testDoCountLastFrameWithoutStrike() {
        assertThat(Bowling.doCount("0", "0", "0", "1", "0", "0", "0", "6",
                "10", "0", "5", "0", "0", "0", "3", "5", "0", "6", "0"),
                is(new int[]{0, 1, 1, 7, 22, 27, 27, 30, 35, 41}));
    }

    @Test
    public void testDoCountLastFrameWithStrike() {
        assertThat(Bowling.doCount("5", "0", "7", "3", "3", "3", "9", "0",
                "1", "7", "7", "2", "3", "0", "10", "10", "10", "1", "9"),
                is(new int[]{5, 18, 24, 33, 41, 50, 53, 83, 104, 124}));
    }

    @Test
    public void testDoCountLastFrameWithSpare() {
        assertThat(Bowling.doCount("5", "0", "7", "3", "3", "3", "9", "0",
                "1", "7", "7", "2", "3", "0", "10", "10", "9", "1", "10"),
                is(new int[]{5, 18, 24, 33, 41, 50, 53, 82, 102, 122}));
    }

    @Test
    public void testNumberOfStrikesOk() {
        Bowling.doCount("5", "0", "7", "3", "3", "3", "9", "0",
                "1", "7", "7", "2", "3", "0", "10", "10", "9", "1", "10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoArguments() {
        Bowling.doCount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumInput() {
        Bowling.doCount("0", "0", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaximumInput() {
        Bowling.doCount("0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBigSumInOneFrame() {
        Bowling.doCount("9", "2", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBigSumInLastFrame() {
        Bowling.doCount("9", "1", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "5", "6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputSize() {
        Bowling.doCount("11", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputType() {
        Bowling.doCount("0", "string", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0");
    }

    @Test
    public void testFirstStrikeOnWrongPosition() {
        Bowling.doCount("0", "10", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValue() {
        Bowling.doCount("9", "-3", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStrikeOnWrongPosition() {
        Bowling.doCount("10", "0", "10", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastFrameSizeTwoSpare() {
        Bowling.doCount("0", "0", "0", "1", "0", "0", "0", "6", "10", "0",
                "5", "0", "0", "0", "3", "5", "0", "6", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastFrameSizeTwoStrike() {
        Bowling.doCount("0", "0", "0", "1", "0", "0", "0", "6", "10", "0",
                "5", "0", "0", "0", "3", "5", "0", "10", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastFrameSizeThreeNoSpare() {
        Bowling.doCount("0", "0", "0", "1", "0", "0", "0", "6", "10", "0",
                "5", "0", "0", "0", "3", "5", "0", "6", "2", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastFrameSizeThreeNoStrike() {
        Bowling.doCount("0", "0", "0", "1", "0", "0", "0", "6", "10", "0",
                "5", "0", "0", "0", "3", "5", "0", "1", "0", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNumberOfStrikes() {
        Bowling.doCount("10", "1", "0", "1", "0", "1", "0", "9", "0", "1",
                "1", "0", "2", "5", "4", "10", "4", "1", "2", "3", "0");
    }
}
