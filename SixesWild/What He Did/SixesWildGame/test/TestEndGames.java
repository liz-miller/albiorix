import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import SixesWildGame.boundary.Application;
import SixesWildGame.boundary.ScoreRecord;
import SixesWildGame.boundary.ScoreSave;
import SixesWildGame.boundary.SelectionMenu;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.boundary.SplashScreen;
import SixesWildGame.boundary.SelectLevel;
import SixesWildGame.controller.MouseController;
import SixesWildGame.controller.ResetButtonController;
import SixesWildGame.model.Elimination;
import SixesWildGame.model.Level;
import SixesWildGame.model.Lightning;
import SixesWildGame.model.Puzzle;
import SixesWildGame.model.Release;
import SixesWildGame.model.Square;
import junit.framework.TestCase;

import javax.swing.JPanel;


public class TestEndGames extends TestCase{

	Application app;
	
	protected void setUp(){
		app = new Application(); 
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
	
	protected void tearDown(){
		//does this need to do anything?	
	}
	public void testPuzzleEndGame(){
		int[] starThresholds = {1000,1500,2000};
		int[] multWeight = {40,40,20};
		int[] valWeight = {100,0,0, 0, 0, 0};
		int num = 1;


		Level lvl = new Puzzle(1, starThresholds, valWeight, multWeight, 3, 3, num);
		SixesWildGUI gui = new SixesWildGUI(app, lvl);

		app.setContentPane(gui);
		app.setGame(gui);


		gui.revalidate(); 
		app.repaint();
		
		assertTrue(lvl.getMovesLeft() == 1);
		lvl.decreaseMovesLeft();
		assertTrue(lvl.endGame());
		gui.updateStatViews();
	}
	
	public void testLightningEndGame(){
		int[] starThresholds = {1000,1500,2000};
		int[] multWeight = {40,40,20};
		int[] valWeight = {100,0,0, 0, 0, 0};
		int num = 1;


		Level lvl = new Lightning(1, starThresholds, valWeight, multWeight, 3, 3, num);
		SixesWildGUI gui = new SixesWildGUI(app, lvl);

		app.setContentPane(gui);
		app.setGame(gui);


		gui.revalidate(); 
		app.repaint();
		
		assertTrue(((Lightning) lvl).getTime() == 1);
		try{Thread.sleep(1500);}catch(InterruptedException e){}
		assertTrue(((Lightning) lvl).getTime() == 0);
		assertTrue(lvl.endGame());
		gui.updateStatViews();
	}
	public void testEliminationEndGame(){
		int[] starThresholds = {1000,1500,2000};
		int[] multWeight = {40,40,20};
		int[] valWeight = {100,0,0, 0, 0, 0};
		int num = 1;


		Level lvl = new Elimination(starThresholds, valWeight, multWeight, 3, 3, num);
		SixesWildGUI gui = new SixesWildGUI(app, lvl);

		app.setContentPane(gui);
		app.setGame(gui);


		gui.revalidate(); 
		app.repaint();
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
					assertTrue(lvl.getBoard().getSquare(i,j).isMarked());
					lvl.getBoard().getSquare(i,j).setUnMarked();
					assertFalse(lvl.getBoard().getSquare(i,j).isMarked());
			}
		}
		assertTrue(lvl.endGame());
		gui.updateStatViews();
	}
	public void testReleaseEndGame(){
		int[] starThresholds = {1000,1500,2000};
		int[] multWeight = {40,40,20};
		int[] valWeight = {100,0,0, 0, 0, 0};
		int num = 1;


		Level lvl = new Release(1, starThresholds, valWeight, multWeight, 3, 3, num);
		lvl.getBoard().setSquare(new Square(8,0,2));
		SixesWildGUI gui = new SixesWildGUI(app, lvl);

		//first endGame option
		app.setContentPane(gui);
		app.setGame(gui);


		gui.revalidate(); 
		app.repaint();
		
		assertTrue(lvl.getMovesLeft() == 1);
		lvl.decreaseMovesLeft();
		assertTrue(lvl.endGame());
		gui.updateStatViews();
		
		//second endGame option
		lvl = new Release(30, starThresholds, valWeight, multWeight, 3, 3, num);
		lvl.getBoard().setSquare(new Square(8,0,2));
		lvl.getBoard().setSquare(new Square(7, 0, 6, 1));
		gui = new SixesWildGUI(app, lvl);
		app.setContentPane(gui);
		app.setGame(gui);


		gui.revalidate(); 
		app.repaint();
		
		assertTrue(lvl.endGame());
		gui.updateStatViews();
		
		
		
	}

}
