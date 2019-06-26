import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Card {

    private String cardCode;
    private static String SPADES = "S";
    private static String CLUBS = "C";
    private static String DIAMONDS = "D";
    private static String HEARTS = "H";
    private static String JACK = "J";
    private static String QUEEN = "Q";
    private static String KING = "K";
    private static String ACE = "A";

    private HashMap<String, Integer> alphabeticCardValue = createCardMap();

    Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode;
        validateCard(cardCode);
    }

    private void validateCard(String cardCode) {
        validateCardColor();
        validateCardValue(cardCode);
    }

    private void validateCardColor() {
        String cardColor = this.cardCode.substring(0, 1).toUpperCase();

        List<String> cardColors = new ArrayList<String>() {{
            add(SPADES);
            add(CLUBS);
            add(DIAMONDS);
            add(HEARTS);
        }};

        if (!cardColors.contains(cardColor)) {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }
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
