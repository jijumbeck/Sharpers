package jijumbeck.sharpers;

import java.util.Random;

/*
Card - сущность карты со случайным количеством очков.

getDenomination - getter для количество очков карты.
 */
public class Card {
    private Random randomizerOfDenomination = new Random();
    private static final int UPPER_BOUND_OF_RANDOM_DENOMINATION = 10;
    private final int denomination;

    Card() {
        denomination = randomizerOfDenomination.nextInt(UPPER_BOUND_OF_RANDOM_DENOMINATION) + 1;
    }

    public int getDenomination() {
        return denomination;
    }
}
