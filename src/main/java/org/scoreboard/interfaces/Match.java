package org.scoreboard.interfaces;

/*
* Interface providing high level functions to handle game manipulations.
* */

public interface Match {

    public void updateScore(Score score);
    public Score getLastScore();
    public String getMatchId();
}
