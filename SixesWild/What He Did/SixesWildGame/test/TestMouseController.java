import java.awt.AWTException;
import java.awt.Robot;
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
	
			public void testMouseController(){
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
				
				
				
				
				gui.getMouseController().mousePressed(new MouseEvent(gui,0,0,0,200,200, 0, false));
				boolean b = false;
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						if(lvl.getBoard().getTile(i,j) != null && lvl.getBoard().getTile(i, j).getSelected()) b = true;
						
					}
				}
				assertTrue(b);
				gui.getMouseController().mouseReleased(new MouseEvent(gui,0,0,0,200,200, 0, false));
				 b = false;
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							if(lvl.getBoard().getTile(i,j) != null && lvl.getBoard().getTile(i, j).getSelected()) b = true;
							
						}
					}
				assertFalse(b);
				
				
				gui.getMouseController().mouseDragged(new MouseEvent(gui,0,0,0,200,200, 0, false));
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						if(lvl.getBoard().getTile(i,j) != null && lvl.getBoard().getTile(i, j).getSelected()) b = true;
						
					}
				}
				assertTrue(b);
				gui.getMouseController().mouseExited(new MouseEvent(gui,0,0,0,200,200, 0, false));
				 b = false;
					for(int i = 0; i < 9; i++){
						for(int j = 0; j < 9; j++){
							if(lvl.getBoard().getTile(i,j) != null && lvl.getBoard().getTile(i, j).getSelected()) b = true;
							
						}
					}
				assertFalse(b);	
				
				
				//Elim tile state tests
				lvl.setEliminateTileState(true);
				
				gui.getMouseController().mousePressed(new MouseEvent(gui,0,0,0,200,200, 0, false));
				
				assertFalse(lvl.getEliminateTileState());
				
				
				
				//Swap tile state tests
				lvl.setSwapTileState(true);
				gui.getMouseController().mousePressed(new MouseEvent(gui,0,0,0,200,200, 0, false));
				
				assertTrue(lvl.getSwapTileState());
				
				gui.getMouseController().mousePressed(new MouseEvent(gui,0,0,0,200,300, 0, false));
				
				assertFalse(lvl.getSwapTileState());
				
				gui.getMouseController().mouseReleased(new MouseEvent(gui,0,0,0,200,200, 0, false));
				
			
				
				
				
			}
	
	//test the BoardView and the SixesWildGUI as well as the level entities
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
				
				assertTrue(lvl.getMovesLeft() == 30);
				lvl.decreaseMovesLeft();
				assertTrue(lvl.getMovesLeft() == 29);
				assertFalse(lvl.endGame());
				assertTrue(lvl.getType().equals("Puzzle"));
				
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
							assertFalse(lvl.getBoard().getTile(i,j).getSelected());
							assertFalse(lvl.getBoard().getSquare(i,j).isMarked());
						
					}
				}
				lvl = new Lightning(30, starThresholds, valWeight, multWeight, 3, 3, num);
				gui = new SixesWildGUI(app, lvl);
				
				app.setContentPane(gui);
				app.setGame(gui);
				
				gui.revalidate(); 
				app.repaint();
				
				assertTrue(app.getContentPane() instanceof SixesWildGUI);
				
				assertTrue(((Lightning) lvl).getTime() == 30);
				try{Thread.sleep(1500);}catch(InterruptedException e){}
				assertTrue(((Lightning) lvl).getTime() == 29);
				assertFalse(lvl.endGame());
				assertTrue(lvl.getType().equals("Lightning"));
				
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
							assertFalse(lvl.getBoard().getTile(i,j).getSelected());
							assertFalse(lvl.getBoard().getSquare(i,j).isMarked());
					}
				}
				
				
				lvl = new Elimination(starThresholds, valWeight, multWeight, 3, 3, num);
				gui = new SixesWildGUI(app, lvl);
				
				app.setContentPane(gui);
				app.setGame(gui);
				
				gui.revalidate(); 
				app.repaint();
				
				assertTrue(app.getContentPane() instanceof SixesWildGUI);
				
				assertTrue(lvl.getMovesLeft() == 0);
				lvl.decreaseMovesLeft();
				assertTrue(lvl.getMovesLeft() == 1);
				assertFalse(lvl.endGame());
				assertTrue(lvl.getType().equals("Elimination"));
				
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
							assertFalse(lvl.getBoard().getTile(i,j).getSelected());
							assertTrue(lvl.getBoard().getSquare(i,j).isMarked());
					}
				}
				
				lvl = new Release(30, starThresholds, valWeight, multWeight, 3, 3, num);
				gui = new SixesWildGUI(app, lvl);
				
				app.setContentPane(gui);
				app.setGame(gui);
				
				gui.revalidate(); 
				app.repaint();
				
				assertTrue(app.getContentPane() instanceof SixesWildGUI);
				
				assertTrue(lvl.getMovesLeft() == 30);
				lvl.decreaseMovesLeft();
				assertTrue(lvl.getMovesLeft() == 29);
				
				lvl.getBoard().setSquare(new Square(8,0,2));
				assertFalse(lvl.endGame());
				
				
				
				assertTrue(lvl.getType().equals("Release"));
				
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
							if(lvl.getBoard().getTile(i,j) != null) assertFalse(lvl.getBoard().getTile(i,j).getSelected());
							assertFalse(lvl.getBoard().getSquare(i,j).isMarked());
					}
				}
				
				
				
				
			}
	 
	 
	
	public void testSelectLevel(){
		
		// Taken from http://examples.javacodegeeks.com/core-java/io/file/delete-file-in-java-example/
		
		File file;
		for(int i = 1; i <= 16; i++){
			file = new File("./score/score"+ i +".ser");
			file.delete();
		}

		app.toMenu(2);
		
		ScoreRecord[] screc = new ScoreRecord[17];
		screc = ((SelectLevel) app.getContentPane()).getScoreRecords();
		
		assertTrue(screc[0] == null);
		
		app.toMenu(1);
		
		ScoreSave scsv = new ScoreSave();
		
		for(int i = 1; i <= 16; i++) scsv.serializeScore(new ScoreRecord(50, 1, i), i);

		
		
		app.toMenu(2);
		screc = ((SelectLevel) app.getContentPane()).getScoreRecords();
		
		for(int i = 0; i < 16; i++) assertTrue(screc[0] != null);
		
		// Taken from http://examples.javacodegeeks.com/core-java/io/file/delete-file-in-java-example/
		
		
				for(int i = 1; i <= 16; i++){
					file = new File("./score/score"+ i +".ser");
					file.delete();
				}
		
		
	}
	
	public void testResetButtonController(){
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
		
		ResetButtonController rbc = new ResetButtonController(lvl, gui.getBoardView(), gui);
		assertTrue(lvl.getMovesLeft() == 30);
		
		rbc.actionPerformed(null);
		
		assertTrue(lvl.getMovesLeft() == 29);

		
	}

}
