package SixesWildGame.model;

import java.sql.Time;

/**
 * Creates a Puzzle Level.
 * 
 * @author Liz Miller
 *
 */
public class Puzzle extends Level{
	private String gameName;
	private Square squares[];
	private Tile tiles[];
	private int numMoves;
	private int numStars;
	private int difficulty;
	
	public Puzzle(String gameName, Square squares[], Tile tiles[], int numMoves, int numStars, int difficulty){
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
