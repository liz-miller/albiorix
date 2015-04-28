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
	private boolean mouseHasBeenPressed;

	public MouseController(Application app, BoardView boardView,
			Board board) {
		this.app = app;
		this.sixesFrame = boardView;
		this.board = board;
		mouseHasBeenPressed = false;
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		board.pushToSelected(sixesFrame.getSquare(me.getY(), me.getX()));
		sixesFrame.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent me) {
		/*
		System.out.println("1");
		if(mouseHasBeenPressed){
			System.out.println("2");
		board.pushToSelected(sixesFrame.getSquare(me.getY(), me.getX()));
		sixesFrame.repaint();
		}*/

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
		

	}

	@Override
	public void mousePressed(MouseEvent me) {
		/*
		mouseHasBeenPressed = true;
		board.pushToSelected(sixesFrame.getSquare(me.getY(), me.getX()));
		sixesFrame.repaint();
		 */
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		mouseHasBeenPressed = false;
		board.remAllFromSelected();
		sixesFrame.repaint();

	}

}
