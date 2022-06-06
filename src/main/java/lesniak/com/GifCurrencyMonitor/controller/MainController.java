package lesniak.com.GifCurrencyMonitor.controller;

import lesniak.com.GifCurrencyMonitor.constants.Constants;
import lesniak.com.GifCurrencyMonitor.service.ExchangeRatesService;
import lesniak.com.GifCurrencyMonitor.service.GiphyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MainController {

    @Autowired
    private final GiphyService giphyService;
    @Autowired
    private final ExchangeRatesService exchangeRatesService;

    @GetMapping({"/", "/currencies"})
    public String fetchCurrencies(Model model) {
        model.addAttribute("currencies", exchangeRatesService.fetchCurrencies().getRates().keySet());
        return "currencies";
    }

    @GetMapping("/getGif/{code}")
    public String fetchGif(@RequestParam String code, Model model) {
        model.addAttribute("yesterday", exchangeRatesService.getRates(code, Constants.TimeConstants.getYesterday(-1)));
        model.addAttribute("today", exchangeRatesService.getRates(code, Constants.TimeConstants.getYesterday(0)));
        model.addAttribute("code", code);
        model.addAttribute("getGif", giphyService.fetchLinkToGif(exchangeRatesService.fetchTagForGif(code)));
        return "getGif";
    }
}
