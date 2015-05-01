package SixesWildGame.model;

import java.io.Serializable;

// top level entity

public class Model implements Serializable{
	

	public Level getLevel(int type) { //-- now takes int, can change this as appropriate
		int[] starThresholds = {500,1000,1500};
		int[] multWeight = {60,40,0};
		int[] valWeight = {40,20,20, 10, 10, 0};
		if (type == 2){
			return new Lightning(30, starThresholds, valWeight, multWeight, 3, 3); //-- this will need to be changed to lightning
		}else if(type == 3){
			return new Elimination(starThresholds,  valWeight, multWeight, 3, 3);
		} else  if(type == 4){
			return new Release(30, starThresholds, valWeight, multWeight, 3, 3);
		} else{
			return new Puzzle(30, starThresholds, valWeight, multWeight, 3, 3); //-- puzzle as default
		}

	}
}
