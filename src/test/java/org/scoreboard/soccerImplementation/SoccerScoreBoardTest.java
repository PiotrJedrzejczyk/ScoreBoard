package org.scoreboard.soccerImplementation;

import org.junit.jupiter.api.Test;
import org.scoreboard.exceptions.IncorrectScoreProvided;
import org.scoreboard.exceptions.MatchAlreadyStartedException;
import org.scoreboard.exceptions.MatchNotFoundException;
import org.scoreboard.interfaces.Match;

import static org.junit.jupiter.api.Assertions.*;

class SoccerScoreBoardTest {

    @Test
    void cannotStartMatchTwice () {
        SoccerScoreBoard soccerScoreBoard = new SoccerScoreBoard();
        Exception exception = new Exception();
        try {
            Match match = new SoccerMatch("A", "B") ;

            soccerScoreBoard.startGame(match);
            //starting match twice
            soccerScoreBoard.startGame(match);

        } catch (Exception e ) {
           exception = e;
        }
        assertEquals(MatchAlreadyStartedException.class, exception.getClass());
    }

    @Test
    void cannotFinishMatchTwice () {
        SoccerScoreBoard soccerScoreBoard = new SoccerScoreBoard();
        Exception exception = new Exception();
        try {
            Match match = new SoccerMatch("A", "B") ;

            soccerScoreBoard.startGame(match);
            //finishing match twice
            soccerScoreBoard.finishGame(match);
            soccerScoreBoard.finishGame(match);

        } catch (Exception e ) {
            exception = e;
        }
        assertEquals(MatchNotFoundException.class, exception.getClass());
    }

    @Test
    void cannotUpdateNonExistingMatch () {
        SoccerScoreBoard soccerScoreBoard = new SoccerScoreBoard();
        Exception exception = new Exception();
        try {
            Match match = new SoccerMatch("A", "B") ;

            soccerScoreBoard.startGame(match);
            //updating on existing match twice
            soccerScoreBoard.updateScore(
                    new SoccerMatch("C", "D"),
                    new SoccerScore(new int [] {0,1}));


        } catch (Exception e ) {
            exception = e;
        }
        assertEquals(MatchNotFoundException.class, exception.getClass());
    }

    @Test
    void newScoreLowerThenPrevious () {
        SoccerScoreBoard soccerScoreBoard = new SoccerScoreBoard();
        Exception exception = new Exception();
        try {
            Match match = new SoccerMatch("A", "B") ;

            soccerScoreBoard.startGame(match);
            soccerScoreBoard.updateScore(
                    match,
                    new SoccerScore(new int [] {0,1}));
            soccerScoreBoard.updateScore(
                    match,
                    new SoccerScore(new int [] {0,0}));

        } catch (Exception e ) {
            exception = e;
        }
        assertEquals(IncorrectScoreProvided.class, exception.getClass());
    }

    @Test
    void newScoreIsSameThenPrevious () {
        SoccerScoreBoard soccerScoreBoard = new SoccerScoreBoard();
        Exception exception = new Exception();
        try {
            Match match = new SoccerMatch("A", "B") ;

            soccerScoreBoard.startGame(match);
            soccerScoreBoard.updateScore(
                    match,
                    new SoccerScore(new int [] {0,1}));
            soccerScoreBoard.updateScore(
                    match,
                    new SoccerScore(new int [] {0,1}));

        } catch (Exception e ) {
            exception = e;
        }
        assertEquals(IncorrectScoreProvided.class, exception.getClass());
    }

}