package org.scoreboard.service;

/*
* This is a simple implementation of the mock up of score feed service for a single game
* */

import org.scoreboard.interfaces.Match;
import org.scoreboard.interfaces.ScoreBoard;
import org.scoreboard.soccerImplementation.SoccerMatch;
import org.scoreboard.soccerImplementation.SoccerScore;

public class EventFeed extends Thread{

    ScoreBoard boardDao;
    String home;
    String away;
    String gameid;
    public EventFeed (ScoreBoard board, String home, String away) {
        super();
        this.boardDao = board;
        this.home=home;
        this.away=away;
        gameid = home+"-"+away;
    }

    /*
    * Randomizer giving 50/50 chance for home and away to score.
    * */
    public SoccerScore simulateScore (SoccerScore score) {
        int home = score.getHomeScore();
        int away = score.getAwayScore();

        if (Math.random()*10 >5) {
            home +=1;
        } else {
            away +=1;
        }
        score = new SoccerScore(new int[]{home, away});
        return score;
    }

    public void run () {
        try {
            Match game = new SoccerMatch(home, away);
            boardDao.startGame(game);
            for (int i = 0; i < 10; i++) {
                boardDao.updateScore(game, simulateScore((SoccerScore) game.getLastScore()));
                Thread.sleep((long)(Math.random()*2500));
            }
            boardDao.finishGame(game);

        } catch ( Exception e) {
            System.out.println(e.toString());
        }
    }
}
