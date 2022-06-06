package lesniak.com.GifCurrencyMonitor.constants;

import java.util.Calendar;
import java.util.Date;

public interface Constants {

    String exchangeRatesAppId = "fc64900efb1848dbbc427e1013956709";
    String exchangeRatesUrl = "https://openexchangerates.org/api";

    String giphyApiKey = "WwCI1cR4vGtgySxqy5K1mFKe75u11tYC";
    String giphyUrl = "https://api.giphy.com/v1/gifs";

    String giphyBroke = "broke";
    String giphyRich = "rich";
    String giphyError = "error";

    String giphyErrorLink = "https://media4.giphy.com/media/YyKPbc5OOTSQE/giphy.gif?cid=790b76113e2e1de225fd2179310e908cc1001dcad5c274ec&rid=giphy.gif&ct=g";

    interface TimeConstants {

        static Date getYesterday(int day) {
            if (day <= 0) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.DATE, day);
                return cal.getTime();
            }
            return null;
        }
    }
}
