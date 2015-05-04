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
 * 
 * @author Sean
 *
 */
public class ScoreLoad{
	
	public ScoreRecord deserializeScore(int lvlnum){
 
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