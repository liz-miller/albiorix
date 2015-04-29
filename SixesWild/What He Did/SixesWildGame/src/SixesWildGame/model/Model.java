package SixesWildGame.model;

// top level entity

public class Model {
	

	public Level getLevel(int type) { //-- now takes int, can change this as appropriate
		int[] starThresholds = {1,2,3};
		if (type == 2){
			return new Puzzle(30, starThresholds, 3, 3); //-- this will need to be changed to lightning
		}
		else{
			return new Puzzle(30, starThresholds, 3, 3); //-- puzzle as default
		}

	}
}
