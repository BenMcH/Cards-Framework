package com.cards.framework.util.game.pieces;

public class Chip extends GamePiece {
	private int value;
	private ColorPath color;
	
	public static final ColorPath[] avalibleColors = {
		ColorPath.WHITE,
		ColorPath.GREEN,
		ColorPath.BLUE,
		ColorPath.RED,
		ColorPath.BLACK
	};
	
	public Chip(int value) {
		this.value = value;
		setColor(value);
	}
	
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
	
	public int getValue() {
		return value;
	}

	@Override
	public ColorPath getColor() {
		return color;
	}
	
}
