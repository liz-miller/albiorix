import SixesWildGame.boundary.Serializer;
import SixesWildGame.model.Elimination;
import SixesWildGame.model.Level;
import SixesWildGame.model.Lightning;
import SixesWildGame.model.Puzzle;
import SixesWildGame.model.Release;
import SixesWildGame.model.Square;

/**
 * Creates a generic level for Sixes' Wild West.
 * This is how the group made levels during the separation 
 * 
 * @author npmahowald
 */
public class LevelBuilder {
	
	private static Level l;
	
	public static void main(String[] args) {
		int[] starThresholds = {10,15,40};
		int[] multWeight = {40,20,40};
		int[] valWeight = {20,20,20, 20, 10, 10};
		int type = 3;
		int num = 3;
		
		if (type == 2){
			l = new Lightning(30, starThresholds, valWeight, multWeight, 3, 3, num);
		}else if(type == 3){
			l = new Elimination(starThresholds,  valWeight, multWeight, 3, 3, num);
		} else  if(type == 4){
			l = new Release(30, starThresholds, valWeight, multWeight, 3, 3, num);
		} else{
			l = new Puzzle(30, starThresholds, valWeight, multWeight, 3, 3, num);
		}
		
		for(int i = 0; i < 3; i++){
		l.getBoard().setSquare(new Square(0,i,1));
		}
		for(int i = 0; i < 3; i++){
			l.getBoard().setSquare(new Square(8,i,1));
		}
		for(int i = 0; i < 3; i++){
			l.getBoard().setSquare(new Square(i,0,1));
		}
		for(int i = 0; i < 3; i++){
			l.getBoard().setSquare(new Square(i,8,1));
		}
		
		
		
		//methods that generate immediate fail levels
		//l.getBoard().setSquare(new Square(8,0,2));
		//l.getBoard().setSquare(new Square(7, 0, 6, 1));
		
		
		
		Serializer serializer = new Serializer();
		serializer.serializeLevel(l, num);
	}

}
