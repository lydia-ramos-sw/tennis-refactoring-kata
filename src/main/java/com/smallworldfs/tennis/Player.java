package com.smallworldfs.tennis;

import java.util.HashMap;
import java.util.Map;

public class Player{
    String playerName;
    int points;
    String sPoints;
    public Map<Integer, String> pointsTranslations;


    public Player(String playerName) {
        this.playerName = playerName;
        pointsTranslations = new HashMap<Integer, String>();
        pointsTranslations.put(0, "Love");
        pointsTranslations.put(1, "Fifteen");
        pointsTranslations.put(2, "Thirty");
        pointsTranslations.put(3, "Forty");
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getsPoints() {
        return  pointsTranslations.get(this.points);
    }
}
