package SixesWildGame.model;

import java.util.Random;


public class Board {
	Tile[][] allTiles;
	public final static int boardHW = 9;
	static Random randomGenerator = new Random();
	
	public Board () {
		allTiles  = new Tile[boardHW][boardHW];
		
		for (int r = 0; r < boardHW; r++) {
			for (int c = 0; c < boardHW; c++) {
				allTiles[r][c] = new Tile(randomGenerator.nextInt(6) + 1, r, c, 1);
			}
		}
	}
	
	public Tile SpawnTile(int r, int c) {
		return new Tile(randomGenerator.nextInt(6) + 1, r, c, 1);
	}

	public Tile getTile(int r, int c) {
		return allTiles[r][c];
	}
}

