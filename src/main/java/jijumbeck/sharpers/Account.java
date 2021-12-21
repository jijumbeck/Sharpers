package jijumbeck.sharpers;

/*
Account - сущность, представляющая счет очков у игрока.

getNumberOfPoints - getter для numberOfPoints.
addPoints - добавялет очки счету игрока.
stealPoints - вычитает украденные очки у аккаунта игрока.
 */
public class Account {
    private int numberOfPoints;

    Account() {
        numberOfPoints = 0;
    }

    Account(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    synchronized int getNumberOfPoints() {
        return numberOfPoints;
    }

    synchronized void addPoints(int points) {
        if(points < 0) {
            throw new IllegalArgumentException("Number of points is negative.");
        }

        numberOfPoints += points;
    }

    synchronized int stealPoints(int points) {
        if(points < 0) {
            throw new IllegalArgumentException("Number of points is negative.");
        }

        if(points > numberOfPoints) {
            points = numberOfPoints;
        }

        numberOfPoints -= points;

        return points;
    }
}
