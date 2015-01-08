package com.cards.framework.util.game.pieces;

import java.awt.Graphics;
/**
 * This class is for the chip game piece that will be used 
 * for games like poker or checkers.
 * 
 * @author William
 *
 */

public class Chip extends GamePiece {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3580233538117992826L;
	private int value;
	private ColorPath color;
	
	public static final ColorPath[] availableColors = {
		ColorPath.WHITE,
		ColorPath.GREEN,
		ColorPath.BLUE,
		ColorPath.RED,
		ColorPath.BLACK
	};
	
	/**
	 * Creates a chip that is assigned an available color then
	 * given a default value.
	 * 
	 * @param value
	 */
	
	public Chip(int value) {
		this.value = value;
		setColor(value);
		// TODO: Make it take a color argument instead.
	}
	
	/**
	 * Sets the color of the chip based on it value.
	 * 
	 * @param value
	 */
	
	private void setColor(int value) {
		switch(value) {
			case (50): color = ColorPath.WHITE;
				break;
			case (100): color = ColorPath.GREEN;
				break;
			case (500): color = ColorPath.BLUE;
				break;
			case (1000): color = ColorPath.RED;
				break;
			case (5000): color = ColorPath.BLACK;
			default: color = null;
				
		}
		
	}
	
	// Getters //
	
	public int getValue() {
		return value;
	}

	@Override
	public ColorPath getColor() {
		return color;
	}

	@Override
	public void drawPiece(Graphics g) {
	}

	
}
