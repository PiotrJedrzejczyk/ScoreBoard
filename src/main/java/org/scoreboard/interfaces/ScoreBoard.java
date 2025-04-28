package org.scoreboard.interfaces;

import org.scoreboard.exceptions.BoardException;

import java.util.List;

/*
* Interface provides key functions to interact with score board irrespectively of the type of matches or data store used.
* */

public interface ScoreBoard {

    public void startMatch(Match match) throws BoardException;
    public void updateScore(Match match, Score score) throws BoardException;
    public void finishMatch(Match match)throws BoardException;
    public List getMatches();
}
