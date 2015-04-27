import SixesWildGame.model.*;

import junit.framework.TestCase;


public class TestTile extends TestCase{
	
	Tile thisTile;
	
	protected void setUp(){
		thisTile = new Tile(3, 1, null);
	}
	
	protected void tearDown(){
		
	}
	
	public void testBasicTileMult(){
		
		assertEquals(1, thisTile.getMult());
		assertEquals(3, thisTile.getValue());
		assertEquals(null, thisTile.getParent());
		
		thisTile.setMult(5);
		
		assertEquals(1, thisTile.getMult());
		
		thisTile.setMult(-1);
		
		assertEquals( 1, thisTile.getMult());
		
		thisTile.setMult(3);
		
		assertEquals(3, thisTile.getMult());
		
	}
	
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
	
	public void testBasicTileAndSquare(){
		
		//add a parent
		thisTile.setParent(new Square(5, 6, thisTile));
		
		//assert the add happened correctly
		assertTrue(new Square(5,6, thisTile).equals(thisTile.getParent()));
	}
}
