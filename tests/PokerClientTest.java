import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {
    private PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");

    @Test
    void highestCardIsMine_CorrectData() {
        assertTrue(pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sj"));
    }

    @Test
    void highestCardIsMine_InvalidCardColor() {
        assertThrows(IllegalArgumentException.class , () -> pokerClient.highestCardIsMine("rf", "ss", "56", "v5", "zz"));
    }

    @Test
    void highestCardIsMine_InvalidCardNumber() {
        assertThrows(IllegalArgumentException.class, () -> pokerClient.highestCardIsMine("s99", "h44", "s55", "d67", "sj"));
    }
}