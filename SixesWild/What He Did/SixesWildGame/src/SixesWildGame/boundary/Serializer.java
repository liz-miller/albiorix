package SixesWildGame.boundary;

import java.io.FileOutputStream;

import java.awt.event.*;

import SixesWildGame.boundary.Application;
import SixesWildGame.boundary.BoardView;
import SixesWildGame.boundary.SixesWildGUI;
import SixesWildGame.model.Board;
import SixesWildGame.model.Square;
import SixesWildGame.model.Tile;
import SixesWildGame.model.Puzzle;
import SixesWildGame.model.Level;

import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Serializer - This is the boundary class used for saving levels 
 * @author Sean
 *
 */
public class Serializer {
 
 /**
  * serializeLevel(int lvlnum) saves the level indicated by the level to the given lvlnum
  * @param level The level to save
  * @param lvlnum  The level number to save to
  */
	public void serializeLevel(Level level, int lvlnum){
 
		try{
			if(lvlnum < 0){
				lvlnum*=-1;
				FileOutputStream fout = new FileOutputStream("./level/levelbuilder"+lvlnum+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fout);   
				oos.writeObject(level);
				oos.close();
				System.out.println("Done");
			}
			else{
				FileOutputStream fout = new FileOutputStream("./level/level"+lvlnum+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fout);   
				oos.writeObject(level);
				oos.close();
				System.out.println("Done");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}