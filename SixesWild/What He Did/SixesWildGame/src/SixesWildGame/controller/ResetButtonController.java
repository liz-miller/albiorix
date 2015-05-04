package SixesWildGame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWildGame.boundary.BoardView;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.model.Level;

/** 
 * ResetButtonController - This controller class works on implementing 
 * the reset board special move 
 * @author nmpahowald
 *
 */

public class ResetButtonController implements ActionListener{
	
	Level level;
	BoardView bv;
	SixesWildGUI gui;
	/**
	 * Constructor for ResetButtonController which sets up the controller
	 * @param level The level involved with the board reset
	 * @param bv The BoardView involved with the reset
	 * @param gui The gui involved with the reset
	 */
	public ResetButtonController(Level level, BoardView bv, SixesWildGUI gui){
		this.level = level;
		this.bv = bv;
		this.gui = gui;
	}

	/**
	 * actionPerformed(ActionEvent e) is the action that occurs 
	 * when the reset button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		level.getBoard().resetBoard();
		level.decreaseMovesLeft();
		gui.updateStatViews();
		bv.revalidate();
		bv.repaint();
				
				
			
		
		
	}

}
