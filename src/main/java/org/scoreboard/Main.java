package org.scoreboard;

import org.scoreboard.interfaces.Match;
import org.scoreboard.interfaces.ScoreBoard;
import org.scoreboard.soccerImplementation.SoccerMatch;
import org.scoreboard.soccerImplementation.SoccerScore;
import org.scoreboard.soccerImplementation.SoccerScoreBoard;

public class Main {
    public static void main(String[] args) {


        String home = "A";
        String away = "B";
        ScoreBoard boardDao = new SoccerScoreBoard();

        Match gameid = new SoccerMatch(home, away);
        Match gameid2 = new SoccerMatch("C", "D");
        try {
            boardDao.startGame(gameid);

            boardDao.startGame(gameid);
            boardDao.startGame(gameid2);
            boardDao.updateScore(gameid, new SoccerScore(new int[]{1, 0}));
            System.out.println(boardDao.getGames());
            boardDao.updateScore(gameid, new SoccerScore(new int[]{2, 0}));
            System.out.println(boardDao.getGames());
            boardDao.updateScore(gameid2, new SoccerScore(new int[]{1, 0}));
            System.out.println(boardDao.getGames());
            boardDao.updateScore(gameid, new SoccerScore(new int[]{2, 1}));
            System.out.println(boardDao.getGames());
            boardDao.updateScore(gameid2, new SoccerScore(new int[]{1, 1}));
            System.out.println(boardDao.getGames());
            boardDao.updateScore(gameid, new SoccerScore(new int[]{2, 2}));
            System.out.println(boardDao.getGames());
            boardDao.updateScore(gameid2, new SoccerScore(new int[]{2, 1}));
            System.out.println(boardDao.getGames());
            boardDao.finishGame(gameid);
            System.out.println(boardDao.getGames());
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
    }
}