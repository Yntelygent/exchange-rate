package pl.parser.nbp;

import pl.parser.nbp.dto.CurrencyRate;
import pl.parser.nbp.dto.CurrencyTable;
import javax.ws.rs.WebApplicationException;
import java.math.BigDecimal;

/**
 * Created by radek on 05.07.17.
 */
public class CurrencyService {

    private CurrencyClient currencyClient = new CurrencyClient();

    public void calculateAverangeExchangeRate(String code, String startDate, String endDate) {

        try {

                CurrencyTable currencyTable = currencyClient.requestTableByCurrencyAndDate(code, startDate, endDate);
                BigDecimal ratesNumber = BigDecimal.valueOf(currencyTable.getRates().size());
                BigDecimal bidPriceSum = BigDecimal.ZERO;
                BigDecimal askPriceSum = BigDecimal.ZERO;
                BigDecimal stdDeviation = BigDecimal.ZERO;

                for (CurrencyRate cr : currencyTable.getRates()) {
                    bidPriceSum = bidPriceSum.add(cr.getBid());
                    askPriceSum = askPriceSum.add(cr.getAsk());
                }

                BigDecimal avgBidPrice = bidPriceSum.divide(ratesNumber);
                BigDecimal avgAskPrice = askPriceSum.divide(ratesNumber);

                for (CurrencyRate cr : currencyTable.getRates()) {
                    stdDeviation = stdDeviation.add(cr.getAsk().subtract(avgAskPrice).pow(2));
                }

                stdDeviation = BigDecimal.valueOf(Math.sqrt(stdDeviation.divide(ratesNumber).doubleValue()));

                System.out.println(avgBidPrice.setScale(4, BigDecimal.ROUND_HALF_UP));
                System.out.println(stdDeviation.setScale(4, BigDecimal.ROUND_HALF_UP));

            } catch (WebApplicationException e){
                System.out.println(e.getResponse().getStatusInfo().getReasonPhrase());
            }

    }
}
