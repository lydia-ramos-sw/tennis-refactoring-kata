package com.smallworldfs.tennis;

import java.util.HashMap;
import java.util.Map;

public class TennisGame{

    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    public Map<Integer, String> pointsTranslations = new HashMap<Integer, String>();

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        loadPointsTranslations();
    }

    private void loadPointsTranslations() {
        pointsTranslations.put(0, "Love");
        pointsTranslations.put(1, "Fifteen");
        pointsTranslations.put(2, "Thirty");
        pointsTranslations.put(3, "Forty");
    }

    public String getScore() {
        String score = "";
        if (P1point == P2point && P1point < 4) {
            if (P1point == 0 || P1point == 1 || P1point == 2)
                score = pointsTranslations.get(P1point);
            score += "-All";
        }

        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        if (P1point > 0 && P2point == 0) {
            score = onePlayerScoresTheOtherDoesnt(score, P1point, P2point);
        }

        if (P2point > 0 && P1point == 0) {
            score = onePlayerScoresTheOtherDoesnt(score, P2point, P1point);
        }

        if (P1point > P2point && P1point < 4) {
            score = onePlayerIsWinning(score, P1point, P2point);
        }

        if (P2point > P1point && P2point < 4) {
            score = onePlayerIsWinning(score, P2point, P1point);
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String onePlayerScoresTheOtherDoesnt(String score, int PScorer, int PNonScorer) {
        if (PScorer == 1 || PScorer == 2 || PScorer == 3)
            fillPlayerPoints(PScorer == P1point, pointsTranslations.get(PScorer));

        fillPlayerPoints(PScorer != P1point, "Love");
        score = P1res + "-" + P2res;

        return score;
    }

    private String onePlayerIsWinning(String score, int PScorer, int PNonScorer) {
        if (PScorer == 2 || PScorer == 3)
            fillPlayerPoints(PScorer == P1point, pointsTranslations.get(PScorer));
        if (PNonScorer == 1 || PNonScorer == 2)
            fillPlayerPoints(PScorer != P1point, pointsTranslations.get(PNonScorer));
        score = P1res + "-" + P2res;
        return score;
    }

    private void fillPlayerPoints(boolean fillP1, String value) {
        if (fillP1) {
            P1res = value;
        } else {
            P2res = value;
        }
    }

    public void SetP1Score(int number) {
        for (int i = 0; i < number; i++) {
            P1Score();
        }
    }

    public void SetP2Score(int number) {
        for (int i = 0; i < number; i++) {
            P2Score();
        }
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
