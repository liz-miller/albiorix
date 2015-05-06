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
 * ScoreSave - This boundary class class is used to save to the score 
 * record to indicate that a level has been succesfully completed.
 * @author Sean
 *
 */
public class ScoreSave implements Serializable{
	/**
	 * serializeScore(ScoreRecord victory, int lvlnum) is used
	 * to store the level's information in the score record at
	 * a given level number
	 * @param victory The level's score record
	 * @param lvlnum The number of the level
	 */
	public void serializeScore(ScoreRecord victory, int lvlnum){
 
		try{
			if(lvlnum < 0){
				lvlnum*=-1;
				FileOutputStream fout = new FileOutputStream("./score/scorebuilder"+lvlnum+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fout);   
				oos.writeObject(victory);
				oos.close();
				System.out.println("Done");
			}
			else{
				FileOutputStream fout = new FileOutputStream("./score/score"+lvlnum+".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fout);   
				oos.writeObject(victory);
				oos.close();
				System.out.println("Done");
			}
 
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}