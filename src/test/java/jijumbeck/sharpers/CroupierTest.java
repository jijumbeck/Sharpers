package jijumbeck.sharpers;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CroupierTest {
    @Test
    void ctorCroupierShouldThrowIllegalArgumentExceptionOnNegativeCountOfSharpers() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Croupier(1, -1);
        });
    }

    @Test
    void ctorCroupierShouldThrowIllegalArgumentExceptionOnCountOfPlayersLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Croupier(0, 1);
        });
    }

    @Test
    void croupierGiveAnotherPlayerShouldReturnPLayerNotSharper() {
        Croupier croupier = new Croupier(
                (new Random()).nextInt(100) + 1,
                (new Random()).nextInt(100));

        Sharper sharper = null;

        for (Player player : croupier.players) {
            if(player.getClass() == Sharper.class) {
                sharper = (Sharper)player;
                break;
            }
        }

        assertEquals(Player.class, croupier.giveAnotherPlayer(sharper).getClass());
    }

    @Test
    void croupierGiveAnotherPlayerShouldThrowIllegalCallerExceptionOnNoMoreOnePlayers() {
        Croupier croupier = new Croupier(
                (new Random()).nextInt(100) + 1,
                (new Random()).nextInt(100));

        Sharper sharper = null;

        for (Player player : croupier.players) {
            if(player.getClass() == Sharper.class) {
                sharper = (Sharper)player;
                break;
            }
        }

        croupier.players = new Player[0];

        Sharper finalSharper = sharper;

        assertThrows(IllegalCallerException.class, () -> {
            croupier.giveAnotherPlayer(finalSharper);
        });
    }
}
