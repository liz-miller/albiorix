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
import SixesWildGame.model.Tile;
import SixesWildGame.model.Puzzle;
import SixesWildGame.model.Level;
/**
 * MouseController - This is the main controller class, it takes in mouse events that act on the BoardView and distributes them
 * to the methods that need to be called.
 * @author nmpahowald
 */

public class MouseController implements MouseListener, MouseMotionListener {

	private Application app;
	private BoardView sixesFrame;
	private Board board;
	private boolean mouseHasBeenPressed;

/**
 * Constructor for MouseController which setups the mouse controller
 * @param app The application class which handles going through the different screens
 * @param boardView The boardView involved with the mouse action
 * @param board The board involved with the mouse action
 */
	public MouseController(Application app, BoardView boardView,
			Board board) {
		this.app = app;
		this.sixesFrame = boardView;
		this.board = board;
		mouseHasBeenPressed = false;
	}
	/**
	 * mouseDragged(MouseEvent me) is the mouse handler when the mouse is being dragged
	 */
	@Override
	public void mouseDragged(MouseEvent me) {
		mouseAction(me);

	}

	/**
	 * mouseMoved(MouseEvent me) is the mouse handler when the mouse is being moved
	 */
	@Override
	public void mouseMoved(MouseEvent me) {

	}

	/**
	 * mouseClicked(MouseEvent me) is the mouse handler when the mouse is being clicked
	 */
	@Override
	public void mouseClicked(MouseEvent me) {


	}
	/**
	 * mouseEntered(MouseEvent me) is the mouse handler when the mouse is being entered
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	/**
	 * mouseExited(MouseEvent me) is the mouse handler when the mouse is being exited
	 */
	@Override
	public void mouseExited(MouseEvent me) {
		mouseLeaveAction(me);

	}
	/**
	 * mousePressed(MouseEvent me) is the mouse handler when the mouse is being pressed
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		mouseAction(me);
	}
	/**
	 * mouseReleased(MouseEvent me) is the mouse handler when the mouse is being released
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		mouseLeaveAction(me);

	}
	/**
	 * mouseAction(MouseEvent me) is the mouse handler when the player is selecting squares
	 */
	private void mouseAction(MouseEvent me){
		Square selectedSquare = sixesFrame.getSquare(me.getY(), me.getX());
		if(selectedSquare == null){
			mouseLeaveAction(me);
			} else{
		Tile selectedTile = selectedSquare.peekTile();
		if(!selectedTile.getSelected()){
		board.pushToSelected(selectedTile);
		if((board.countSwiped() > 6) && !board.getParent().getEliminateTileState() && !board.getParent().getSwapTileState()
				){
			board.remAllFromSelected();
			board.getParent().decreaseMovesLeft();
		}else if(((
				(board.numSwiped() == 2 && board.getParent().getSwapTileState()) // if a swapped tile is needed
				||
				board.countSwiped() == 6 ) && board.numSwiped() > 1)  // or the count is 6
				|| board.getParent().getEliminateTileState()// or an eliminate is needed
				){ 
			if(board.getParent().getEliminateTileState()){// This just resets the button
				board.getParent().decreaseEliminateTilesLeft();
				board.getParent().setEliminateTileState(false);
				board.eliminateSwipedTiles();
			} else if(!board.getParent().getSwapTileState()){
				board.unMarkSwipedSquares();
				board.getParent().incrementScore(10*board.numSwiped()*board.eliminateSwipedTiles());
				
				board.getParent().decreaseMovesLeft();
				//Only occurs if a special move is not being used
				
				}else{
					board.swapTiles();
					board.getParent().decreaseSwapTilesLeft();
					board.getParent().setSwapTileState(false);
				}
			}
		app.getGameGUI().updateStatViews();
		sixesFrame.revalidate();
		sixesFrame.repaint();
		}
		}
	}
	/**
	 * mouseLeaveAction(MouseEvent me) is the mouse event when the mouse stops
	 * being pressed
	 */
	private void mouseLeaveAction(MouseEvent me){
		mouseHasBeenPressed = false;
		board.remAllFromSelected();
		sixesFrame.repaint();
	}

}
