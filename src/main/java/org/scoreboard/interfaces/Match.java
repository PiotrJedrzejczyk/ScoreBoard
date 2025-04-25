package org.scoreboard.interfaces;

public interface Match {

    public void updateScore(Score score);
    public Score getLastScore();
    public String getMatchId();
}
