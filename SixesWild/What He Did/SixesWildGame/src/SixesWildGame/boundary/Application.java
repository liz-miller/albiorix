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

	
	/**
	 * Application - This is the main boundary class, it runs the GUI for the game and switches between panes, as well as acting 
	 * as the mediator for elements of the game that want access to GUI classes
	 * @author nmpahowald
	 */
	public Application(Model m) {
		super("Sixes Wild");
		setSize(800, 800);
		this.model = m;
		toMenu(0);
	}

	// Navigates between menus, he didn't seem to have major problem with this
	public void toMenu(int selection) {
		if (selection == 0) {
			splsh = new SplashScreen(this);
			setContentPane(splsh);
			 repaint();
		}
		if (selection == 1) {
			selmen = new SelectionMenu(this);
			setContentPane(selmen);
			selmen.revalidate(); 
			repaint();
		} else if (selection == 2) {
			slvl = new selectLevel(this);
			setContentPane(slvl);
			slvl.revalidate(); 
			repaint();
			
		} else if (selection == 3) {
			game = new SixesWildGUI(this, model.getBoard(1));
			
			setContentPane(game);
			game.revalidate(); 
			repaint();
		}
	}
	public SixesWildGUI getGameGUI(){
		return game;
	}
}
