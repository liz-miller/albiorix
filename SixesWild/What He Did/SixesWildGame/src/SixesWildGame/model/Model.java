package SixesWildGame.model;

// top level entity

public class Model {
	

	public Level getLevel() {
		int[] starThresholds = {1,2,3};
		return new Puzzle(30, starThresholds, 3, 3);
	}
}
