package com.cards.framework.gui.screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.cards.framework.gui.Window;

import com.cards.framework.gui.Button;

/**
 * The main menu
 * 
 * @author Ben
 *
 */
public class MainMenu extends BackgroundPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4309734098114374229L;

	public MainMenu() {
		super(new Color(115, 205, 75));
	}

	@Override
	public void addComponents() {
		GridBagConstraints con = new GridBagConstraints();
		con.anchor = GridBagConstraints.BASELINE;
		con.insets = new Insets(5, 5, 5, 5);
		con.gridx = 0;
		con.gridy = 0;
		Font font = new Font("Arial", Font.BOLD, 28);
		con.fill = GridBagConstraints.HORIZONTAL;
		Icon button = new ImageIcon(MainMenu.class.getResource("/assets/photos/blue_button_normal.png"));
		Icon pressed = new ImageIcon(MainMenu.class.getResource("/assets/photos/blue_button_pressed.png"));
		
		Button play = new Button("Play", button, font);
		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				Window.window.setScreen(new LocalGame());
			}
		});
		add(play, con);
		con.gridy++;
		Button multiplayer = new Button("Multiplayer", button, font);
		add(multiplayer, con);
		con.gridy++;
		Button options = new Button("Options", button, font);
		add(options, con);
		con.gridy++;
		Button exit = new Button("Exit", button, font);
		add(exit, con);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				System.exit(0);
			}
		});
		play.setPressedImage(pressed);
		multiplayer.setPressedImage(pressed);
		options.setPressedImage(pressed);
		exit.setPressedImage(pressed);
	}
}
