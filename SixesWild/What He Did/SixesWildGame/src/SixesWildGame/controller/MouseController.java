package SixesWildGame.controller;

import java.awt.event.*;

import SixesWildGame.boundary.Application;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.model.Board;
	// He just made this its empty, it will help us deal with all the mouse calls
public class MouseController implements MouseListener, MouseMotionListener {

	private Application app;
	private SixesWildGUI sixesFrame;
	private Board board;

	public MouseController(Application app, SixesWildGUI sixesWildGUI,
			Board board) {
		this.app = app;
		this.sixesFrame = sixesWildGUI;
		this.board = board;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
