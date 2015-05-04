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
 *  
 * @author Sean
 *
 */
public class ScoreSave {
  
	public void serializeScore(ScoreRecord victory, int lvlnum){
 
		try{
 
			FileOutputStream fout = new FileOutputStream("./score/score"+lvlnum+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(victory);
			oos.close();
			System.out.println("Done");
 
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}