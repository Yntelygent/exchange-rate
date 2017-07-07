package pl.parser.nbp;

/**
 * Created by radek on 05.07.17.
 */
public class MainClass {

    public static void main(String[] args) {

        CurrencyService currencyService = new CurrencyService();

        if(args.length > 2) {
            currencyService.calculateAverangeExchangeRate(args[0], args[1], args[2]);
        } else {
            System.out.println("Wprowadzono zbyt mało parametrów");
        }

    }
}
