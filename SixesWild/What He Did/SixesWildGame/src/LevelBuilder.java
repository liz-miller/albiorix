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
		int[] starThresholds = {1500,2000,3000};
		int[] multWeight = {1,1,2};
		int[] valWeight = {30,30,20, 10, 5, 5};
		int type = 2;
		int num = 14;
		
		if (type == 2){
			l = new Lightning(30, starThresholds, valWeight, multWeight, 3, 3, num);
		}else if(type == 3){
			l = new Elimination(starThresholds,  valWeight, multWeight, 3, 3, num);
		} else  if(type == 4){
			l = new Release(30, starThresholds, valWeight, multWeight, 3, 3, num);
		} else{
			l = new Puzzle(30, starThresholds, valWeight, multWeight, 3, 3, num);
		}
		

		
		l.getBoard().setSquare(new Square(7,8,1));
		l.getBoard().setSquare(new Square(8,7,1));
		l.getBoard().setSquare(new Square(8,8,1));
		

			
		l.getBoard().setSquare(new Square(1,8,1));
		l.getBoard().setSquare(new Square(0,8,1));
		l.getBoard().setSquare(new Square(1,7,1));

		
		
		//methods that generate immediate fail levels
		//l.getBoard().setSquare(new Square(8,0,2));
		//l.getBoard().setSquare(new Square(7, 0, 6, 1));
		
		
		
		Serializer serializer = new Serializer();
		serializer.serializeLevel(l, num);
	}

}
