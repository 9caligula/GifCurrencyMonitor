package lesniak.com.GifCurrencyMonitor.client;

import lesniak.com.GifCurrencyMonitor.constants.Constants;
import lesniak.com.GifCurrencyMonitor.entity.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@FeignClient(name = "ExchangeRatesService", url = Constants.exchangeRatesUrl)
public interface ExchangeRatesFeignClient {

    @GetMapping("/latest.json")
    ExchangeRates getLatest(@RequestParam("app_id") String appId);

    @GetMapping("/historical/{date}.json")
    ExchangeRates getHistorical(
            @RequestParam("app_id") String appId,
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @PathVariable("date") Date date
    );

}
