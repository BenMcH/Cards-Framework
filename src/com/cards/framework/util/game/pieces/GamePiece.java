package com.cards.framework.util.game.pieces;

import java.awt.Dimension;
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
		this.setLocation(0, 0);
		setAbsoluteSize(100, 100);
		this.setBounds(0, 0, 100, 100);
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
	 * 
	 * @param g
	 */
	public abstract void drawPiece(Graphics g);

	public void setComponentSize(int width, int height) {
		Dimension dim = new Dimension(width, height);
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
	}

	public void setAbsoluteSize(int width, int height) {
		Dimension size = new Dimension(width, height);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	public void setScale(double percent){
		
	}
}
