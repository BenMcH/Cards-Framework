package com.cards.framework.util;

public enum CardSuit {
	SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts");

	private String suit;

	private CardSuit(String suit) {
		this.suit = suit;
	}
	
	public String getSuit(){
		return suit;
	}
}
