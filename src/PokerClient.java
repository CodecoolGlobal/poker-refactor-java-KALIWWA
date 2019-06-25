import java.util.ArrayList;
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
        Card hc = new Card("s2");
        List<Card> o = new ArrayList<>();
        List<Card> m = new ArrayList<>();
        o.add(new Card(p1.toUpperCase()));
        o.add(new Card(p2.toUpperCase()));
        o.add(new Card(p3.toUpperCase()));
        o.add(new Card(p4.toUpperCase()));
        o.add(new Card(p5.toUpperCase()));
        m.add(card1);
        m.add(card2);
        m.add(card3);
        m.add(card4);
        m.add(card5);

        for (Card mc : m) {
            for (Card oc : o) {
                int myCardValue = mc.getValue();
                int oppCardValue = oc.getValue();

                if (oppCardValue >= myCardValue) {
                    if (oppCardValue >= hc.getValue()) {
                        hc = oc;
                    }
                } else {
                    if (myCardValue > hc.getValue()) {
                        hc = mc;
                    }
                }
            }
        }

        return m.contains(hc);
    }

}