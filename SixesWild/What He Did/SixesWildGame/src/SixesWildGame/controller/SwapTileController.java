package SixesWildGame.controller;

import SixesWildGame.model.Square;
import SixesWildGame.model.Tile;
public class SwapTileController{

	public void ASwapTile(Tile tile1, Tile tile2 ){
		Square square1 = tile1.getParent();
		Square square2 = tile2.getParent();
		tile1.setParent(square2);
		tile2.setParent(square1);
		return;
	}

	
}