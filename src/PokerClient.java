import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
//        Card highCard = new Card("s2");
        List<Card> myDeck = createMyDeck();
        List<Card> oppDeck = createOppDeck(p1, p2, p3, p4, p5);

        Iterator<Card> myIterator = myDeck.iterator();
        Iterator<Card> oppIterator = oppDeck.iterator();

        while (myIterator.hasNext()) {
            while (oppIterator.hasNext()) {
                if (myIterator.next().getValue() > oppIterator.next().getValue()) {
                    oppIterator.remove();
                } else {
                    myIterator.remove();
                }
            }
        }

//        for (Card myCard : myDeck) {
//            for (Card oppCard : oppDeck) {
//                if (oppCard.getValue() >= myCard.getValue()) {
//                    if (oppCard.getValue() >= highCard.getValue()) {
//                        highCard = oppCard;
//                    }
//                } else {
//                    if (myCard.getValue() > highCard.getValue()) {
//                        highCard = myCard;
//                    }
//                }
//            }
//        }
//        return myDeck.contains(highCard);

        return !myDeck.isEmpty();
    }

    private List<Card> createOppDeck(String p1, String p2, String p3, String p4, String p5) {
        List<Card> o = new ArrayList<>();
        o.add(new Card(p1.toUpperCase()));
        o.add(new Card(p2.toUpperCase()));
        o.add(new Card(p3.toUpperCase()));
        o.add(new Card(p4.toUpperCase()));
        o.add(new Card(p5.toUpperCase()));
        return o;
    }

    private List<Card> createMyDeck() {
        List<Card> m = new ArrayList<>();
        m.add(card1);
        m.add(card2);
        m.add(card3);
        m.add(card4);
        m.add(card5);
        return m;
    }

}