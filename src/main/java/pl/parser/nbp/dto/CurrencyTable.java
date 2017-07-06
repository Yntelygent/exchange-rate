package pl.parser.nbp.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by radek on 04.07.17.
 */
@XmlRootElement
public class CurrencyTable {

    private String table;
    private String currency;
    private String code;
    private List<CurrencyRate> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CurrencyRate> getRates() {
        return rates;
    }

    public void setRates(List<CurrencyRate> rates) {
        this.rates = rates;
    }
}
