package com.citi.membership.enrollment.serviceclient;

import java.util.List;

import com.citi.membership.enrollment.model.CardDetailsRequest;
import com.citi.membership.enrollment.model.CardDetailsResponse;


public interface CardsServiceClient {

	//List<String> getCards(String cardNum);
	CardDetailsResponse getCardDetails(String cardNum);
	//CardDetailsResponse getAllCardDetails(CardDetailsRequest cardDetailsRequest);
}
