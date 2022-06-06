package lesniak.com.GifCurrencyMonitor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.util.Map;

@Data
@AllArgsConstructor
public class ExchangeRates {

    private String disclaimer;

    private String license;

    private BigInteger timestamp;

    private String base;

    private Map<String, Double> rates;
}
