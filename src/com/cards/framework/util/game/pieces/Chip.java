package com.cards.framework.util.game.pieces;

import java.awt.Graphics;

public class Chip extends GamePiece {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3580233538117992826L;
	private int value;
	private ColorPath color;
	
	public Chip(int value) {
		this.value = value;
		setColor(value);
	}
	
	private void setColor(int value) {
		switch(value) {
			case (50): color = ColorPath.GREEN;
				break;
			case (100): color = ColorPath.BLUE;
				break;
			case (500): color = ColorPath.RED;
				break;
			case (1000): color = ColorPath.YELLOW;
				break;
			default: color = null;
				
		}
		
	}
	
	public int getValue() {
		return value;
	}
	
	public ColorPath getColor() {
		return color;
	}

	@Override
	public void drawPiece(Graphics g) {
	}

}
