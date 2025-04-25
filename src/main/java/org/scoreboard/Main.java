package org.scoreboard;

import org.scoreboard.interfaces.Match;
import org.scoreboard.interfaces.ScoreBoard;
import org.scoreboard.service.EventFeed;
import org.scoreboard.soccerImplementation.SoccerMatch;
import org.scoreboard.soccerImplementation.SoccerScore;
import org.scoreboard.soccerImplementation.SoccerScoreBoard;

public class Main {
    public static void main(String[] args) {

        ScoreBoard boardDao = new SoccerScoreBoard();

        try {
            EventFeed eventFeed = new EventFeed(boardDao, "Poland", "England");
            EventFeed eventFeed1 = new EventFeed(boardDao, "Germany", "France");
            EventFeed eventFeed2 = new EventFeed(boardDao, "Spain", "Italy");

            eventFeed.start();
            eventFeed1.start();
            eventFeed2.start();
            Thread.sleep(100);
            while (!boardDao.getGames().isEmpty()) {
                System.out.println(boardDao.getGames());
                Thread.sleep(1000);
            }

        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
    }
}