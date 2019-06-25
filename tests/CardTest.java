import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getValue_correctCapitalLetter() {
        Card card = new Card("HK");
        assertEquals(13, card.getValue());
    }

    @Test
    void getValue_correctSmallLetter() {
        Card card = new Card("hk");
        assertEquals(13, card.getValue());
    }

    @Test
    void getValue_correctNumber() {
        Card card = new Card("H3");
        assertEquals(3, card.getValue());
    }

    @Test
    void constructor_tooBigNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Card("H13"));
    }

    @Test
    void constructor_tooSmallNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Card("H0"));
    }

    @Test
    void constructor_withNull() {
        assertThrows(NullPointerException.class, () -> new Card(null));
    }

}