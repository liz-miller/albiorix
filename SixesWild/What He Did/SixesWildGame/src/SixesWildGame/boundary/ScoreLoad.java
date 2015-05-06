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
/**
 * ScoreLoad - This boundary class is used to load levels using
 * the score record to determine the stars, score and locked/unlocked
 * status from the score record.
 * @author Sean
 *
 */
public class ScoreLoad{
	/**
	 * deserializeScore(String lvlnum) is used
	 * to get the score record at a given level
	 * @param lvlnum The number of the level
	 * @return victory
	 */
	public ScoreRecord deserializeScore(String lvlnum){
 
		try{
 
			ScoreRecord victory;
			FileInputStream fin = new FileInputStream("./score/score"+lvlnum+".ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			victory = (ScoreRecord) ois.readObject();
			ois.close();
 
			return victory;
 
		}catch(Exception ex){
			//ex.printStackTrace();
			return null;
		} 
	} 
}