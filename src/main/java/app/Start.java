package app;

import app.model.Candle;
import app.model.OandaResponse;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Start {
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept-Datetime-Format", "UNIX");
        headers.set("Authorization", "Bearer b1bf8dfba206a68c8140b682fea3b81e-2a377d33deaf39c70b34197cbe506adb");


        HttpEntity<OandaResponse> entity = new HttpEntity<>(headers);
        String url = "https://api-fxpractice.oanda.com/v3/instruments/USD_PLN/candles?count=1000";
        ResponseEntity<OandaResponse> responseEntity =
                template.exchange(url, HttpMethod.GET, entity, OandaResponse.class);
        OandaResponse rr = responseEntity.getBody();
        for(Candle c : rr.getCandles()) {
            System.out.println(c);
        }

    }
}
