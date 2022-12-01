package com.smallworldfs.tennis;

public class TennisGame{
    public Player player1;
    public Player player2;
    public Player winning;
    public Player losing;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String sameScore() {
        String score;
        score = player1.getsPoints() + "-All";
        return score;
    }

    public void determineSituation(Player player1, Player player2) {
        if (player1.getPoints() > player2.getPoints()) {
            winning = player1;
            losing = player2;
        } else {
            winning = player2;
            losing = player1;
        }
    }

    public String isGameStillGoingOn(Player winning, Player losing, String score) {
        if ((winning.getPoints() > 0 && losing.getPoints() == 0)
                || (losing.getPoints() > 0 && winning.getPoints() == 0)
                || (winning.getPoints() > losing.getPoints() && winning.getPoints() < 4)
                || (losing.getPoints() > winning.getPoints() && losing.getPoints() < 4)) {
            return player1.getsPoints() + "-" + player2.getsPoints();
        }
        return score;
    }

    public String setAdvantage(Player winning, Player losing) {
        if (winning.getPoints() > losing.getPoints() && losing.getPoints() >= 3) {
            return "Advantage ".concat(winning.getPlayerName());
        }
        return "";
    }

    public boolean isEndGameStage(Player player, Player other) {
        return player.getPoints() > 3 || other.getPoints() > 3 || (player.getPoints() == 3 && other.getPoints() == 3);
    }

    public String setWin(Player winning, Player losing, String score) {
        if (isEndGameStage(winning, losing)
                && winning.getPoints() >= 4 && losing.getPoints() >= 0
                && (winning.getPoints() - losing.getPoints()) >= 2) {
            return "Win for ".concat(winning.getPlayerName());
        }
        return score;
    }

    public String getScore() {
        determineSituation(player1, player2);
        String score = "";
        if ((player1.getPoints() == player2.getPoints() && player1.getPoints() < 4)) {
            score += sameScore();
        }
        if (player1.getPoints() == player2.getPoints() && player1.getPoints() >= 3)
            score = "Deuce";

        score = isGameStillGoingOn(winning, losing, score);

        score = score + setAdvantage(winning, losing);

        score = setWin(winning, losing, score);
        return score;
    }

    public void P1Score() {
        player1.setPoints(player1.getPoints() + 1);
    }

    public void P2Score() {
        player2.setPoints(player2.getPoints() + 1);
        ;
    }

    public void wonPoint(String player) {
        if (player1.getPlayerName().equals(player))
            P1Score();
        else
            P2Score();
    }
}
