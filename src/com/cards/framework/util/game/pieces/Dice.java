package com.cards.framework.util.game.pieces;

import java.awt.Graphics;
import java.util.Random;

/**
 * Adds the dice game piece for games like Yahtzee or Monopoly. TODO: Allow
 * custom dice.
 * 
 * @author William
 *
 */

public class Dice extends GamePiece implements Rollable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2043788544461732929L;
	private int dice;
	private int size;
	private ColorPath color;

	public static final ColorPath[] availableColors = { ColorPath.WHITE,
			ColorPath.RED };

	public static final int[] availableSizes = { 6 };

	/**
	 * If object is given no attributes, if creates a default white, 6-sided
	 * die.
	 */
	public Dice() {
		dice = 1;
		size = 6;
		color = ColorPath.WHITE;

	}

	/**
	 * Creates the die with the given color and size.
	 * 
	 * @param size
	 * @param color
	 */
	public Dice(int size, ColorPath color) {
		this();
		this.size = size;
		this.color = color;
	}

	/**
	 * Documentation for these are in the implemented interface "Rollable"
	 */
	@Override
	public int getNumberOfPossibleOutcomes() {
		return size;
	}

	@Override
	public int Roll() {
		Random side = new Random();
		dice = side.nextInt(size) + 1;
		return dice;
	}

	@Override
	public void drawPiece(Graphics g) {
	}

	/**
	 * Documentation for these are in the extended class "GamePiece"
	 */
	@Override
	public ColorPath getColor() {
		return color;
	}

}
