package implementation;
import java.util.Random;
import java.util.HashSet;

public class InheritanceRandom extends Random
{
    private final String[] rank = {"2", "3", "4","5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final String[] suit = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private final String[] color = {"Black", "Red"};

    public InheritanceRandom()
    {
        super();
    }

    public void drawCard(int count)
    {
        HashSet<String> seenCards = new HashSet<String>();
        int noColors = 2;
        int noRanks = 12;
        int noSuits = 4;

        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++)
        {
            boolean seenCard = true;
            while(seenCard)
            {
                index = nextInt(noColors);
                sb.append(color[index] + " ");

                index = nextInt(noRanks);
                sb.append(rank[index] + " ");

                index = nextInt(noSuits);
                sb.append(suit[index]);

                String card = sb.toString();
                sb.delete(0, sb.length());

                if (!seenCards.contains(card))
                {
                    seenCards.add(card);
                    System.out.println("Card " + (i + 1) + ": " + card);
                    seenCard = false;
                }
            }
        }
    }
}

