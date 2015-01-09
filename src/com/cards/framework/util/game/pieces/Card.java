package com.cards.framework.util.game.pieces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.net.MalformedURLException;


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
		//File f = new File();//("/assets/photos/cards/card" + suit.getSuit() + getDisplayValue() + ".svg");
		setURI(Card.class.getResource("/assets/photos/playingCards.svg").toString());
		
		this.setCanvasSize(200, 200);
		
	}

	/**
	 * Returns the numerical value of the card (1-13) Ace low
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the string representation of the suit.
	 * @return
	 */
	public String getSuit() {
		return suit.getSuit();
	}

	/**
	 * returns the number or letter for display. E.G. "K" for king
	 * @return
	 */
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
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	
	

}
