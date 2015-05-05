package SixesWildGame.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

import SixesWildGame.model.Level;
import SixesWildGame.model.Lightning;
import SixesWildGame.model.Puzzle;
import SixesWildGame.boundary.VictoryScreen;

//-- stores end-of-level data
/**
 * ScoreRecord - This boundary class is used for storing the information for each 
 * level for the purpose of displaying the information on the Level Select 
 * screen and unlocking levels.
 * @author Sean
 *
 */
public class ScoreRecord implements Serializable{

	private JPanel contentPane;
	//Application app;
	int score;
	int stars;
	int levelNum;
	/**
	 * Constructor for ScoreRecord inputs the level score, stars and level number
	 * @param scoring The score of the level
	 * @param star The number of stars in the level
	 * @param levelNum The number of the level
	 */
	public ScoreRecord(/*Application app,*/ int scoring, int star, int levelNum) {
		//this.app = app;
		this.score = scoring;
		this.stars = star;
        this.levelNum = levelNum;
	}
	/**
	 * getScore() is a getter for the score of the level
	 * @return score
	 */
	public int getScore(){
		return score;
	}
	/**
	 * getStars() is a getter for the number of stars in the level
	 * @return stars
	 */
	public int getStars(){
		return stars;
	}
	/**
	 * getLevelNum() is a getter for the number of the level
	 * @return levelNum
	 */
	public int getLevelNum(){
		return levelNum;
	}
}
