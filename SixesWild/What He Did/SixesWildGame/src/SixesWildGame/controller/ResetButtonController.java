package SixesWildGame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SixesWildGame.boundary.BoardView;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.model.Level;



public class ResetButtonController implements ActionListener{
	
	Level level;
	BoardView bv;
	SixesWildGUI gui;
	
	public ResetButtonController(Level level, BoardView bv, SixesWildGUI gui){
		this.level = level;
		this.bv = bv;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level.getBoard().resetBoard();
		level.decreaseMovesLeft();
		gui.updateStatViews();
		bv.revalidate();
		bv.repaint();
				
				
			
		
		
	}

}
