package SixesWildGame.boundary;

import java.awt.event.*;

import SixesWildGame.boundary.Application;
import SixesWildGame.boundary.BoardView;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.model.Board;
import SixesWildGame.model.Square;
import SixesWildGame.model.Tile;
import SixesWildGame.model.Puzzle;
import SixesWildGame.model.Level;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
 
public class Deserializer{
 
	/*
   	public static void main (String args[]) {
 
	   Deserializer deserializer = new Deserializer();
	   Level level = deserializer.deserialzeLevel();
	   System.out.println(level);
   	}
	*/
	
	public Level deserializeLevel(int lvlnum){
 
		try{
 
			Level level;
			FileInputStream fin = new FileInputStream("./level/level"+lvlnum+".ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			level = (Level) ois.readObject();
			ois.close();
 
			return level;
 
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		} 
	} 
}