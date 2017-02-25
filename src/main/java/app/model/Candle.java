package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class Candle {
    Boolean complete;
    Price mid;
    Instant time;
    Integer volume;

    @JsonProperty("time")
    public void setTime(String s) {
        s = s.substring(0,10);
        time = Instant.ofEpochSecond(Long.valueOf(s));
    }
}
