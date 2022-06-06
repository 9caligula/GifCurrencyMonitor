package lesniak.com.GifCurrencyMonitor.service;

import com.alibaba.fastjson.JSONObject;
import lesniak.com.GifCurrencyMonitor.client.GiphyFeignClient;
import lesniak.com.GifCurrencyMonitor.constants.Constants;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GiphyService {

    @Autowired
    private final GiphyFeignClient giphyFeignClient;

    public String fetchLinkToGif(String tag) {
        if (tag.equals(Constants.giphyError)) {
            return Constants.giphyErrorLink;
        }
        JSONObject jsonObject = new JSONObject(giphyFeignClient.fetchRandomGif(Constants.giphyApiKey, tag));
        return jsonObject.getJSONObject("data")
                .getJSONObject("images")
                .getJSONObject("original")
                .getString("url");
    }
}
