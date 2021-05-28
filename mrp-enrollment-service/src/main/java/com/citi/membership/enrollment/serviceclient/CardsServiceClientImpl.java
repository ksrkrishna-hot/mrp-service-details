package com.citi.membership.enrollment.serviceclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.citi.membership.enrollment.model.CardDetailsResponse;

public class CardsServiceClientImpl implements CardsServiceClient {

	public CardDetailsResponse getCardDetails(String cardNum) {
		// TODO : write rest client code to connect CardDetailsService and get the
		// details
		// String serviceUrl =
		// "http://localhost:9090/card-details-service-war-1.0-SNAPSHOT/v1/carddetails/232323232323232";

		// Entity = Http Response codes +response body
		CardDetailsResponse cardDetailsResponse = null;
		try {
			String env=System.getProperty("environment");
			System.out.println("environment :"+env);
			String filename = "properties/service/card-details-service-"+env+".properties";
			InputStream input = getClass().getClassLoader().getResourceAsStream(filename);

			Properties properties = new Properties();
			properties.load(input);
			String serviceUrl = properties.getProperty("service-url");
			System.out.println("service-url is" + serviceUrl);
			String timeout = properties.getProperty("service-timeout");
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/json");
			headers.set("clientId", "mrp");
			headers.set("requestId", UUID.randomUUID().toString().substring(0, 16));
			headers.set("msgTs", "21-05-2021");

			RestTemplate restTemplate = new RestTemplate();
			/*
			 * HttpComponentsClientHttpRequestFactory httpRequestFactory = new
			 * HttpComponentsClientHttpRequestFactory();
			 * httpRequestFactory.setConnectionRequestTimeout(1000);
			 * httpRequestFactory.setConnectTimeout(1000);
			 * httpRequestFactory.setReadTimeout(2000);
			 * restTemplate.setRequestFactory(httpRequestFactory);
			 */

			HttpEntity entity = new HttpEntity(headers);
			ResponseEntity<CardDetailsResponse> response = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity,
					CardDetailsResponse.class);
			cardDetailsResponse = null;
			if (response != null && response.getStatusCode().is2xxSuccessful()) {
				cardDetailsResponse = response.getBody();
			}
			System.out.println("response :" + response);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardDetailsResponse;
	}

	/*public static void main(String[] args) {
		System.setProperty("environment", "dev");
		CardsServiceClientImpl svcClientImpl = new CardsServiceClientImpl();
		CardDetailsResponse response = svcClientImpl.getCardDetails("2323453434876");

		System.out.println("Response is" + response);
	} */

}
