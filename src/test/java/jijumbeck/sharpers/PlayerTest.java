package jijumbeck.sharpers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class PlayerTest {
    @Test
    void playerGetAccountShouldReturnCorrectNumberOfPoints() {
        int numberOfPoints = new Random().nextInt(20000);
        Player newPlayer = new Player(new Croupier(2, 1));
        newPlayer.account.addPoints(numberOfPoints);

        assertEquals(numberOfPoints, newPlayer.getAccount());
    }
}
