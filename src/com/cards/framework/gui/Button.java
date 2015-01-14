package com.cards.framework.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.cards.framework.gui.screens.MainMenu;

public class Button extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8345716504294723050L;
	public static Icon defaultImage = new ImageIcon(MainMenu.class.getResource("/assets/photos/blue_button_normal.png"));

	private static Font defaultFont = new Font("Arail", Font.BOLD, 28);
	
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
	private Icon defaultPressedImage = new ImageIcon(MainMenu.class.getResource("/assets/photos/blue_button_pressed.png"));

	public Button(String text, Icon image, Font font) {
		super(text, image, CENTER);
		setFont(font);
		FontMetrics metrics = getFontMetrics(font);
		int width = image.getIconWidth() / 2;
		width += metrics.stringWidth(text) / 2;
		setIconTextGap(-width);
		this.setAlignmentX(CENTER_ALIGNMENT);
	}
	
	public Button(String text){
		this(text, defaultImage, defaultFont);
		setPressedImage(defaultPressedImage);
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
	
	public void addActionListener(MouseListener e){
		this.addMouseListener(e);
	}

}
