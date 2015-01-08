package com.cards.framework.util.game.pieces;

import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class GamePiece extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3104508508407778567L;
	
	public GamePiece(){
		super();
	}
	
	@Override
	public void paintComponent(Graphics g){
		drawPiece(g);
	}

	public abstract void drawPiece(Graphics g);
}
