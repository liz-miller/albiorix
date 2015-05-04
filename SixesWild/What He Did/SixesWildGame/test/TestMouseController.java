import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JFrame;

import SixesWildGame.boundary.Application;
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


/**
 * All tests which use simulated mouse press as their method for testing the game
 * @author nmpahowald
 */

public class TestMouseController extends TestCase{
	
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
		assertTrue(app.getComponent(0).isVisible());
		
		
	}
	
	//test the Splash Screen and its transition
		public void testBoardView() {
			
			
			int[] starThresholds = {1000,1500,2000};
			int[] multWeight = {40,40,20};
			int[] valWeight = {100,0,0, 0, 0, 0};
			int num = 1;

			
			Level lvl = new Puzzle(30, starThresholds, valWeight, multWeight, 3, 3, num);
			SixesWildGUI gui = new SixesWildGUI(app, lvl);
			
			app.setContentPane(gui);
			app.setGame(gui);
			
			gui.revalidate(); 
			app.repaint();
			
			assertTrue(app.getContentPane() instanceof SixesWildGUI);
			
			int windowX = app.getLocationOnScreen().x;
			int windowY = app.getLocationOnScreen().y;
			
			bot.mouseMove(windowX + 80,windowY + 190);
			bot.mousePress(InputEvent.BUTTON1_MASK);
			
			//add time between press and release or the input event system may 
			//not think it is a click
			
			for(int i = 1; i < 6; i++){
				
			try{Thread.sleep(250);}catch(InterruptedException e){}

			assertTrue(lvl.getBoard().getTile(0,i-1).getSelected());
			
			try{Thread.sleep(250);}catch(InterruptedException e){}
			
			bot.mouseMove(windowX + 80 + i*50, windowY + 190);
			
			}
			try{Thread.sleep(250);}catch(InterruptedException e){}
			
			bot.mouseRelease(InputEvent.BUTTON1_MASK);
			
			
			
		}

}
