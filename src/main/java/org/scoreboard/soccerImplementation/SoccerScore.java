package org.scoreboard.soccerImplementation;

import org.scoreboard.interfaces.Score;

/*
 * CLass to store soccer scores. Assumption made here is that
 * value at 0 index is for home team
 * value at 1 index is for away team
 * */

public class SoccerScore implements Score {

    private int [] score;

    public SoccerScore() {
        score = new int[]{0,0};
    }

    public SoccerScore(int [] newScore) {
        score = newScore;
    }

    public int getAwayScore () {
        return this.score[1];
    }

    public int getHomeScore () {
        return this.score[0];
    }
}
