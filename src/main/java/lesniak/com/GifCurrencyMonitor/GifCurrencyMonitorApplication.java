package lesniak.com.GifCurrencyMonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GifCurrencyMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifCurrencyMonitorApplication.class, args);
	}

}
