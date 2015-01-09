package com.cards.framework.util.game.pieces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import org.apache.batik.swing.JSVGCanvas;

public abstract class GamePiece extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3104508508407778567L;

	private ColorPath color;
	public static ColorPath[] avalibleColors;
	private JSVGCanvas canvas;
	
	public GamePiece() {
		super(new BorderLayout());
		canvas = new JSVGCanvas();
		add(canvas, BorderLayout.CENTER);
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

	public void setCanvasSize(int width, int height){
		Dimension dim = new Dimension(width, height);
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
		AffineTransform trans = canvas.getRenderingTransform();
		trans.scale(width, height);
	}
	
	public void setURI(String uri){
		canvas.setURI(uri);
	}
	
	public JSVGCanvas getCanvas(){
		return canvas;
	}
	
}
