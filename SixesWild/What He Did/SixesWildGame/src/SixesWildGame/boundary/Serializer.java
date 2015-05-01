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
 
public class Serializer {
 
	/*
   	public static void main (String args[]) {
 
	   Serializer serializer = new Serializer();
	   serializer.serializeLevel(levelName);
   	}
	*/
 
	public void serializeLevel(Level level, int lvlnum){
 
		try{
 
			FileOutputStream fout = new FileOutputStream("./level/level"+lvlnum+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(level);
			oos.close();
			System.out.println("Done");
 
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}