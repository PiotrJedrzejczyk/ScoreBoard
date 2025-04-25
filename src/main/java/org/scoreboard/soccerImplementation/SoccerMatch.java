package org.scoreboard.soccerImplementation;

import org.scoreboard.interfaces.Match;
import org.scoreboard.interfaces.Score;

import java.util.HashMap;

public class SoccerMatch implements Comparable<SoccerMatch>, Match {
    private String away;
    private String home;
    private SoccerScore score;
    private HashMap<Long, Score> matchHistory;

    public long getLastUpdate() {
        return lastUpdate;
    }

    private long lastUpdate; // last score update in milliseconds

    public SoccerMatch(String home, String away) {
        this.away = away;
        this.home = home;
        lastUpdate = System.currentTimeMillis();
        this.score = new SoccerScore();
        matchHistory = new HashMap<Long, Score>();
        matchHistory.put(lastUpdate, score);
    }

    public void updateScore(Score newScore) {
        this.score = (SoccerScore) newScore;
        lastUpdate = System.currentTimeMillis();
        matchHistory.put(lastUpdate, newScore);
    }

    public Score getLastScore () {
        return score;
    }


    public String getMatchId() {
        return home + "-" + away;
    }

    @Override
    public int compareTo(SoccerMatch match) {

        int totalThis = this.score.getHomeScore() + this.score.getAwayScore();
        int totalThat = match.score.getHomeScore() + match.score.getAwayScore();

        if (totalThis> totalThat) return -1;
        if (totalThis< totalThat) return 1;
        if (this.getLastUpdate() > match.getLastUpdate()) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return home + "-" + away + " : " + score.getHomeScore() + "-" + score.getAwayScore();
    }

}
