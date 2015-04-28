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
import SixesWildGame.model.Board;
import SixesWildGame.model.Tile;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Random;
import java.util.Stack;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SixesWildGUI extends JPanel {
	// The vast majority of this info will have to leave this class, in the end
	// this ought
	// to be just the GUI element
	private JLabel scoreBoard;
	private int windowH = 700;
	private int windowW = 700;
	public final static int boardHW = 9;
	private int tileSize = 60;
	private int count = 0;
	// public static int pointMult = 1;
	private boolean dragging = false;
	private int numClicked = 0;
	private int movesLeft = 20;
	private int point = 0;
	private Tile allTiles[];
	private Stack<Tile> swipedTiles;
	private int topCorner = 40;

	private JButton btnEliminateTile;
	private int eliminateTilesLeft = 3;

	private JButton btnSwapTile;
	private int swapTilesLeft = 3;

	Board board;
	BoardView bv;
	Application app;

	public SixesWildGUI(Application app, Board b) {
		super();
		this.board = b;
		this.app = app;

		initialize();
	}

	void initialize() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, windowW, windowH);

		setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);

		swipedTiles = new Stack<Tile>(); // Used to hold the tiles as they were
											// swiped
		setLayout(null);
		scoreBoard = new JLabel("Score: " + point + ", Moves Left: "
				+ movesLeft);
		scoreBoard.setBounds(33, 15, 150, 16);
		add(scoreBoard);

		JButton btnResetBoard = new JButton("Reset Board");
		btnResetBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movesLeft--;
				scoreBoard.setText("Score: " + point + ", Moves Left: "
						+ movesLeft);

			}
		});
		btnResetBoard.setBounds(244, 10, 117, 29);
		add(btnResetBoard);

		JButton btnBack = new JButton("Back to Main Menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				app.toMenu(1);

			}
		});
		btnBack.setBounds(21, 750, 162, 29);
		add(btnBack);

		btnEliminateTile = new JButton("Eliminate Tile (" + eliminateTilesLeft + " left)");

		// This listener will have to go into a separate class
		// Theoretically, we could have a TileGUI class, that might our "art" a
		// little easier
		btnEliminateTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (eliminateTilesLeft > 0) {
					bv.eliminateTileState = true;
					bv.swapTileState = false;
					eliminateTilesLeft--;
					btnEliminateTile.setText("Eliminate Tile (" + eliminateTilesLeft + " left)");
				}
			}
		});
		btnEliminateTile.setBounds(404, 11, 174, 29);
		add(btnEliminateTile);

		btnSwapTile = new JButton("Swap Tiles (" + swapTilesLeft + " left)");
		// and this one
		btnSwapTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (swapTilesLeft > 0) {
					// I used these booleans to control the state of the program
					bv.eliminateTileState = false;
					bv.swapTileState = true;
					swapTilesLeft--;
					btnSwapTile.setText("Swap Tiles (" + swapTilesLeft + " left)");
				}
			}
		});
		btnSwapTile.setBounds(43, 43, 155, 29);
		add(btnSwapTile);

		// our "stars"
		JLabel starLabel = new JLabel("\u2606 \u2606 \u2606");
		starLabel.setForeground(Color.BLACK);
		starLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));

		starLabel.setBounds(267, 78, 91, 31);

		bv = new BoardView(board);
		MouseController mc = new MouseController(app, bv, board);
		bv.addMouseListener(mc);
		bv.addMouseMotionListener(mc);
		bv.setBounds(43, 131, 700, 700);
		add(bv);

		add(starLabel);
	}

}
