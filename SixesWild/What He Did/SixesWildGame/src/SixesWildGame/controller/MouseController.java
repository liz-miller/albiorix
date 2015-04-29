package SixesWildGame.controller;
/**
 * MouseController - this Class 
 * @author npmahowald
 *
 */
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
		mouseAction(me);

	}

	@Override
	public void mouseMoved(MouseEvent me) {

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
		mouseAction(me);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		mouseHasBeenPressed = false;
		board.remAllFromSelected();
		sixesFrame.repaint();

	}
	
	private void mouseAction(MouseEvent me){
		Square selectedSquare = sixesFrame.getSquare(me.getY(), me.getX());
		if(!selectedSquare.peekTile().getSelected()){
		board.pushToSelected(selectedSquare);
		if((board.countSwiped() > 6) && !sixesFrame.getEliminateTileState() && !sixesFrame.getSwapTileState()
				){
			board.remAllFromSelected();
			board.decreaseMovesLeft();
		}else if(((
				(board.numSwiped() == 2 && sixesFrame.getSwapTileState()) // if a swapped tile is needed
				||
				board.countSwiped() == 6 ) && board.numSwiped() > 1)  // or the count is 6
				|| sixesFrame.getEliminateTileState()// or an eliminate is needed
				){ 
			if(sixesFrame.getEliminateTileState()){// This just resets the button
				sixesFrame.setEliminateTileState(false);
			//	eliminateTilesLeft--;
			//	btnEliminateTile.setText("Eliminate Tile ("+eliminateTilesLeft+" left)");
			} else if(!sixesFrame.getSwapTileState()){
				board.eliminateSwipedTiles();
				board.decreaseMovesLeft();
				//Only occurs if a special move is not being used
			//	movesLeft--;
			//	point = point + 10*numClicked;
			}
			}
		app.getGameGUI().upDateStatViews();
		sixesFrame.revalidate();
		sixesFrame.repaint();
	}
		}

}
