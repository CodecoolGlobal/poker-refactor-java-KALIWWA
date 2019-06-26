import java.util.HashMap;

class Card {

    private String cardCode;
    private final String SPADES = "S";
    private final String CLUBS = "C";
    private final String DIAMONDS = "D";
    private final String HEARTS = "H";
    private final String JACK = "J";
    private final String QUEEN = "Q";
    private final String KING = "K";
    private final String ACE = "A";

    private HashMap<String, Integer> alphabeticCardValue = createCardMap();

    Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;

        validateCard(cardCode);
    }

    private void validateCard(String cardCode) {
        validateCardColor();
        validateCardValue(cardCode);
    }

    private void validateCardValue(String cardCode) {
        String cardValue = cardCode.substring(1).toUpperCase();
        int intCardValue;

        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            intCardValue = Integer.parseInt(cardValue);
            if (intCardValue > 10) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }
            if (intCardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }

        }
    }

    private void validateCardColor() {
        String cardColor = this.cardCode.substring(0, 1).toUpperCase();

        if (!cardColor.contentEquals(SPADES) &&
                !cardColor.contentEquals(CLUBS) &&
                !cardColor.contentEquals(DIAMONDS) &&
                !cardColor.contentEquals(HEARTS)) {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }
    }

    int getValue() {

        String cardValue = cardCode.substring(1).toUpperCase();
        Integer intCardValue;

        if (alphabeticCardValue.get(cardCode.substring(1).toUpperCase()) == null) {
            intCardValue = Integer.parseInt(cardValue);
        } else {
            intCardValue = alphabeticCardValue.get(cardCode.substring(1).toUpperCase());
        }

        return intCardValue;
    }

    private HashMap<String, Integer> createCardMap() {
        return new HashMap<String, Integer>() {{
            put(JACK, 11);
            put(QUEEN, 12);
            put(KING, 13);
            put(ACE, 14);
        }};
    }
}
