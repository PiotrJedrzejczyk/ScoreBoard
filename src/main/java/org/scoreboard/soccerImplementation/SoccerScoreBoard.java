package org.scoreboard.soccerImplementation;

import org.scoreboard.interfaces.Match;
import org.scoreboard.interfaces.Score;
import org.scoreboard.interfaces.ScoreBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SoccerScoreBoard implements ScoreBoard {

    private HashMap<String, SoccerMatch> boardStore;

    public SoccerScoreBoard() {
        boardStore = new HashMap<>();
    }

    @Override
    public void startGame(Match match) {

        boardStore.put(match.getMatchId(), (SoccerMatch) match);
    }

    @Override
    public void updateScore(Match game, Score score) {
        SoccerMatch match = boardStore.get(game.getMatchId());
        if (match == null ) {
            System.out.println(game.getMatchId() + " not found.");
        } else {
            match.updateScore(score);
        }
    }

    @Override
    public void finishGame(Match game) {
        SoccerMatch match = boardStore.get(game.getMatchId());
        if (match == null ) {
            System.out.println(game.getMatchId() + " not found.");
        } else {
            boardStore.remove(game.getMatchId());
        }
    }

    @Override
    public List getGames() {
        List<SoccerMatch> list = new ArrayList<>(boardStore.values());
        Collections.sort(list);
        return list;
    }
}
