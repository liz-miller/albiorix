package SixesWildGame.model;

import src.SixesWildGame.model.Level;
import src.SixesWildGame.model.Square;
import src.SixesWildGame.model.Tile;


/**
 * Creates an Elimination Level.
 * 
 * @author Liz Miller
 *
 */
public class Elimination extends Level {
	private String gameName;
	private Square squares[];
	private Tile tiles[];
	private int numMoves;
	private int numStars;
	private int difficulty;
	
	public Elimination(String gameName, Square squares[], Tile tiles[], int numMoves, int numStars, int difficulty){
		this.gameName = gameName;
		this.squares = squares;
		this.tiles = tiles;
		this.numMoves = numMoves;
		this.numStars = numStars;
		this.difficulty = difficulty;	
	}

	@Override
	public Level restart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateTiles() {
		// TODO Auto-generated method stub
		
	}

}
