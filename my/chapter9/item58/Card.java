package my.chapter9.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Card {
    private final Suit suit;
    private final Rank rank;

    enum Suit { A, B, C, D; }
    enum Rank { ONE, TWO, THREE, FOUR; }

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext();) {
            Suit s = i.next();
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext();) {
                deck.add(new Card(s, j.next()));
            }
        }
        for (Card c : deck) {
            System.out.println(c.suit + " " + c.rank);
        }
    }
}
