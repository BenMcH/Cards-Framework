package com.cards.framework.gui.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.cards.framework.gui.Window;

public class BackgroundPanel extends Screen {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7661445737747263206L;

	private Color color;

	/**
	 * Given a color passed to it, it will create a nice background behind the components
	 * @param i
	 */
	public BackgroundPanel(Color i) {
		super();
		this.color = i;
	}

	@Override
	public void addComponents() {
	}

	@Override
	public void paintComponent(Graphics g2) {
		Graphics2D g = (Graphics2D) g2;
		int width = Window.window.getContentPane().getWidth();
		int height = Window.window.getContentPane().getHeight();
		int location = (int) (width * .015);
		g.setColor(color.darker());
		g.fillRect(0, 0, width, height);
		g.setColor(color.brighter());
		g.fillRoundRect(location / 2, location / 2, width - (location),
				height - location, 30, 30);
		g.setColor(color);
		g.fillRoundRect(location, location, width - (location * 2), height
				- location * 2, 30, 30);
	}

}
