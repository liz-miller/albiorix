package SixesWildGame.controller;

import java.awt.event.*;

import SixesWildGame.boundary.Application;
import SixesWildGame.boundary.BoardView;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.model.Board;
import SixesWildGame.model.Square;
	// He just made this its empty, it will help us deal with all the mouse calls
public class MouseController implements MouseListener, MouseMotionListener {

	private Application app;
	private BoardView sixesFrame;
	private Board board;

	public MouseController(Application app, BoardView boardView,
			Board board) {
		this.app = app;
		this.sixesFrame = boardView;
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
	public void mouseClicked(MouseEvent me) {


	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent me) {
		board.pushToSelected(sixesFrame.getSquare(me.getY(), me.getX()));
		sixesFrame.repaint();

	}

	@Override
	public void mousePressed(MouseEvent me) {
		board.pushToSelected(sixesFrame.getSquare(me.getY(), me.getX()));
		sixesFrame.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent me) {
		board.remAllFromSelected();
		sixesFrame.repaint();

	}

}
