package SixesWildGame.model;

import java.sql.Time;

/**
 * Creates a Lightning Level.
 * 
 * @author Liz Miller
 *
 */
public class Lightning extends Level{
	private String gameName;
	private Square squares[];
	private Tile tiles[];
	private int numMoves;
	private int numStars;
	private int difficulty;
	private Time timeLeft;
	
	public void Level(String gameName, Square squares[], Tile tiles[], int numMoves, int numStars, int difficulty, Time timeLeft){
		this.gameName = gameName;
		this.squares = squares;
		this.tiles = tiles;
		this.numMoves = numMoves;
		this.numStars = numStars;
		this.difficulty = difficulty;
		this.timeLeft = timeLeft;
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
