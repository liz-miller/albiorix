package SixesWildGame.boundary;

import java.awt.*;

import javax.swing.*;

import SixesWildGame.model.Model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// This object IS the window that pops up
public class Application extends JFrame {

	// How I control window generation, this is the top of the GUI classes

	private static SplashScreen splsh;
	private static SelectionMenu selmen;
	private static selectLevel slvl;
	private static SixesWildGUI game;

	Model model;

	public Application(Model m) {
		super("Sixes Wild");
		setSize(800, 800);
		this.model = m;
		toMenu(3);
	}

	// Navigates between menus, he didn't seem to have major problem with this
	public void toMenu(int selection) {
		if (selection == 0) {
			splsh = new SplashScreen(this);
			setContentPane(splsh);
		}
		if (selection == 1) {
			selmen = new SelectionMenu(this);
			setContentPane(selmen);
		} else if (selection == 2) {
			slvl = new selectLevel(this);
			setContentPane(slvl);
		} else if (selection == 3) {
			game = new SixesWildGUI(this, model.getBoard(1));
			setContentPane(game);
		}

		// google how to refresh when changing content pane for JFrame
		// repaint doesn't work, I had been using setVisible(true) but IDK
		 //repaint();
	}
}
