package app.model;

import lombok.Data;

import java.util.List;

@Data
public class OandaResponse {
    List<Candle> candles;
    String granularity;
    String instrument;
}
