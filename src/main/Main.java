package main;
import implementation.CompositionCurrency;

public class Main
{

    public static void main(String[] args)
    {
        /*
        InheritanceRandom inheritanceRandom = new InheritanceRandom();
        inheritanceRandom.drawCard(4);
        */


       CompositionCurrency cc = new CompositionCurrency("mxn");
       try
       {
           cc.currentExchangeRateForSek();
       }
       catch(Exception e)
       {
           System.out.println("Unexpected issues " + e);
       }


    }
}



