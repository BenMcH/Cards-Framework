package com.cards.framework.util.game.pieces;

import java.awt.Graphics;


/**
 * A class for holding any standard card. Will have a child class to hold custom cards.
 * @author Ben
 *
 */
public class Card extends GamePiece {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7930171190465579633L;
	private int value;
	private CardSuit suit;
	
	public Card(int value, CardSuit suit) {
		this.value = value;
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit.getSuit();
	}

	public String getDisplayValue() {
		if (value > 1 && value < 11)
			return value + "";

		switch (value) {
		case (1):
			return "A";
		case (11):
			return "J";
		case (12):
			return "Q";
		case (13):
			return "K";
		default:
			return "";
		}
	}

	@Override
	public String toString() {
		return getDisplayValue() + " of " + getSuit();
	}

	@Override
	public void drawPiece(Graphics g) {
	}

}
