package com.cards.framework.util.game.pieces;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class GamePiece extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3104508508407778567L;

	private ColorPath color;
	public static ColorPath[] avalibleColors;

	public GamePiece() {
		super();
	}

	/**
	 * Gets the color of a given object.
	 * 
	 * @return color
	 */
	public ColorPath getColor() {
		return color;
	}


	@Override
	public void paintComponent(Graphics g) {
		drawPiece(g);
	}

	/**
	 * Paint the piece onto the screen
	 * @param g
	 */
	public abstract void drawPiece(Graphics g);
}
