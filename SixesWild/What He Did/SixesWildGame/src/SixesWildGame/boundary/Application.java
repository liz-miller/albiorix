package SixesWildGame.boundary;

import java.awt.*;

import javax.swing.*;

import SixesWildGame.model.Level;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import SixesWildGame.boundary.VictoryScreen;
import SixesWildGame.boundary.DefeatScreen;
import SixesWildGame.boundary.Deserializer;
/**
 * Application - This is the main boundary class, it runs the GUI for the game and switches between panes, as well as acting 
 * as the mediator for elements of the game that want access to GUI classes
 * @author nmpahowald
 */
// This object IS the window that pops up
public class Application extends JFrame {

	// How I control window generation, this is the top of the GUI classes

	private static SplashScreen splsh;
	private static SelectionMenu selmen;
	private static selectLevel slvl;
	private static SixesWildGUI game;
	private static VictoryScreen Vs;
	private static DefeatScreen Ds;

	//Model model;
	int currentscore;
	int currentstars;
	int levelNum;
	/**
	 * Constructor for Application sets the screen size
	 */
	public Application() {
		super("Sixes Wild");
		setSize(800, 800);
		//this.model = m;
		toMenu(0);
	}
	/**
	 * Levelinfo(int levelscore, int numstars) provides the information from the current level needed for the victory and defeat screen
	 * @param levelscore The score from the level
	 * @param numstars The star(s) from the level
	 * @param num The number of the level
	 */
	public void Levelinfo(int levelscore, int numstars, int num){
		currentscore = levelscore;
		currentstars = numstars;
		levelNum = num;
	}

	/**
	 * toMenu(int selection) navigates between menus
	 * @param selection The selection of which level to go to
	 */
	// Navigates between menus, he didn't seem to have major problem with this
	public void toMenu(int selection) {
		//-- load a level configuration from disk for testing
		Deserializer deserializer = new Deserializer();
		if (selection == 0) {
			splsh = new SplashScreen(this);
			setContentPane(splsh);
			repaint();
		}
		else if (selection == 1) {
			selmen = new SelectionMenu(this);
			setContentPane(selmen);
			selmen.revalidate(); 
			repaint();
		} else if (selection == 2) {
			slvl = new selectLevel(this);
			setContentPane(slvl);
			slvl.revalidate(); 
			repaint();
		
		}/* else if (selection == 3) {
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
		}*/
		else if (selection == 3) {
			Vs = new VictoryScreen(this, currentscore, currentstars, levelNum);
			setContentPane(Vs);
			Vs.revalidate(); 
			repaint();
		} 
		else if (selection == 4) {
			Ds = new DefeatScreen(this, currentscore, currentstars);
			setContentPane(Ds);
			Ds.revalidate(); 
			repaint();
		} 
		else if (selection == 5) {
			//-- campaign now takes you to whatever level you were on
			int i = 0;
			//levelNum MUST be 0, other values are placeholder
			ScoreRecord score = new ScoreRecord(/*this,*/ 0, 0, 0);
			ScoreLoad scoreLoad = new ScoreLoad();
			while(score != null){
				i++;
				score = scoreLoad.deserializeScore(i);
			}
			
			/*
			int j = 1; //j will equal number of levels in the game
			deserializer = new Deserializer();
			Level maxLevel = deserializer.deserializeLevel(j);
			while(maxLevel != null){
				j++;
				maxLevel = deserializer.deserializeLevel(j);
			}
			j--;
			
			if(i > j){
				i=j;
			}
			*/
			
			//-- will need to change when we put in more levels, set keep i from exceeding number of levels
			if(i > 3){
				i=3;
			}
			
			game = new SixesWildGUI(this, deserializer.deserializeLevel(i));
			setContentPane(game);
			game.revalidate(); 
			repaint();
		}
		else{
			
			game = new SixesWildGUI(this, deserializer.deserializeLevel(selection - 5));
			setContentPane(game);
			game.revalidate(); 
			repaint();
		} 
	}
	public SixesWildGUI getGameGUI(){
		return game;
	}
	public void setGame(SixesWildGUI gui){
		game = gui;
	}

}
