package jijumbeck.sharpers;

import java.util.*;

/*
Croupier - сущность крупье, который контролирует всю игру: всех игроков и время.

deck - колода карт
players - все игроки
timerForCroupier - таймер для крупье.

printAllPlayers - вывести всех игроков.
printWinners - вывести победителей.
 */
public class Croupier {
    Deck deck;
    Player[] players;
    Timer timerForCroupier;

    public Croupier(int countOfPlayers, int countOfSharpers) {
        if((countOfPlayers < 0) || (countOfSharpers < 0)) {
            throw new IllegalArgumentException("Argument is negative.");
        }

        if(countOfPlayers < 1) {
            throw new IllegalArgumentException("Wrong number of players.");
        }

        players = new Player[countOfPlayers + countOfSharpers];

        for (int i = 0; i < countOfPlayers; ++i) {
            players[i] = new Player(this);
        }

        for (int i = 0; i < countOfSharpers; ++i) {
            players[i + countOfPlayers] = new Sharper(this);
        }

        deck = new Deck();

        timerForCroupier = new Timer();
        timerForCroupier.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Player player : players) {
                    player.start();
                }
            }
        }, 0);
        timerForCroupier.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Player player : players) {
                    player.interrupt();
                }
                printAllPlayers();
                printWinners();
                System.exit(0);
            }
        }, 10000);
    }

    Player giveAnotherPlayer(Sharper currentPLayer) {
        if(players.length <= 1) {
            throw new IllegalCallerException();
        }

        Player anotherPlayer = currentPLayer;
        Random random = new Random();

        while (anotherPlayer == currentPLayer) {
            anotherPlayer = players[random.nextInt(players.length - 1)];
            if(anotherPlayer.getClass() == Sharper.class) {
                anotherPlayer = currentPLayer;
            }
        }

        return anotherPlayer;
    }

    private int getMaximumAccount() {
        if(players == null) {
            throw new NullPointerException();
        }

        if(players.length == 0) {
            throw new UnsupportedOperationException();
        }

        int maximumPoints = -1;
        for (Player player : players) {
            if(player.getAccount() > maximumPoints) {
                maximumPoints = player.getAccount();
            }
        }

        return maximumPoints;
    }

    public void printAllPlayers() {
        if(players == null) {
            throw new NullPointerException();
        }

        int count = 1;
        for (Player player : players) {
            System.out.println(count + ". Player №" + count + " with " + player.getAccount() + " points");
            ++count;
        }
    }

    public void printWinners() {
        if(players == null) {
            throw new NullPointerException();
        }

        int maximum = getMaximumAccount();
        int count = 1;
        for (Player player : players) {
            if(player.getAccount() == maximum) {
                System.out.println(count + ". Winner №" + count + " with " + player.getAccount() + " points");
                ++count;
            }
        }
    }
}
