package jijumbeck.main_class;

import jijumbeck.sharpers.Croupier;

public class MainClass {
    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 100;

    public static void main(String[] args) {

        System.out.println("Welcome to 21!");

        System.out.println("Input number of fair players: (it must be > 0)");
        int countOfPlayers = ConsoleUI.getIntegerFromConsole(1, MAXIMUM_NUMBER_OF_PLAYERS);

        System.out.println("Input number of sharpers: (it must be non negative)");
        int countOfSharpers = ConsoleUI.getIntegerFromConsole(0, MAXIMUM_NUMBER_OF_PLAYERS);

        Croupier croupierOfTwentyOneGame = new Croupier(countOfPlayers, countOfSharpers);
    }

}
