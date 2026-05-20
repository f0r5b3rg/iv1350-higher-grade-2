package main;
import implementation.InheritanceRandom;
import implementation.CompositionCurrency;

public class Main
{
    public static void main(String[] args)
    {
        InheritanceRandom random = new InheritanceRandom();
        CompositionCurrency currency = new CompositionCurrency("mxn");
       
        System.out.println("Inheritance test \n");
        random.drawCard(4);
    
        System.out.println("Composition test \n"); 
        try
        {
            currency.currentExchangeRateForSek();
        }
        catch(Exception e)
        {
            System.out.println("Unexpected issues " + e);
        }
    }
}
