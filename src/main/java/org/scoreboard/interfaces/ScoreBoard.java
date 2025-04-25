package org.scoreboard.interfaces;

import org.scoreboard.exceptions.BoardException;

import java.util.List;

/*
* Interface provides key functions to interact with score board irrespectively of the type of games or data store used.
* */

public interface ScoreBoard {

    public void startGame(Match match) throws BoardException;
    public void updateScore(Match match, Score score) throws BoardException;
    public void finishGame(Match match)throws BoardException;
    public List getGames();
}
