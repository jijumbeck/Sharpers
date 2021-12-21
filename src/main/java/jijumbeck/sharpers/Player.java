package jijumbeck.sharpers;

import java.awt.image.CropImageFilter;
import java.util.Random;

/*
Player - сущность игрока, представляющая собой поток.

getAccount - getter для количества очков у игрока.
addNewCard - взять карту + добавить очки себе на баланс.
 */
public class Player extends Thread {
    protected Random randomizer = new Random();
    protected static final int LOWER_BOARDER_OF_SLEEP_TIME_AFTER_ADDING = 100;
    protected static final int DIFFERENCE_BETWEEN_LOWER_AND_UPPER_BOARDERS_OF_SLEEP_TIME_AFTER_ADDING = 100;

    protected Account account;
    protected Croupier croupier;

    public Player(Croupier croupier) {
        super();
        this.croupier = croupier;
        account = new Account();
    }

    public int getAccount() {
        return account.getNumberOfPoints();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try{
                addNewCard();
                Thread.sleep(
                        randomizer.nextInt(DIFFERENCE_BETWEEN_LOWER_AND_UPPER_BOARDERS_OF_SLEEP_TIME_AFTER_ADDING)
                                + LOWER_BOARDER_OF_SLEEP_TIME_AFTER_ADDING);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

    protected void addNewCard() {
        Card newCard = croupier.deck.getCard();
        account.addPoints(newCard.getDenomination());
    }
}
