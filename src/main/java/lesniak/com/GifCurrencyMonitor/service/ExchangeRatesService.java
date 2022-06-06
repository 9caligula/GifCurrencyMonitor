package lesniak.com.GifCurrencyMonitor.service;

import lesniak.com.GifCurrencyMonitor.client.ExchangeRatesFeignClient;
import lesniak.com.GifCurrencyMonitor.constants.Constants;
import lesniak.com.GifCurrencyMonitor.entity.ExchangeRates;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class ExchangeRatesService {

    @Autowired
    private final ExchangeRatesFeignClient exchangeRatesFeignClient;

    public ExchangeRates fetchCurrencies() {
        return exchangeRatesFeignClient.getLatest(Constants.exchangeRatesAppId);
    }

    public String fetchTagForGif(String code) {
        Double todayRate = getRates(code, Constants.TimeConstants.getYesterday(0));
        Double yesterdayRate = getRates(code, Constants.TimeConstants.getYesterday(-1));
        if (todayRate != null && yesterdayRate != null) {
            if (todayRate > yesterdayRate) {
                return Constants.giphyBroke;
            } else {
                return Constants.giphyRich;
            }
        }
        return Constants.giphyError;
    }

    public Double getRates(String code, Date date) {
        if (code != null) {
            ExchangeRates yesterdayExchangeRates = exchangeRatesFeignClient.getHistorical(Constants.exchangeRatesAppId, date);
            return yesterdayExchangeRates.getRates().get(code);
        }
        return null;
    }
}
