package com.cards.framework.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Button extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8345716504294723050L;

	/**
	 * Creates a Button out of a JLabel, allowing it to be styled with a
	 * background image easier
	 * 
	 * @param text
	 * @param image
	 * @param font
	 */
	private Icon oppositeButton = null;
	private boolean hasBeenAdded = false;

	public Button(String text, Icon image, Font font) {
		super(text, image, CENTER);
		setFont(font);
		FontMetrics metrics = getFontMetrics(font);
		int width = image.getIconWidth() / 2;
		width += metrics.stringWidth(text) / 2;
		setIconTextGap(-width);
		this.setAlignmentX(CENTER_ALIGNMENT);
	}

	public void setPressedImage(Icon image) {
		oppositeButton = image;
		addListenerOnce();
	}
	
	private void addListenerOnce(){
		if(hasBeenAdded) return;
		Dimension button, pressed, big;
		button = new Dimension(getIcon().getIconWidth(), getIcon().getIconHeight());
		pressed = new Dimension(oppositeButton.getIconWidth(), oppositeButton.getIconHeight());
		big = new Dimension(Math.max(button.width, pressed.width), Math.max(button.height, pressed.height));
		this.setMinimumSize(big);
		this.setMaximumSize(big);
		this.setPreferredSize(big);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switchImage();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				switchImage();
			}

			private void switchImage() {
				Icon i = getIcon();
				setIcon(oppositeButton);
				oppositeButton = i;
			}
		});
		hasBeenAdded = true;
	}

}
