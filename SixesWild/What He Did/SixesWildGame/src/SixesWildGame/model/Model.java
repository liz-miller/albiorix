package SixesWildGame.model;

// top level entity

public class Model {
	

	public Level getLevel() {
		int[] starThresholds = {500,1000,1500};
		return new Puzzle(30, starThresholds, 3, 3);
	}
}
