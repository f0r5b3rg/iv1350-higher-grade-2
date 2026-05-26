package implementation;
import java.util.Random;
import java.util.HashSet;

public class CompositionRandom
{
    private final Random random;
    private final String[] ranks = {"2", "3", "4","5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final String[] suits = {"Black Spades", "Red Hearts", "Red Diamonds", "Black Clubs"};
    private final int noRanks = ranks.length;
    private final int noSuits = suits.length;

    public CompositionRandom()
    {
        this.random = new Random();
    }

    public void drawCard(int count)
    {
        if (count > 52 || count < 1)
        {
            throw new IllegalArgumentException("Card count must be between 1 and 52");
        }

        HashSet<String> seenCards = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int index;

        for (int i = 0; i < count; i++)
        {
            while(true)
            {
                index = random.nextInt(noSuits);
                sb.append(suits[index]).append(" ");

                index = random.nextInt(noRanks);
                sb.append(ranks[index]);

                String card = sb.toString();
                sb.delete(0, sb.length());

                if (seenCards.add(card))
                {
                    System.out.println("Card " + (i + 1) + ": " + card);
                    break;
                }
            }
        }
    }
}
