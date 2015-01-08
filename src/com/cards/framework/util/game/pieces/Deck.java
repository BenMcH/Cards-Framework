package com.cards.framework.util.game.pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Holds a deck of cards, either standard or custom.
 *
 */
public class Deck {

	private ArrayList<Card> deck, discardDeck;

	/**
	 * Creates a standard 52 card deck
	 */
	public Deck() {
		deck = Deck.getStandardDeck();
		discardDeck = new ArrayList<Card>();
	}

	/**
	 * Create a custom deck
	 * 
	 * @param deck
	 */
	public Deck(Card[] deck) {
		this();
		this.deck = new ArrayList<Card>(Arrays.asList(deck));
	}

	/**
	 * Shuffles the deck
	 */
	public void shuffle() {
		Collections.shuffle(deck, new Random(System.nanoTime()));
	}

	/**
	 * Draws a card and returns it. If all cards have been drawn, it will put
	 * them all back into the normal deck and shuffle.
	 * 
	 * @return
	 */
	public Card drawCard() {
		if (deck.size() > 0)
			return deck.remove(0);
		else {
			deck.addAll(discardDeck);
			discardDeck.removeAll(deck);
			shuffle();
			return null;
		}
	}

	/**
	 * Puts a card into the discard pile
	 * 
	 * @param card
	 */
	public void discardCard(Card card) {
		discardDeck.add(card);
	}

	/**
	 * Returns an arraylist of cards that is a standard deck of cards
	 * 
	 * @return
	 */
	public static ArrayList<Card> getStandardDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int card = 1; card <= 13; card++) {
			deck.add(new Card(card, CardSuit.CLUBS));
			deck.add(new Card(card, CardSuit.SPADES));
			deck.add(new Card(card, CardSuit.HEARTS));
			deck.add(new Card(card, CardSuit.DIAMONDS));
		}
		return deck;
	}

}
