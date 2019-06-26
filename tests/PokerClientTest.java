import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {
//    private PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");

    @Test
    void highestCardIsMine_CorrectData_true() {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertTrue(pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sj"));
    }

    @Test
    void highestCardIsMine_CorrectData_false() {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cj");
        assertFalse(pokerClient.highestCardIsMine("s3", "h4", "s5", "d6", "sq"));
    }

    @Test
    void highestCardIsMine_InvalidCardColor() {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertThrows(IllegalArgumentException.class , () -> pokerClient.highestCardIsMine("rf", "ss", "56", "v5", "zz"));
    }

    @Test
    void highestCardIsMine_InvalidCardNumber() {
        PokerClient pokerClient = new PokerClient("h3", "d2", "s3", "s4", "cq");
        assertThrows(IllegalArgumentException.class, () -> pokerClient.highestCardIsMine("s99", "h44", "s55", "d67", "sj"));
    }

    @Test
    void constructor_withNull() {
        assertThrows(NullPointerException.class, () -> new PokerClient(null, null, null, null, null));
    }

    @Test
    void constructor_InvalidColor() {
        assertThrows(IllegalArgumentException.class, () -> new PokerClient("rf", "ss", "56", "v5", "zz"));
    }

    @Test
    void constructor_InvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new PokerClient("s99", "h44", "s55", "d67", "sj"));
    }
}