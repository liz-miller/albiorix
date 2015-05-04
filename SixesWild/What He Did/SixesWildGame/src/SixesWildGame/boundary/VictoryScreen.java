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
/**
 * VictoryScreen - This is the Boundary class which displays the victory screen
 * @author William
 *
 */
public class VictoryScreen extends JPanel{

	private JPanel contentPane;
	int score;
	int stars;
	Application app;
	int levelNum;
	/**
	 * Constructor for VictoryScreen uses the application class, as well as the score and stars from the level
	 * @param app The application class which handles going through the different screens
	 * @param scoring The score from the level
	 * @param star The star(s) from the level
	 * @param levelNum The number of the level 
	 */
	public VictoryScreen(Application app, int scoring, int star, int levelNum) {
		super();
		this.score = scoring;
		this.stars = star;
        this.app = app;
        this.levelNum = levelNum;
		initialize();
	}
	/**
	 * initialize() will create the victory screen
	 */
	public void initialize() {
		
		//-- save the final score to disk
		ScoreRecord gameStats = new ScoreRecord(/*app,*/ score, stars, levelNum);
		ScoreSave scoreSave = new ScoreSave();
		scoreSave.serializeScore(gameStats, levelNum);
		
		setLayout(null);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(183, 171, 52, 23);
		add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.toMenu(2);
			}
		});
		
		JLabel lblYouWon = new JLabel("You Win");
		lblYouWon.setBounds(183, 60, 78, 14);
		add(lblYouWon);
		
		JLabel lblScore = new JLabel("Score: " + score);
		lblScore.setBounds(152, 94, 78, 14);
		add(lblScore);
		
		JLabel lblNewLabel = new JLabel("Stars: "+ stars);
		lblNewLabel.setBounds(152, 119, 78, 14);
		add(lblNewLabel);
	}
}
