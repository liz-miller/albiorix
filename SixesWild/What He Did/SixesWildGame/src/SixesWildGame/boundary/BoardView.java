package SixesWildGame.boundary;

import java.awt.Color;
import java.awt.Graphics;

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

		// this is where you draw the board. For now, this draws squares that represent the values and colors of the Tiles. This will be 
		// replaced at one point to display both the Squares and Tiles
		for (int r = 0; r < Board.boardHW; r++) {
			for (int c = 0; c < Board.boardHW; c++) {
				
				//get the Square located at the current Board location
				Square square = board.getSquare(r, c);
				
				//draw the border around the Square
				g.setColor(Color.BLACK);
				g.fillRect(c * 60 + 6, r * 60 + 6, 64, 64);
				
				//set the background of the Square depending on whether or not it is marked
				if(square.isMarked()){
					g.setColor(Color.DARK_GRAY);
				}
				else {
					g.setColor(Color.WHITE);
				}
				g.fillRect(c * 60 + 7, r * 60 + 7, 62, 62);
				
				//only print the Tile if there is a Tile located in the current Square
				if(square.peekTile() != null){
					//set the background of the Tile
					if(square.getTileColor() == null){
						g.setColor(Color.CYAN);
					}
					else {
						g.setColor(square.getTileColor()); 
					}
					g.fillRect(c * 60 + 12, r * 60 + 12, 50, 50);
					
					//print the value of the Tile
					g.setColor(Color.black); //set the color of the writing to black
					g.drawString("" + square.getTileValue(), c * 60 + 35, r * 60 + 40);
				}
			}

		}
	}
}
