package lesniak.com.GifCurrencyMonitor.client;

import lesniak.com.GifCurrencyMonitor.constants.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "GiphyService", url = Constants.giphyUrl)
public interface GiphyFeignClient {

    @GetMapping("/random")
    Map fetchRandomGif(
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag
    );

}
