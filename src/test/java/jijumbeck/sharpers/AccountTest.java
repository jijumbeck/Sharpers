package jijumbeck.sharpers;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    @Test
    void accountAddPointsShouldThrowIllegalArgumentExceptionOnNegativePoints() {
        Account account = new Account();

        assertThrows(IllegalArgumentException.class, () -> {
            account.addPoints(-1);
        });
    }

    @Test
    void ctorAccountWithParameterShouldNotThrowException() {
        assertDoesNotThrow(() -> {
            new Account((new Random()).nextInt(20000));
        });
    }

    @Test
    void accountStealPointsShouldTrowIllegalArgumentExceptionOnNegativeNumberOfPoints() {
        assertThrows(IllegalArgumentException.class, () -> {
            Account account = new Account(new Random().nextInt(21000));
            account.stealPoints(-1);
        });
    }
}
