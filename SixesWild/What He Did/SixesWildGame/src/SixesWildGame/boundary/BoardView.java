package SixesWildGame.boundary;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import SixesWildGame.model.Board;
import SixesWildGame.model.Tile;

public class BoardView extends JPanel {
	// The GUI class for the board
	Board board;

	public BoardView (Board b) {
		super();
		this.board = b;
	}
	//This will paint onto the JPanel
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (board == null) { return; }
		
		
		// this is where you draw the board.
		for (int r = 0; r < Board.boardHW; r++ ) {
			for (int c = 0; c < Board.boardHW; c++) {
				Tile t = board.getTile(r,c);
				// what about select tiles? when a move is being done...
				
				g.setColor(getColor(t.getValue()));
				g.fillRect(c*60 + 6, r*60 + 6, 64, 64);
				g.setColor(Color.black);
				g.drawString("" + t.getValue(), c*60+6, r*60+6);
			}
		}

		// do the for loop and iterate over all the tiles and show them on the screen.
	}
	// All this function does is determine the tile color
	public Color getColor(int num) {
		if(num == 1){
			return Color.RED;
		} else if(num == 2){
			return Color.ORANGE;
		} else if(num == 3){
			return Color.BLUE;
		} else if( num == 4){
			return Color.MAGENTA;
		} else if( num == 5){
			return Color.GREEN;
		} else{
			return Color.YELLOW;
		}
	}

}
