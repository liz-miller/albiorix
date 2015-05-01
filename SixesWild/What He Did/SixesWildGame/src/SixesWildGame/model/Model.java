package SixesWildGame.model;

// top level entity

public class Model {
	

	public Level getLevel(int type) { //-- now takes int, can change this as appropriate
		int[] starThresholds = {500,1000,1500};
		if (type == 2){
			return new Lightning(30, starThresholds, 3, 3); //-- this will need to be changed to lightning
		}else if(type == 3){
			return new Elimination(starThresholds, 3, 3);
		} else  if(type == 4){
			return new Release(30, starThresholds, 3, 3);
		} else{
			return new Puzzle(30, starThresholds, 3, 3); //-- puzzle as default
		}

	}
}
