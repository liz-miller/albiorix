package SixesWildGame.controller;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import SixesWildGame.model.Tile;

public class MasterController {
	// If we can get this to work we will be almost done
	// This will have to somehow be broken into many controllers

	/*
	public void onMouseEvent(MouseEvent e){
		Tile tileEntered = (Tile) e.getSource(); // get the tile that called the event
		if(!tileEntered.getText().contains("|")){ // If the tile is NOT already selected
			count = count + Integer.parseInt(tileEntered.getText()); // Add the value to "count"
			numClicked++; // Add to numClicked
			//labelEntered.getBorder().
			//pointMult = pointMult;
			tileEntered.setText("|"+tileEntered.getText()+"|"); // Make is "selected"
			swipedTiles.push(tileEntered); // Add it to swiped tiles
			if(
					//(
					(count > 6) 
					//|| (count == 6 && numClicked == 1))
					&& !eliminateTileState && !swapTileState){
				count = 0; // Reset count if it is ever above 6

				//pointMult = 1;
				numClicked = 0;
				movesLeft--;
				while(swipedTiles.empty() == false){ // De-select all the tiles
					JLabel popped = swipedTiles.pop();
					if(popped.getText().length() > 1){
						popped.setText(popped.getText().substring(1, 2));
					}
				}
			}else if((((numClicked == 2 && swapTileState) // if a swapped tile is needed
					|| count == 6 )&& numClicked > 1)  // or the count is 6
					|| eliminateTileState){ // or an eliminate is needed
				if(eliminateTileState){// This just resets the button
					eliminateTileState = false;
					eliminateTilesLeft--;
					btnEliminateTile.setText("Eliminate Tile ("+eliminateTilesLeft+" left)");
				} else if(!swapTileState){
					//Only occurs if a special move is not being used
					movesLeft--;
					point = point + 10*numClicked;
				}

				count = 0;
				//pointMult = 1;
				numClicked = 0;
				while(swipedTiles.empty() == false){
					Tile popped = (Tile) swipedTiles.pop(); // get the most recent tile selected

					int poppedIndex = findIndex(popped.location().x,popped.location().y ); // and its index
					if(swapTileState){ // This just gets the tile before the most recent, gets their info
						// deletes them and makes new tiles the same but swapped in location
						Tile popped2 =  (Tile) swipedTiles.pop();
						int popped2Index = findIndex(popped2.location().x,popped2.location().y );
						allTiles[poppedIndex] = NewTile(Integer.parseInt(popped2.getText().substring(1, 2)), popped.location().x,popped.location().y, popped.getMult());
						allTiles[popped2Index] = NewTile(Integer.parseInt(popped.getText().substring(1, 2)), popped2.location().x,popped2.location().y, popped2.getMult());
						popped.setVisible(false);
						popped2.setVisible(false);
						swapTilesLeft--;
						btnSwapTile.setText("Swap Tiles ("+swapTilesLeft+" left)");
						swapTileState = false;

					}else{

						if(poppedIndex >= 0 && poppedIndex < boardHW){ // if its on the top row
							// generate a new tile
							popped.setVisible(false);
							allTiles[poppedIndex] = SpawnTile(popped.location().x,popped.location().y);
						} else{ // else collect the tile above this one
							Tile downSlide = (Tile) allTiles[poppedIndex - boardHW];
							// Add it to the list of tiles that were "swiped" so that the same process will occur
							swipedTiles.push(NewTile(0,downSlide.location().x,downSlide.location().y, 0));
							// Make a copy of it in the spot until recently occupied by the swiped tile
							downSlide.setLocation(popped.location().x, popped.location().y);
							allTiles[poppedIndex] = downSlide;
							// and delete the swiped tile
							popped.setVisible(false);
							// This process repeats until all tiles are in their proper place
						}
					}


				}

			}
		}

		scoreBoard.setText("Score: "+ point+", Moves Left: "+ movesLeft);//+", Eliminate Tiles Left: "+ eliminateTilesLeft);


	}
	*/
}

