public class DeckofStrings {
    final String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
    final String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[] deck; 

    public DeckofStrings() {
        deck = new String[7];
        String s;
        for (int i = 0; i < 7; i++) {
            s = values[(int) (Math.random()*13)] + " of " + suits[(int) (Math.random()*4)];
            while (duplicate(s)) {
                s = values[(int) (Math.random()*13)] + " of " + suits[(int) (Math.random()*4)];
            }
            deck[i] = s;
        }
    }

    public DeckofStrings(int n) {
        if (n <= 0) {
            n = 7; // Instead of error, turns it into default cause
        }

        deck = new String[n];
        for (int i = 0; i < n; i++) {
            deck[i] = values[(int) (Math.random()*14)] + " of " + suits[(int) (Math.random()*5)];
        }
    }

    public String[] getDeck() {
        return deck;
    }

    public void printDeck() {
        System.out.println("You have the following cards in your deck:\n");
        for (int i = 0 ; i < deck.length; i++) {
            System.out.println(deck[i]);
        }
    }

    // replaces the card at index i
    public void newCard(int i) {
        if (i >= 0 && i < deck.length) {
            deck[i] = values[(int) (Math.random()*14)] + " of " + suits[(int) (Math.random()*5)];
        }
    }

    // checks to make sure card in String s not already in deck
    public boolean duplicate(String s) {
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == s) {
                return true;
            }
        }
        return false;
    }

    // swaps the card in the a index with the card in the b index
    public void swapCards(int a, int b) {
        if (a < 0 || a > deck.length || b < 0 || b > deck.length || a == b) {
            System.out.println("Invalid index");
            return;
        }
        String temp = deck[a];
        deck[a] = deck[b];
        deck[b] = temp;
    }

    // Rearrangles cards in deck randomly
    public void reshuffleRandom() {
        int index;
        String temp;
        // For every cards, picks a random card in the deck and swaps them (Should be enough for random)
        for (int i = 0; i < deck.length; i++) {
            index = (int) Math.random() * deck.length;
            swapCards(i, index);
        }
    }
}