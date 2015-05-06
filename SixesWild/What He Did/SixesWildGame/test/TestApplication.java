import javax.swing.JFrame;

import junit.framework.TestCase;
import SixesWildGame.boundary.Application;
import SixesWildGame.boundary.DefeatScreen;
import SixesWildGame.boundary.SelectLevel;
import SixesWildGame.boundary.SelectionMenu;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.boundary.SplashScreen;
import SixesWildGame.boundary.VictoryScreen;
import SixesWildGame.model.Board;
import SixesWildGame.model.Level;
import SixesWildGame.model.Puzzle;


public class TestApplication extends TestCase{
	
	Application app;
	
	public void setUp(){
		app = new Application(); 
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		
	}
	
	 public void tearDown(){
		
	}
	 
	 public void testApplication(){

			app.toMenu(0);
			assertTrue(app.getContentPane() instanceof SplashScreen);
			app.toMenu(1);
			assertTrue(app.getContentPane() instanceof SelectionMenu);
			app.toMenu(2);
			assertTrue(app.getContentPane() instanceof SelectLevel);
			app.toMenu(3);
			assertTrue(app.getContentPane() instanceof VictoryScreen);
			app.toMenu(4);
			assertTrue(app.getContentPane() instanceof DefeatScreen);
			app.toMenu(5);
			assertTrue(app.getContentPane() instanceof SixesWildGUI);	
			app.toMenu(6);
			assertTrue(app.getContentPane() instanceof SixesWildGUI);
			app.toMenu(7);
			assertTrue(app.getContentPane() instanceof SixesWildGUI);
			app.toMenu(8);
			assertTrue(app.getContentPane() instanceof SixesWildGUI);
			app.toMenu(9);
			assertTrue(app.getContentPane() instanceof SixesWildGUI);
			app.toMenu(10);
			assertTrue(app.getContentPane() instanceof SixesWildGUI);
			
		
	 }
}
