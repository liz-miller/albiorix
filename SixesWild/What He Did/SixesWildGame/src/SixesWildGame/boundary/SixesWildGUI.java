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


/**
 * SixesWildGUI - This is the boundary class that displays the pane that the BoardView is displayed on, as well as
 * the buttons that operate the game and the scoreboard for the game itself.
 * @author nmpahowald
 */
public class SixesWildGUI extends JPanel {
	// The vast majority of this info will have to leave this class, in the end
	// this ought
	// to be just the GUI element
	protected JLabel scoreBoard;
	private int boardH = 700;
	private int boardW = 600;
	public final static int boardHW = 9;
	private int tileSize = 60;
	private int count = 0;
	// public static int pointMult = 1;
	private boolean dragging = false;
	private int numClicked = 0;
	private int point = 0;
	private Tile allTiles[];
	private Stack<Tile> swipedTiles;
	private int topCorner = 40;

	private JButton btnEliminateTile;


	private JButton btnSwapTile;
	
	private JButton btnResetBoard;

	Board board;
	BoardView bv;
	Application app;

	public SixesWildGUI(Application app, Board b) {
		super();
		this.board = b;
		this.app = app;

		initialize();
	}
	
	public void upDateStatViews(){
		scoreBoard.setText("Score: " + point + ", Moves Left: "
				+ board.getMovesLeft());
		btnEliminateTile.setText("Eliminate Tile (" + board.getEliminateTilesLeft() + " left)");
		btnSwapTile.setText("Swap Tiles (" + board.getSwapTilesLeft() + " left)");
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
				+ board.getMovesLeft());
		scoreBoard.setBounds(33, 15, 150, 16);
		add(scoreBoard);

		btnResetBoard = new JButton("Reset Board");
		btnResetBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.resetBoard();
				board.decreaseMovesLeft();
				scoreBoard.setText("Score: " + point + ", Moves Left: "
						+ board.getMovesLeft());
				bv.revalidate();
				bv.repaint();

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

		btnEliminateTile = new JButton("Eliminate Tile (" + board.getEliminateTilesLeft() + " left)");

		// This listener will have to go into a separate class
		// Theoretically, we could have a TileGUI class, that might our "art" a
		// little easier
		btnEliminateTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (board.getEliminateTilesLeft() > 0) {
					bv.eliminateTileState = true;
					bv.swapTileState = false;
					board.decreaseEliminateTilesLeft();
					btnEliminateTile.setText("Eliminate Tile (" + board.getEliminateTilesLeft() + " left)");
				}
			}
		});
		btnEliminateTile.setBounds(404, 11, 174, 29);
		add(btnEliminateTile);

		btnSwapTile = new JButton("Swap Tiles (" + board.getSwapTilesLeft() + " left)");
		// and this one
		btnSwapTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (board.getSwapTilesLeft() > 0) {
					// I used these booleans to control the state of the program
					bv.eliminateTileState = false;
					bv.swapTileState = true;
					board.decreaseSwapTilesLeft();
					btnSwapTile.setText("Swap Tiles (" + board.getSwapTilesLeft() + " left)");
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
		bv.setBounds(43, 131, boardH, boardW);
		add(bv);

		add(starLabel);
	}

}
