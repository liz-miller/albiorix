package SixesWildGame.boundary;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import SixesWildGame.model.Board;
import SixesWildGame.model.Level;
import SixesWildGame.model.Square;

/**
 * BoardView - This is the Boundary class which displays the contents of a Board
 * @author Alex & nmpahowald
 */

public class BoardView extends JPanel {
	// The GUI class for the board
	Level level;
	private int squareHW = 55;


	/**
	 * Constructor for BoardView using a pre-created Board to be painted
	 * @param b - Board to be painted
	 */
	public BoardView(Level l) {
		super();
		this.level = l;
		
		
	}

	/**
	 * paintComponent(Graphics g) will paint the entire Board onto the JPanel
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (level.getBoard() == null) {
			return;
		}

		//draw the border around the Square
		g.setColor(Color.BLACK);
		g.fillRect(6, 6 , squareHW* level.getBoard().boardHW + 2, squareHW* level.getBoard().boardHW + 2);
		// this is where you draw the board. For now, this draws squares that represent the values and colors of the Tiles. This will be 
		// replaced at one point to display both the Squares and Tiles
		for (int r = 0; r < level.getBoard().boardHW; r++) {
			
			for (int c = 0; c < level.getBoard().boardHW; c++) {
				
				//get the Square located at the current Board location
				Square square = level.getBoard().getSquare(r, c);
				
				
				
				//set the background of the Square depending on whether or not it is marked
				if(square.isMarked()){
					g.setColor(Color.DARK_GRAY);
				}
				else {
					g.setColor(Color.WHITE);
				}
				g.fillRect(c * squareHW + 8, r * squareHW + 8, 53, 53);
				
				//only print the Tile if the Square is not inert and there is a Tile located in the current Square
				if(!square.isInert() && square.peekTile() != null){
					paintTile(square, g, c, r);
				}
			}

		}
	}
	
	private void paintTile(Square square, Graphics g, int indexW, int indexH){
		//set the background of the Tile

		g.setColor(square.getTileColor()); 
		
		
		g.fillRect(indexW * squareHW + 12, indexH * squareHW + 12, 45, 45);
		
		//print the value of the Tile
		g.setColor(Color.black); //set the color of the writing to black
		g.drawString("" + square.getTileValue(), indexW * squareHW + 35, indexH * squareHW + 35);
		
		//print the multiplier if it is not 1
		if(square.getTileMult() != 1){
			g.drawString("x" + square.getTileMult(), indexW *squareHW + 42, indexH * squareHW + 50);
		}
	}
	
	public Square getSquare(int x, int y){
		if(x > level.getBoard().boardHW*squareHW || y > level.getBoard().boardHW*squareHW || x < 0 || y < 0) return null;
		int xIndex = (x - 6)/squareHW;
		int yIndex = (y - 6)/squareHW;
		Square square = level.getBoard().getSquare(xIndex, yIndex);
		if(square.isInert()) return null;
		return square;
	}
	
	
}
