package com.cards.framework.util.game.pieces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;


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
	private Image image;
	public Card(int value, CardSuit suit) {
		this.value = value;
		this.suit = suit;
		try {
			image = ImageIO.read(Card.class.getResource("/assets/photos/cards/card" + suit.getSuit() + getDisplayValue() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(140,190));
		setMinimumSize(new Dimension(140,190));
		setMaximumSize(new Dimension(140,190));
		
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

	/**
	 * Documentation in the GamePiece Class
	 */
	@Override
	public void drawPiece(Graphics g) {
		System.out.println(getLocation());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
}
