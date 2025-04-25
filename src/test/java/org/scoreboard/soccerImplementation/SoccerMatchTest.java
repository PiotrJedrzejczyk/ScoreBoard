package org.scoreboard.soccerImplementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoccerMatchTest {

    @Test
    void matchCompareTest1 () {
        SoccerMatch match1 = new SoccerMatch("A", "B");
        SoccerMatch match2 = new SoccerMatch("C", "D");
        match1.updateScore(new SoccerScore(new int[]{1,0}));
        //match 1 is on top of the list so compare method should return -1
        assertEquals(-1, match1.compareTo(match2));

    }
    @Test
    void matchCompareTest2 () {
        SoccerMatch match1 = new SoccerMatch("A", "B");
        SoccerMatch match2 = new SoccerMatch("C", "D");
        match1.updateScore(new SoccerScore(new int[]{1,0}));
        match2.updateScore(new SoccerScore(new int[]{1,0}));
        //match 2 has an ealier update so now match 1 should not be first
        assertNotEquals(-1, match1.compareTo(match2));

    }

    @Test
    void matchCompareTest3 () {
        SoccerMatch match1 = new SoccerMatch("A", "B");
        SoccerMatch match2 = new SoccerMatch("C", "D");
        match1.updateScore(new SoccerScore(new int[]{1,0}));
        match2.updateScore(new SoccerScore(new int[]{1,0}));
        match1.updateScore(new SoccerScore(new int[]{2,0}));
        //Now match1 has again a high a total amount of scored goals and it should be first
        assertEquals(-1, match1.compareTo(match2));

    }

    @Test
    void matchIdvalidation () {
        SoccerMatch match = new SoccerMatch("A", "B");
        assertEquals("A-B", match.getMatchId());
    }
}