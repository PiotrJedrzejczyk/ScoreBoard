package org.scoreboard.service;

import org.scoreboard.interfaces.ScoreBoard;
import org.scoreboard.soccerImplementation.SoccerMatch;
import org.scoreboard.soccerImplementation.SoccerScore;
import org.scoreboard.soccerImplementation.SoccerScoreBoard;

import javax.swing.*;
import java.util.List;

public class SimpleUI extends JFrame  {

    JFrame frame;
    JTextArea jTextField;
    ScoreBoard board;

    public SimpleUI (ScoreBoard board) {
        frame = new JFrame("World Cup Score board");
        this.board = board;
        jTextField = new JTextArea();
        frame.setSize(400,400);
        jTextField.setText(getGameString());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jTextField);
        frame.show();
    }

    public void updateText () {

        jTextField.setText(getGameString());
    }

    public String getGameString () {
        if (board.getGames().isEmpty()) return "No games in progress";
        List<SoccerMatch> games = board.getGames();
        String result = "";
        for (int i = 0 ; i< games.size(); i++) {
            result += games.get(i);
            result += "\n";
        }

        return result;
    }
}
