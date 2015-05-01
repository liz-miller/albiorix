package SixesWildGame.boundary;

import java.awt.*;

import javax.swing.*;

import SixesWildGame.model.Model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import SixesWildGame.boundary.VictoryScreen;
import SixesWildGame.boundary.DefeatScreen;

// This object IS the window that pops up
public class Application extends JFrame {

	// How I control window generation, this is the top of the GUI classes

	private static SplashScreen splsh;
	private static SelectionMenu selmen;
	private static selectLevel slvl;
	private static SixesWildGUI game;
	private static VictoryScreen Vs;
	private static DefeatScreen Ds;

	Model model;
    int currentscore;
    int currentstars;
	
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
	
	public void Levelinfo(int levelscore, int numstars){
		currentscore = levelscore;
		currentstars = numstars;
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
			game = new SixesWildGUI(this, model.getLevel(1)); //-- getlevel takes int
			
			setContentPane(game);
			game.revalidate(); 
			repaint();
			
		//-- play a lightning level
		} else if (selection == 4) {
			game = new SixesWildGUI(this, model.getLevel(2)); //-- getlevel takes int
		
			setContentPane(game);
			game.revalidate(); 
			repaint();
		
		//-- play an Elimination level
				} else if (selection == 5) {
					game = new SixesWildGUI(this, model.getLevel(3)); //-- getlevel takes int
				
					setContentPane(game);
					game.revalidate(); 
					repaint();
				
		//-- play a release level
	} else if (selection == 6) {
		game = new SixesWildGUI(this, model.getLevel(4)); //-- getlevel takes int
	
		setContentPane(game);
		game.revalidate(); 
		repaint();
	}
	else if (selection == 7) {
		Vs = new VictoryScreen(this, currentscore, currentstars);
		setContentPane(Vs);
		Vs.revalidate(); 
		repaint();
	} 
	else if (selection == 8) {
		Ds = new DefeatScreen(this, currentscore, currentstars);
		setContentPane(Ds);
		Ds.revalidate(); 
		repaint();
	} 
	}
	public SixesWildGUI getGameGUI(){
		return game;
	}
}
