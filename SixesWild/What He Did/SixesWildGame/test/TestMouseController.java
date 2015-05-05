import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;

import SixesWildGame.boundary.Application;
import SixesWildGame.boundary.ScoreRecord;
import SixesWildGame.boundary.ScoreSave;
import SixesWildGame.boundary.SelectionMenu;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.boundary.SplashScreen;
import SixesWildGame.model.Elimination;
import SixesWildGame.model.Level;
import SixesWildGame.model.Lightning;
import SixesWildGame.model.Puzzle;
import SixesWildGame.model.Release;
import SixesWildGame.model.Square;
import junit.framework.TestCase;
import javax.swing.JPanel;


/**
 * All tests which use simulated mouse press as their method for testing the game
 * @author nmpahowald
 */

public class TestMouseController extends TestCase implements Serializable{
	
	Application app;
	Robot bot;
	
	protected void setUp() throws AWTException {
		app = new Application(); 
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		bot = new Robot();
	}
	
	protected void tearDown(){
		//does this need to do anything?	
	}

	//test the Splash Screen and its transition
	public void testSplashScreen() {
		
		assertTrue(app.getContentPane() instanceof SplashScreen);
		
		
		int windowX = app.getLocationOnScreen().x;
		int windowY = app.getLocationOnScreen().y;
		
	
		bot.mouseMove(windowX + 100,windowY + 100);
		bot.mousePress(InputEvent.BUTTON1_MASK);
		
		//add time between press and release or the input event system may 
		//not think it is a click
		try{Thread.sleep(250);}catch(InterruptedException e){}
		
		
		bot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		assertTrue(app.getContentPane() instanceof SelectionMenu);
	}
	
	public void testSelectLevel(){
		app.toMenu(2);
		
		//((SelectLevel) app.getContentPane()).
		
		
		app.toMenu(1);
		
		ScoreSave scsv = new ScoreSave();
		
		for(int i = 1; i <= 16; i++) scsv.serializeScore(new ScoreRecord(50, 1, i), i);

		
		
		app.toMenu(2);
		assertTrue(app.getComponent(0).isVisible());
		
		
	}

}
