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
	// He just made this its empty, it will help us deal with all the mouse calls
public class MouseController implements MouseListener, MouseMotionListener {

	private Application app;
	private BoardView sixesFrame;
	private Board board;
	private boolean mouseHasBeenPressed;

	
	/**
	 * MouseController - This is the main controller class, it takes in mouse events that act on the BoardView and distributes them
	 * to the methods that need to be called.
	 * @author nmpahowald
	 */
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
		mouseLeaveAction(me);

	}

	@Override
	public void mousePressed(MouseEvent me) {
		mouseAction(me);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		mouseLeaveAction(me);

	}
	
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
	
	private void mouseLeaveAction(MouseEvent me){
		mouseHasBeenPressed = false;
		board.remAllFromSelected();
		sixesFrame.repaint();
	}

}
