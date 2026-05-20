package implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Currency;
import java.net.URL;

public class CompositionCurrency
{
    private final Currency currency;
    private final String prefix = "SEK";
    private final String suffix = "PMI";
    private final String link = "https://api.riksbank.se/swea/v1/Observations/Latest/";

    public CompositionCurrency(String currencyCode)
    {
        this.currency = Currency.getInstance(currencyCode.toUpperCase());
    }

    public void currentExchangeRateForSek() throws IOException
    {
        String seriesId = prefix + currency.getCurrencyCode() + suffix;

        URL url = new URL(link + seriesId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode == 200)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String info = br.readLine();
            br.close();

            info = info.replace("}", "").replace("{", "").replaceAll(",", ", ").replaceAll("\"", "").replaceAll(":", ": ");
            System.out.println(info);

        }
        else
        {
            throw new IOException("Error: " + responseCode);
        }
    }

    public String getCurrencyCode()
    {
        return currency.getCurrencyCode();
    }

    public int getDefaultFractionDigits()
    {
        return currency.getDefaultFractionDigits();
    }

    public String getDisplayName()
    {
        return currency.getDisplayName();
    }

    public int getNumericCode()
    {
        return currency.getNumericCode();
    }

    public String getNumericCodeAsString()
    {
        return currency.getNumericCodeAsString();
    }

    public String getSymbol()
    {
        return currency.getSymbol();
    }

    public String toString()
    {
        return currency.toString();
    }

}