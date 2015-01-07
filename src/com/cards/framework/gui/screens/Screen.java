package com.cards.framework.gui.screens;

import javax.swing.JPanel;

/**
 * The basis of screens within the card game
 * @author Ben
 *
 */
public abstract class Screen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7544015771489672775L;

	/**
	 * Constructs a standard screen object. Should not be used.
	 */
	public Screen() {
		addComponents();
	}	
	
	/**
	 * The abstract method that will be used to add all of the methods to the screen.
	 */
	public abstract void addComponents();
	
	

}
