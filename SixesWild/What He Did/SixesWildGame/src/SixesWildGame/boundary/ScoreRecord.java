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
 * 
 * @author Sean
 *
 */
public class ScoreRecord implements Serializable{

	private JPanel contentPane;
	Application app;
	int score;
	int stars;
	int levelNum;

	public ScoreRecord(Application app, int scoring, int star, int levelNum) {
		this.app = app;
		this.score = scoring;
		this.stars = star;
        this.levelNum = levelNum;
	}
}
