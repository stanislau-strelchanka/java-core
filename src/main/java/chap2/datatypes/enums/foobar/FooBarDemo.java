package chap2.datatypes.enums.foobar;

/**
 * Created by Stas on 12/01/2015.
 */
public class FooBarDemo {

    public enum Suit {HEART, DIAMOND, CLUB, SPADE};
    public enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING};

    private final Suit suit;
    private final Rank rank;

    public FooBarDemo(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }
    public String toString() {
        return rank + " of " + suit;
    }

    public static void main(String... args) {
        FooBarDemo upMySleeve = new FooBarDemo(Suit.HEART, Rank.ACE);
        System.out.println("what is up my sleeve? " + upMySleeve);
        // outputs: what is up my sleeve? ACE of HEART

        Bar b = new Bar();
        Foo<Bar> f = b;

        Bar2 b2 = new Bar2();
        //Foo2<Bar> f = b; required Foo2<Bar>, found Bar2

        Bar2 bar = b2.subclassAwareDeepCopy();

    }

//    This is sort of what happens.

//    public class Suit extends Enum {
//        public static final Suit HEART = new Suit("HEART", 1);
//        public static final Suit DIAMOND = new Suit("DIAMOND", 2);
//        public static final Suit CLUB = new Suit("CLUB", 3);
//        public static final Suit SPADE = new Suit("SPADE", 4);
//
//        public Suit(String name, int ordinal) { super(name, ordinal);}
//
//        // some more stuff here
//    }

}
