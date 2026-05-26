package main;
import implementation.InheritanceRandom;
import implementation.CompositionCurrency;
import implementation.CompositionRandom;

public class Main
{
    public static void main(String[] args)
    {
        CompositionRandom cRandom = new CompositionRandom();
        InheritanceRandom iRandom = new InheritanceRandom();


        System.out.println("Composition test \n");
        cRandom.drawCard(52);
        System.out.println("\n");

        System.out.println("Inheritance test \n");
        iRandom.drawCard(53);
    }
}
