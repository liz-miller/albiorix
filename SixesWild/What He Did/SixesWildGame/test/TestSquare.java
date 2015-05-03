import java.awt.Color;

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

	//test the set up of a Square
	public void testBasicSquare() {
		assertEquals(4, thisSquare.getRow());
		assertEquals(7, thisSquare.getCol());
		assertEquals(null, thisSquare.peekTile());	
		assertFalse(thisSquare.isMarked());
	}
	
	//test the marking of a Square 
	public void testSquareMark(){
		assertFalse(thisSquare.isMarked());
		
		thisSquare.setMarked();
		assertTrue(thisSquare.isMarked());
		
		thisSquare.setUnMarked();
		assertFalse(thisSquare.isMarked());
		
		//Test the marking of an inert Square
		thisSquare = new Square(3, 1, 1);
		assertFalse(thisSquare.isMarked());
		
		thisSquare.setMarked();
		assertFalse(thisSquare.isMarked());
		
		thisSquare.setUnMarked();
		assertFalse(thisSquare.isMarked());
	}
	
	//test Square constructors with Tiles
	public void testSquareTileConstructor(){
		Tile t = new Tile(1, 2, null);
		
		thisSquare.addTile(t);
		
		Square nextSquare = new Square(4, 7, t);
		
		assertTrue(thisSquare.equals(nextSquare));
		
		Square finalSquare = new Square(4, 7, 1, 2);
		
		assertTrue(t.equals(finalSquare.peekTile()));
		assertTrue(thisSquare.equals(finalSquare));
	}
	
	//test Square constructors with both Tiles and marking
	public void testSquareTileConstructorMarked(){
		Tile t = new Tile(1, 2, null);
		
		thisSquare.addTile(t);
		
		assertTrue(thisSquare.equals(new Square(4, 7, t, false)));
		
		assertTrue(thisSquare.equals(new Square(4, 7, 1, 2, false)));
		
	}
	
	//test the accessing of a Tile color through the Square
	public void testSquareTileColor(){
		assertEquals(Color.BLACK, thisSquare.getTileColor());

		thisSquare.addTile(new Tile(1, 1, null));
		
		assertEquals(Color.RED, thisSquare.getTileColor());
	}
	
	//test the accessing of a Tile value through a Square
	public void testSquareTileValue(){
		assertEquals(0, thisSquare.getTileValue());
		
		thisSquare.addTile(new Tile(1, 1, null));
		
		assertEquals(1, thisSquare.getTileValue());
	}
	
	//Test the accessing of a Tile with peekTile and getTile
	public void testSquarePeekVsGet(){
		assertEquals(null, thisSquare.peekTile());
		assertEquals(null, thisSquare.getTile());
		
		Tile t = new Tile(2, 1, null);
		thisSquare.addTile(t);
		
		assertEquals(t, thisSquare.peekTile());
		assertEquals(t, thisSquare.getTile());
		
		assertEquals(null, thisSquare.peekTile());
	}
	
	public void testSquareInert(){
		
		//This should be a standard Square, not inert or a SixesGoal
		thisSquare = new Square(1, 2, 0);
		
		assertFalse(thisSquare.isInert());
		assertFalse(thisSquare.isSixesGoal());
		
		//This should be a Square that is inert but is not a SixesGoal
		thisSquare = new Square(1, 2, 1);
		
		assertTrue(thisSquare.isInert());
		assertFalse(thisSquare.isSixesGoal());
		
		//This should be a Square that is inert but is also not a SixesGoal b/c of column number
		thisSquare = new Square(1, 2, 2);
		assertTrue(thisSquare.isInert());
		assertFalse(thisSquare.isSixesGoal());
		
		//This should be a Square that is both inert and a SixesGoal
		thisSquare = new Square(8, 8, 2);
		assertTrue(thisSquare.isInert());
		assertTrue(thisSquare.isSixesGoal());
		
	}
	
	/**
	 * this test tests the Square.equals(Square) method. Two Squares are the same if they have the same
	 * row and column, Tile, marked value, and inert status. TODO: Are they equal if not both SixesGoal? 
	 * will ask Nathaniel -AB 5/1
	 */
	public void testSquareEquals(){
		
		//didn't think this was happening somehow
		setUp();
		
		//initial test to make sure they are initialized OK
		Square otherSquare = new Square(4,7);
		assertTrue(thisSquare.equals(otherSquare));
		
		Tile t1 = new Tile(1, 3, null);
		Tile t2 = new Tile(1, 3, null);
		
		//Two Squares should be equal if their Tiles are Equal
		thisSquare.addTile(t1);
		assertFalse(thisSquare.equals(otherSquare));

		otherSquare.addTile(t2);
		assertTrue(thisSquare.equals(otherSquare));
		
		
		
		
		
	}

}
