package jijumbeck.sharpers;

/*
Sharper - сущность шулера.

stolePoints - украсть очки у другого player'а.
 */
public class Sharper extends Player {
    protected static final int LOWER_BOARDER_OF_SLEEP_TIME_AFTER_STEALING = 180;
    protected static final int DIFFERENCE_BETWEEN_LOWER_AND_UPPER_BOARDERS_OF_SLEEP_TIME_AFTER_STEALING = 120;


    Sharper(Croupier croupier) {
        super(croupier);
    }

    public void stolePoints() {
        Player anotherPlayer = croupier.giveAnotherPlayer(this);
        int numberOfPoints = randomizer.nextInt(8);
        account.addPoints(anotherPlayer.account.stealPoints(numberOfPoints));
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try{
                int index = randomizer.nextInt(10);
                if(index < 6) {
                    addNewCard();
                    Thread.sleep(randomizer.nextInt(100) + 100);
                } else {
                    stolePoints();
                    Thread.sleep(
                            randomizer.nextInt(DIFFERENCE_BETWEEN_LOWER_AND_UPPER_BOARDERS_OF_SLEEP_TIME_AFTER_STEALING)
                                    + LOWER_BOARDER_OF_SLEEP_TIME_AFTER_STEALING);
                }
            } catch (InterruptedException ex) {
                break;
            }
        }
    }
}
