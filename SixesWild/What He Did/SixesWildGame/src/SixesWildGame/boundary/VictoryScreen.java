package SixesWildGame.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class VictoryScreen extends JPanel{

	private JPanel contentPane;
	int score;
	int stars;
	Application app;
	/**
	 * Launch the application.
	 */


	public VictoryScreen(Application app, int scoring, int star) {
		super();
		this.score = scoring;
		this.stars = star;
		initialize();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initialize() {
		setLayout(null);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(183, 171, 52, 23);
		add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.toMenu(2);
			}
		});
		
		JLabel lblYouWon = new JLabel("You Won");
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