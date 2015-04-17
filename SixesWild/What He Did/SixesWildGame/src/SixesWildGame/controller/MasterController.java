package SixesWildGame.controller;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import SixesWildGame.model.Tile;

public class MasterController {
	public void onMouseEvent(MouseEvent e){
		Tile tileEntered = (Tile) e.getSource();
		if(!tileEntered.getText().contains("|")){
			count = count + Integer.parseInt(tileEntered.getText());
			numClicked++;
			//labelEntered.getBorder().
			//pointMult = pointMult;
			tileEntered.setText("|"+tileEntered.getText()+"|");
			swipedTiles.push(tileEntered);
			if(
					//(
					(count > 6) 
					//|| (count == 6 && numClicked == 1))
					&& !eliminateTileState && !swapTileState){
				count = 0;

				//pointMult = 1;
				numClicked = 0;
				movesLeft--;
				while(swipedTiles.empty() == false){
					JLabel popped = swipedTiles.pop();
					if(popped.getText().length() > 1){
						popped.setText(popped.getText().substring(1, 2));
					}
				}
			}else if((((numClicked == 2 && swapTileState) || count == 6 )&& numClicked > 1)  || eliminateTileState){
				if(eliminateTileState){
					eliminateTileState = false;
					eliminateTilesLeft--;
					btnEliminateTile.setText("Eliminate Tile ("+eliminateTilesLeft+" left)");
				} else if(!swapTileState){
					movesLeft--;
					point = point + 10*numClicked;
				}

				count = 0;
				//pointMult = 1;
				numClicked = 0;
				while(swipedTiles.empty() == false){
					Tile popped = (Tile) swipedTiles.pop();

					int poppedIndex = findIndex(popped.location().x,popped.location().y );
					if(swapTileState){
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

						if(poppedIndex >= 0 && poppedIndex < boardHW){
							popped.setVisible(false);
							allTiles[poppedIndex] = SpawnTile(popped.location().x,popped.location().y);
						} else{
							Tile downSlide = (Tile) allTiles[poppedIndex - boardHW];
							swipedTiles.push(NewTile(0,downSlide.location().x,downSlide.location().y, 0));
							downSlide.setLocation(popped.location().x, popped.location().y);
							allTiles[poppedIndex] = downSlide;
							popped.setVisible(false);
						}
					}


				}

			}
		}

		scoreBoard.setText("Score: "+ point+", Moves Left: "+ movesLeft);//+", Eliminate Tiles Left: "+ eliminateTilesLeft);


	}

