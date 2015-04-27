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
				
				Square square = board.getSquare(r, c);
				
				//determine background color
				if(square.getColor() == null){
					g.setColor(Color.WHITE);
				}
				else {
					g.setColor(square.getColor()); 
				}
				g.fillRect(c * 60 + 6, r * 60 + 6, 64, 64);
				
				g.setColor(Color.black); //set the color of the writing to black
				g.drawString("" + square.getValue(), c * 60 + 30, r * 60 + 40);
			}

		}
	}
}
