package pl.parser.nbp;

import pl.parser.nbp.dto.CurrencyTable;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Created by radek on 04.07.17.
 */
public class CurrencyClient {

    private Client client = ClientBuilder.newClient();
    private WebTarget webTarget = client.target("http://api.nbp.pl/api/exchangerates/rates/C/");

    public CurrencyTable requestTableByCurrencyAndDate(String code, String startDate, String endDate) {

        Response response =  webTarget.path("{code}/{startDate}/{endDate}")
                                            .resolveTemplate("code", code)
                                            .resolveTemplate("startDate", startDate)
                                            .resolveTemplate("endDate", endDate)
                                            .request()
                                            .get();

        if(response.getStatus() != 200) {
            throw new WebApplicationException(response);
        }

        return response.readEntity(CurrencyTable.class);

    }

}
