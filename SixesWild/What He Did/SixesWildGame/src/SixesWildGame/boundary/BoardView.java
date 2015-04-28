package SixesWildGame.boundary;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import SixesWildGame.model.Board;
import SixesWildGame.model.Square;

/**
 * BoardView - This is the Boundary class which displays the contents of a Board
 * @author Alex
 */

public class BoardView extends JPanel {
	// The GUI class for the board
	Board board;
	protected boolean eliminateTileState = false;

	protected boolean swapTileState = false;

	/**
	 * Constructor for BoardView using a pre-created Board to be painted
	 * @param b - Board to be painted
	 */
	public BoardView(Board b) {
		super();
		this.board = b;
		
		
	}

	/**
	 * paintComponent(Graphics g) will paint the entire Board onto the JPanel
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (board == null) {
			return;
		}

		//draw the border around the Square
		g.setColor(Color.BLACK);
		g.fillRect(6, 6 , 64* board.boardHW + 2, 64* board.boardHW + 2);
		// this is where you draw the board. For now, this draws squares that represent the values and colors of the Tiles. This will be 
		// replaced at one point to display both the Squares and Tiles
		for (int r = 0; r < Board.boardHW; r++) {
			
			for (int c = 0; c < Board.boardHW; c++) {
				
				//get the Square located at the current Board location
				Square square = board.getSquare(r, c);
				
				
				
				//set the background of the Square depending on whether or not it is marked
				if(square.isMarked()){
					g.setColor(Color.DARK_GRAY);
				}
				else {
					g.setColor(Color.WHITE);
				}
				g.fillRect(c * 64 + 8, r * 64 + 8, 62, 62);
				
				//only print the Tile if there is a Tile located in the current Square
				if(square.peekTile() != null){
					paintTile(square, g, c, r);
				}
			}

		}
	}
	
	private void paintTile(Square square, Graphics g, int indexW, int indexH){
		//set the background of the Tile

		g.setColor(square.getTileColor()); 
		
		
		g.fillRect(indexW * 64 + 12, indexH * 64 + 12, 54, 54);
		
		//print the value of the Tile
		g.setColor(Color.black); //set the color of the writing to black
		g.drawString("" + square.getTileValue(), indexW * 64 + 35, indexH * 64 + 35);
		
		//print the multiplier if it is not 1
		if(square.getTileMult() != 1){
			g.drawString("x" + square.getTileMult(), indexW * 64 + 53, indexH * 64 + 60);
		}
	}
	
	public Square getSquare(int x, int y){
		int xIndex = (x - 6)/64;
		int yIndex = (y - 6)/64;
		return board.getSquare(xIndex, yIndex);
	}
	
	public boolean getEliminateTileState(){
		return eliminateTileState;
	}
	
	public void setEliminateTileState(boolean b){
		eliminateTileState = b;
	}
	
	public boolean getSwapTileState(){
		return swapTileState;
	}
	
	public void setSwapTileState(boolean b){
		swapTileState = b;
	}
}
