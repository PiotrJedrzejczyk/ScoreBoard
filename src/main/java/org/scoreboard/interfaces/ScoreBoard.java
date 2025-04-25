package org.scoreboard.interfaces;

import java.util.List;

public interface ScoreBoard {

    public void startGame(Match match);
    public void updateScore(Match match, Score score) ;
    public void finishGame(Match match);
    public List getGames();
}
