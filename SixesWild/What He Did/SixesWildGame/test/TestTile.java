import java.awt.Color;

import SixesWildGame.model.*;
import junit.framework.TestCase;


public class TestTile extends TestCase{
	
	Tile thisTile;
	
	protected void setUp(){
		thisTile = new Tile(3, 1, null);
	}
	
	protected void tearDown(){
		
	}
	
	/**
	 * 
	 */
	public void testConstructor(){
		//test the constructor from setUp()
		assertEquals(1, thisTile.getMult());
		assertEquals(3, thisTile.getValue());
		assertEquals(null, thisTile.getParent());
		
		//test the creation of a Tile using a val out of bounds
		thisTile = new Tile(7, 1, null);
		assertEquals(1, thisTile.getMult());
		assertEquals(1, thisTile.getValue());
		assertEquals(null, thisTile.getParent());
	}
	
	
	/**
	 * Tests as all possible values of the multiplier value. 
	 */
	public void testBasicTileMult(){
		
		thisTile.setMult(5);
		assertEquals(1, thisTile.getMult());
		
		thisTile.setMult(-1);
		assertEquals( 1, thisTile.getMult());
		
		thisTile.setMult(3);
		assertEquals(3, thisTile.getMult());
		
		//make sure a Tile with a value of 6 can only have a multiplier of 1
		thisTile.setVal(6);
		assertEquals(1, thisTile.getMult());
		thisTile.setMult(3);
		assertEquals(1, thisTile.getMult());
		
	}
	
	/** 
	 * this Test case tests all possible values of a Tile val
	 */
	public void testBasicTileVal(){
		
		//change value to 0
		thisTile.setVal(0);
		assertEquals(3, thisTile.getValue());
		
		//change value to 1
		thisTile.setVal(1);
		assertEquals(1, thisTile.getValue());
		
		//change value to 2
		thisTile.setVal(2);
		assertEquals(2, thisTile.getValue());
		
		//change value to 4
		thisTile.setVal(4);
		assertEquals(4, thisTile.getValue());
		
		//change value to 5
		thisTile.setVal(5);
		assertEquals(5, thisTile.getValue());
		
		//change value to 6
		thisTile.setVal(6);
		assertEquals(6, thisTile.getValue());
		
		//change value to 7
		thisTile.setVal(7);
		assertEquals(6, thisTile.getValue());
	}
	
	/**
	 * Test of a basic relationship between a Tile and a Square
	 */
	public void testBasicTileAndSquare(){
		
		//add a parent
		thisTile.setParent(new Square(5, 6, thisTile));
		
		//assert the add happened correctly
		assertTrue(new Square(5,6, thisTile).equals(thisTile.getParent()));
	}
	
	/**
	 * Test of all possible colorings of Tiles based on their val and selected variables 
	 */
	public void testTileColors(){
		assertEquals(Color.CYAN, thisTile.getColor());
		
		thisTile.setVal(1);
		assertEquals(Color.RED, thisTile.getColor());
		
		thisTile.setVal(2);
		assertEquals(Color.ORANGE, thisTile.getColor());
		
		thisTile.setVal(4);
		assertEquals(Color.MAGENTA, thisTile.getColor());
		
		thisTile.setVal(5);
		assertEquals(Color.GREEN, thisTile.getColor());
		
		thisTile.setVal(6);
		assertEquals(Color.BLUE, thisTile.getColor());
		
		thisTile.setSelected(true);
		assertEquals(Color.GRAY, thisTile.getColor());
		
	}
	
	/**
	 * Test the Tile.equals(Tile) method, which states that two Tiles may be Equal if they 
	 * have the same val and multiplier values. This method does not check Parent Squares.
	 */
	public void testTileEquality(){
		Square s = new Square(3,4);
		Tile otherTile = new Tile(3, 2, s);
		
		assertFalse(thisTile.equals(otherTile));
		
		otherTile.setMult(1);
		assertTrue(thisTile.equals(otherTile));
		
		otherTile.setVal(5);
		assertFalse(thisTile.equals(otherTile));
	}
	
	public void testTileSelected(){
		assertFalse(thisTile.getSelected());
		assertEquals(Color.CYAN, thisTile.getColor());
		
		thisTile.setSelected(true);
		
		assertTrue(thisTile.getSelected());
		assertEquals(Color.GRAY, thisTile.getColor());
	}
}
