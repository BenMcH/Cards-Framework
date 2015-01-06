package com.cards.framework.util;

import java.util.ArrayList;

public class Card {
	private int value;
	private String suit;
	
	public Card(int value, CardSuit suit) {
		this.value = value;
		this.suit = suit.getSuit();
	}
	
	public int getValue() {
		return value;
	}
	
	public String getSuit() {
		return suit;
	}

}
