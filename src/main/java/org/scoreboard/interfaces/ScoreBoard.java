package org.scoreboard.interfaces;

import org.scoreboard.exceptions.BoardException;

import java.util.List;

public interface ScoreBoard {

    public void startGame(Match match) throws BoardException;
    public void updateScore(Match match, Score score) throws BoardException;
    public void finishGame(Match match)throws BoardException;
    public List getGames();
}
