package org.scoreboard.soccerImplementation;

import org.scoreboard.exceptions.BoardException;
import org.scoreboard.exceptions.IncorrectScoreProvided;
import org.scoreboard.exceptions.MatchAlreadyStartedException;
import org.scoreboard.exceptions.MatchNotFoundException;
import org.scoreboard.interfaces.Match;
import org.scoreboard.interfaces.Score;
import org.scoreboard.interfaces.ScoreBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
* Score Board implementation for Soccer games. it is leveraging HashMap to store the data of all matches
* and their scores. HashMap key is a concatenation of team names.
* */

public class SoccerScoreBoard implements ScoreBoard {

    private HashMap<String, SoccerMatch> boardStore;

    public SoccerScoreBoard() {
        boardStore = new HashMap<>();
    }

    @Override
    public void startMatch(Match match) throws BoardException {
        if (boardStore.get(match.getMatchId()) != null)
            throw new MatchAlreadyStartedException(match.getMatchId() + " already started");

        boardStore.put(match.getMatchId(), (SoccerMatch) match);
    }

    @Override
    public void updateScore(Match game, Score score) throws BoardException {
        SoccerMatch match = boardStore.get(game.getMatchId());
        if (match == null ) {
            throw new MatchNotFoundException(game.getMatchId() + " not found.");
        } else {
            /*
            * Scores cannot contain negative numbers
            * */
            if(((SoccerScore)score).getHomeScore() < 0 ||
                    ((SoccerScore)score).getAwayScore()<0    )
                throw new IncorrectScoreProvided("Score cannot be lower then zero.");
            /*
            * Check score content : cannot be lower than the last
            * */
            SoccerScore lastScore = (SoccerScore) game.getLastScore();
            int lastScoreCount =lastScore.getAwayScore()+lastScore.getHomeScore();
            int newScoreCount = ((SoccerScore)score).getAwayScore() + ((SoccerScore)score).getHomeScore();
            if (newScoreCount <= lastScoreCount)
                throw new IncorrectScoreProvided("Score for " + game.getMatchId() + " is incorrect.");
            match.updateScore(score);
        }
    }

    @Override
    public void finishMatch(Match game) throws BoardException {
        SoccerMatch match = boardStore.get(game.getMatchId());
        if (match == null ) {
            throw new MatchNotFoundException(game.getMatchId() + " not found.");
        } else {
            boardStore.remove(game.getMatchId());
        }
    }

    /*
    * As per the requirements list of games is sorted  by a total score of both team,
    * in case of a tie, recently updates match is presented.
    * */
    @Override
    public List getMatches() {
        List<SoccerMatch> list = new ArrayList<>(boardStore.values());
        Collections.sort(list);
        return list;
    }
}
