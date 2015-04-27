import junit.framework.TestCase;

import SixesWildGame.model.*;


/**
 * TestSquare - Test class for testing the Square itself and Square-Tile dynamics
 * @author Alex
 *
 */
public class TestSquare extends TestCase{
	
	Square thisSquare;
	
	protected void setUp(){
		thisSquare = new Square(4, 7);
	}
	
	protected void tearDown(){
		//does this need to do anything?	
	}

	/**
	 * test the set up of a Square
	 */
	public void testBasicSquare() {
		assertEquals(4, thisSquare.getRow());
		assertEquals(7, thisSquare.getCol());
		assertEquals(null, thisSquare.peekTile());	
		assertFalse(thisSquare.isMarked());
	}
	
	public void testSquareMark(){
		assertFalse(thisSquare.isMarked());
		
		thisSquare.setMarked();
		
		assertTrue(thisSquare.isMarked());
		
		thisSquare.setUnMarked();
		
		assertFalse(thisSquare.isMarked());
	}
	
	public void testSquareTileConstructor(){
		Tile t = new Tile(1, 2, null);
		
		thisSquare.addTile(t);
		
		Square nextSquare = new Square(4, 7, t);
		
		assertTrue(thisSquare.equals(nextSquare));
		
		Square finalSquare = new Square(4, 7, 1, 2);
		
		assertTrue(t.equals(finalSquare.peekTile()));
		assertTrue(thisSquare.equals(finalSquare));
	}
	
	public void testSquareTileConstructorMarked(){
		Tile t = new Tile(1, 2, null);
		
		thisSquare.addTile(t);
		
		assertTrue(thisSquare.equals(new Square(4, 7, t, false)));
		
		assertTrue(thisSquare.equals(new Square(4, 7, 1, 2, false)));
		
	}

}
