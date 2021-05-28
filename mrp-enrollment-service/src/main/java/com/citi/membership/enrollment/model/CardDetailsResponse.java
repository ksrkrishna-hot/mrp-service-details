package com.citi.membership.enrollment.model;

import java.util.List;

public class CardDetailsResponse {
	
	private List<CardDetails> cardDetails;

	public List<CardDetails> getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(List<CardDetails> cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String toString() {
		return "CardDetailsResponse [cardDetails=" + cardDetails + "]";
	}

	
	

}
