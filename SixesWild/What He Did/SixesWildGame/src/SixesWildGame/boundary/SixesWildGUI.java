package SixesWildGame.boundary;

import java.awt.BorderLayout;



//import javax.media.j3d.Billboard;
import javax.swing.border.*;

import java.awt.EventQueue;
import java.awt.MouseInfo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import SixesWildGame.controller.MouseController;
import SixesWildGame.controller.ResetButtonController;
import SixesWildGame.model.Board;
import SixesWildGame.model.Lightning;
import SixesWildGame.model.Tile;
import SixesWildGame.model.Level;
import SixesWildGame.model.Puzzle;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Stack;
import java.util.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//imported to make the timer work
import java.util.TimerTask;
import java.util.Timer;

/**
 * SixesWildGUI - This is the boundary class that displays the pane that the
 * BoardView is displayed on, as well as the buttons that operate the game and
 * the scoreboard for the game itself.
 * 
 * @author nmpahowald
 */
public class SixesWildGUI extends JPanel {
	protected JLabel scoreBoard;
	public final static int boardHW = 9;

	private JButton btnEliminateTile;

	private JButton btnSwapTile;

	private JButton btnResetBoard;
	private JLabel starLabel;

	Level level;
	BoardView bv;
	Application app;

	public SixesWildGUI(Application app, Level l) {
		super();
		this.level = l;
		this.app = app;

		initialize();
	}
	
	//-- save a level configuration to disk for testing
	public void saveToDisk(){
		Serializer serializer = new Serializer();
		serializer.serializeLevel(level);
	}
	
	//-- load a level configuration from disk for testing
	public void loadFromDisk(){
		Deserializer deserializer = new Deserializer();
		level = deserializer.deserializeLevel(level);
	}

	public void updateStatViews() {
		if (level.endGame()) {
		    app.Levelinfo(level.getScore(),level.numStars());
			if(level.numStars() >= 1){
				app.toMenu(7);
			}
			else{
				app.toMenu(8);
			}
				
		} else {
			if (level instanceof Lightning) {
				scoreBoard.setText("Score: " + level.getScore()
						+ ", Time Left: " + ((Lightning) level).getTime());
			} else if (level instanceof Puzzle) {
				scoreBoard.setText("Score: " + level.getScore()
						+ ", Moves Left: " + level.getMovesLeft());
			} else{
				scoreBoard.setText("Score: " + level.getScore()
						+ ", Moves: " + level.getMovesLeft());
			}
			btnEliminateTile.setText("Eliminate Tile ("
					+ level.getEliminateTilesLeft() + " left)");
			btnSwapTile.setText("Swap Tiles (" + level.getSwapTilesLeft()
					+ " left)");
			String starString = "";
			for (int i = 0; i < level.numStars(); i++) {
				starString = starString + "\u2606 ";
			}
			starLabel.setText(starString);
		}
	}

	// setter variable and method
	public JLabel getScoreBoard() {
		return scoreBoard;
	}

	void initialize() {
	
		//-- pull up saved level
		//this.loadFromDisk();
		
		bv = new BoardView(level);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		setLayout(null);
		scoreBoard = new JLabel();
		if (level instanceof Lightning) {
			// <-- change to real code
			// the clock to display time left
			Timer theTimer = new Timer();
			ClockTick clockTick = new ClockTick((Lightning) level, theTimer,
					this);
			theTimer.scheduleAtFixedRate(clockTick, 1000, 1000);
			scoreBoard.setText("Score: " + level.getScore() + ", Time Left: "
					+ ((Lightning) level).getTime());

		} else if (level instanceof Puzzle) {
			scoreBoard.setText("Score: " + level.getScore()
					+ ", Moves Left: " + level.getMovesLeft());
		} else{
			scoreBoard.setText("Score: " + level.getScore()
					+ ", Moves: " + level.getMovesLeft());
		}
		scoreBoard.setBounds(33, 15, 200, 16);
		add(scoreBoard);

		btnResetBoard = new JButton("Reset Board");
		ResetButtonController rbc = new ResetButtonController(level, bv, this);
		btnResetBoard.addActionListener(rbc);
		btnResetBoard.setBounds(244, 10, 117, 29);
		add(btnResetBoard);

		JButton btnBack = new JButton("Back to Main Menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				app.toMenu(1);

			}
		});
		btnBack.setBounds(21, 650, 162, 29);
		add(btnBack);

		btnEliminateTile = new JButton("Eliminate Tile ("
				+ level.getEliminateTilesLeft() + " left)");

		
		btnEliminateTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (level.getEliminateTilesLeft() > 0) {
					level.setEliminateTileState(true);
					level.setSwapTileState(false);
					btnEliminateTile.setText("Eliminate Tile ("
							+ level.getEliminateTilesLeft() + " left)");
				}
			}
		});
		btnEliminateTile.setBounds(404, 11, 174, 29);
		add(btnEliminateTile);

		btnSwapTile = new JButton("Swap Tiles (" + level.getSwapTilesLeft()
				+ " left)");
		// and this one
		btnSwapTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level.getSwapTilesLeft() > 0) {
					// I used these booleans to control the state of the program
					level.setEliminateTileState(false);
					level.setSwapTileState(true);

					btnSwapTile.setText("Swap Tiles ("
							+ level.getSwapTilesLeft() + " left)");
				}
			}
		});
		btnSwapTile.setBounds(43, 43, 155, 29);
		add(btnSwapTile);

		// our "stars"
		starLabel = new JLabel("");
		starLabel.setForeground(Color.BLACK);
		starLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		starLabel.setBounds(267, 78, 100, 31);
		add(starLabel);

		
		MouseController mc = new MouseController(app, bv, level.getBoard());
		bv.addMouseListener(mc);
		bv.addMouseMotionListener(mc);
		bv.setBounds(43, 131, 600, 520);
		add(bv);
		
		//-- end of initialize. Save level to disk
		//this.saveToDisk();

	}

}
