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
 * @author nmpahowald & Sean
 */
// This object IS the window that pops up
public class Application extends JFrame {

	// How I control window generation, this is the top of the GUI classes

	private static SplashScreen splsh;
	private static SelectionMenu selmen;
	private static SelectLevel slvl;
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
	// Navigates between menus
	public void toMenu(int selection) {
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
			slvl = new SelectLevel(this);
			setContentPane(slvl);
			slvl.revalidate(); 
			repaint();
		}
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
			//campaign mode loads from disk
			int i = 0;
			ScoreRecord score = new ScoreRecord(0, 0, 0);
			ScoreLoad scoreLoad = new ScoreLoad();
			while(score != null){
				i++;
				score = scoreLoad.deserializeScore(Integer.toString(i));
			}
			
			//check for the presence of the next level
			int j = 1; //j equals the number of levels in the game
			deserializer = new Deserializer();
			Level maxLevel = deserializer.deserializeLevel(Integer.toString(j));
			while(maxLevel != null){
				j++;
				maxLevel = deserializer.deserializeLevel(Integer.toString(j));
			}
			j--;
			
			if(i > j){
				i=j; //if campaign tries to access a level that does not exist, load highest numbered level instead
			}
			
			game = new SixesWildGUI(this, deserializer.deserializeLevel(Integer.toString(i)));
			setContentPane(game);
			game.revalidate(); 
			repaint();
		}
		else if (selection == 6) {
			game = new SixesWildGUI(this, deserializer.deserializeLevel("builder" + Integer.toString(1)));
			setContentPane(game);
			game.revalidate(); 
			repaint();
		}
		else if (selection == 7) {
			game = new SixesWildGUI(this, deserializer.deserializeLevel("builder" + Integer.toString(2)));
			setContentPane(game);
			game.revalidate(); 
			repaint();
		}
		else if (selection == 8) {
			game = new SixesWildGUI(this, deserializer.deserializeLevel("builder" + Integer.toString(3)));
			setContentPane(game);
			game.revalidate(); 
			repaint();
		}
		else if (selection == 9) {
			game = new SixesWildGUI(this, deserializer.deserializeLevel("builder" + Integer.toString(4)));
			setContentPane(game);
			game.revalidate(); 
			repaint();
		}
		else{
			
			game = new SixesWildGUI(this, deserializer.deserializeLevel(Integer.toString(selection - 9)));
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
