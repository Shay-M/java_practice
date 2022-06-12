package io.nice.wealthrating.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CentralBankService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Value("${url.wealth.threshold}")
	private String urlWealthThreshold;
	
	@Value("${url.evaluate.city}")
	private String urlEvaluateCity;

	public long getCityEvaluation(String city) {
		return restTemplate.getForObject(urlEvaluateCity + city , Long.class);
	}
	
	public long getWealthThreshold() {
		return restTemplate.getForObject(urlWealthThreshold, Long.class);
	}
	
	
}
