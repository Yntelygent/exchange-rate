package pl.parser.nbp;

/**
 * Created by radek on 05.07.17.
 */
public class MainClass {

    public static void main(String[] args) {

        CurrencyService currencyService = new CurrencyService();
        currencyService.calculateAverangeExchangeRate("EUR", "2013-01-28", "2013-01-31");

    }
}
