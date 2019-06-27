import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class PokerClient {

    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;

    PokerClient(String p1, String p2, String p3, String p4, String p5) {
        this.card1 = new Card(p1.toUpperCase());
        this.card2 = new Card(p2.toUpperCase());
        this.card3 = new Card(p3.toUpperCase());
        this.card4 = new Card(p4.toUpperCase());
        this.card5 = new Card(p5.toUpperCase());
    }

    boolean highestCardIsMine(String p1, String p2, String p3, String p4, String p5) {
        List<Card> myDeck = createMyDeck();
        List<Card> oppDeck = createDeck(p1, p2, p3, p4, p5);
        int oppHighCardValue = 0;
        int myHighCardValue = 0;

        myHighCardValue = findHighCardValue(myDeck, myHighCardValue);
        oppHighCardValue = findHighCardValue(oppDeck, oppHighCardValue);

        return myHighCardValue > oppHighCardValue;

//        Iterator<Card> myIterator = myDeck.iterator();
//        Iterator<Card> oppIterator = oppDeck.iterator();
//
//        while ((myIterator.hasNext()) && (oppIterator.hasNext())) {
//            if (myIterator.next().getValue() > oppIterator.next().getValue()) {
//                oppIterator.remove();
//            } else {
//                myIterator.remove();
//            }
//            oppIterator = oppDeck.iterator();
//            myIterator = myDeck.iterator();
//
//        }
//        return myDeck.size() > oppDeck.size();
    }

    private int findHighCardValue(List<Card> myDeck, int myHighCardValue) {
        for (Card myCard : myDeck) {
            if (myCard.getValue() > myHighCardValue) {
                myHighCardValue = myCard.getValue();
            }
        }
        return myHighCardValue;
    }

    private List<Card> createDeck(String p1, String p2, String p3, String p4, String p5) {
        return new ArrayList<Card>() {{
            add(new Card(p1.toUpperCase()));
            add(new Card(p2.toUpperCase()));
            add(new Card(p3.toUpperCase()));
            add(new Card(p4.toUpperCase()));
            add(new Card(p5.toUpperCase()));
        }};
    }

    private List<Card> createMyDeck() {
        return createDeck(card1.toString(), card2.toString(), card3.toString(), card4.toString(), card5.toString());
    }

}