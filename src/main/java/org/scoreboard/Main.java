package org.scoreboard;

import org.scoreboard.interfaces.Match;
import org.scoreboard.interfaces.ScoreBoard;
import org.scoreboard.service.EventFeed;
import org.scoreboard.service.SimpleUI;
import org.scoreboard.soccerImplementation.SoccerMatch;
import org.scoreboard.soccerImplementation.SoccerScore;
import org.scoreboard.soccerImplementation.SoccerScoreBoard;

import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {

        ScoreBoard boardDao = new SoccerScoreBoard();

        SimpleUI ui = new SimpleUI(boardDao);


        try {
            EventFeed eventFeed = new EventFeed(boardDao, "Poland", "England");
            EventFeed eventFeed1 = new EventFeed(boardDao, "Germany", "France");
            EventFeed eventFeed2 = new EventFeed(boardDao, "Spain", "Italy");
            EventFeed eventFeed3 = new EventFeed(boardDao, "Ireland", "Norway");
            EventFeed eventFeed4 = new EventFeed(boardDao, "Denmark", "Finland");
            EventFeed eventFeed5 = new EventFeed(boardDao, "Brazil", "Romania");

            eventFeed.start();
            eventFeed1.start();
            eventFeed2.start();
            eventFeed3.start();
            eventFeed4.start();
            eventFeed5.start();

            Thread.sleep(100);
            while (!boardDao.getMatches().isEmpty()) {
                ui.updateText();
                Thread.sleep(100);
            }
            ui.updateText();
        } catch ( Exception e) {
            System.out.println(e.getMessage());

        }


    }
}