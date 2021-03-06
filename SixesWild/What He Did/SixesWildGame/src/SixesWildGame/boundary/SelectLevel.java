package SixesWildGame.boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import SixesWildGame.model.Level;
import SixesWildGame.model.Lightning;
import SixesWildGame.boundary.ScoreRecord;
import SixesWildGame.boundary.ScoreLoad;
import SixesWildGame.boundary.Deserializer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
/**
 * SelectLevel - This is the Boundary class which displays the level select menu
 * @author Sean
 *
 */
public class SelectLevel extends JPanel {

	Application app;

	/**
	 * Constructor for SelectLevel uses the application class
	 * @param app The application class which handles going through the different screens
	 */
	
	private ScoreRecord[] records;
	private ScoreRecord[] builderScores;


	public SelectLevel(Application app) {
		super();
		this.app = app;

		initialize();
	}
	
	/**
	 * For Testing purposes only, gets the ScoreRecord array
	 */
	public ScoreRecord[] getScoreRecords(){
		return records;
	}
	/**
	 * For Testing purposes only, gets the Board ScoreRecord array
	 */
	public ScoreRecord[] getBuilderScores(){
		return builderScores;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		setLayout(null);

		JLabel lblSelectYourLevel = new JLabel("Select Your Level");
		lblSelectYourLevel.setBounds(5, 9, 137, 14);
		add(lblSelectYourLevel);
		
		int i = 0;
		records = new ScoreRecord[17];
		builderScores = new ScoreRecord[5];
		
		Level[] playerLevels = new Level[17];
		ScoreRecord[] builderScores = new ScoreRecord[5];
		Level[] builderLevels = new Level[5];
		ScoreLoad scoreLoad = new ScoreLoad();
		Deserializer loadLevel = new Deserializer();
		//load score sheets for provided levels
		for(i=0; i<16; i++){
			records[i] = scoreLoad.deserializeScore(Integer.toString(i+1));
		}
		for(i=0; i<16; i++){
			playerLevels[i] = loadLevel.deserializeLevel(Integer.toString(i+1));
		}
		//load score sheets for builder levels
		builderScores[0] = scoreLoad.deserializeScore("builder1");
		builderScores[1] = scoreLoad.deserializeScore("builder2");
		builderScores[2] = scoreLoad.deserializeScore("builder3");
		builderScores[3] = scoreLoad.deserializeScore("builder4");
		
		//load builder levels
		builderLevels[0] = loadLevel.deserializeLevel("builder1");
		builderLevels[1] = loadLevel.deserializeLevel("builder2");
		builderLevels[2] = loadLevel.deserializeLevel("builder3");
		builderLevels[3] = loadLevel.deserializeLevel("builder4");
		
		
		
		int level_unlocked = 0;
		ScoreRecord score = new ScoreRecord(0, 0, 0);
		while(score != null){
			score = records[level_unlocked];
			level_unlocked++;
			if(level_unlocked>15){
				score = null;
			}
		}
						
		//start first row
		JLabel label = new JLabel();
		label.setBounds(5, 55, 100, 23);
		JLabel s_label = new JLabel();
		s_label.setBounds(5, 68, 100, 23);
		if(records[0] == null){
			label.setText(" ");
			s_label.setText(" ");
		}
		else{
			label.setText("Score: " + records[0].getScore());
			if(records[0].getStars() == 3){
				s_label.setText("\u2606 \u2606 \u2606");
			}
			else if(records[0].getStars() == 2){
				s_label.setText("\u2606 \u2606");
			}
			else if(records[0].getStars() == 1){
				s_label.setText("\u2606");
			}
		}
		add(label);
		add(s_label);
		
		JButton button = new JButton("1 - Locked");
		button.setBounds(5, 34, 100, 23);
		if(level_unlocked > 0){
			if(playerLevels[0] != null){
				button.setText("1");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(10);
					}
				});
			}
		}
		add(button);
				
		JLabel label_1 = new JLabel();
		label_1.setBounds(115, 55, 100, 23);
		JLabel s_label_1 = new JLabel();
		s_label_1.setBounds(115, 68, 100, 23);
		if(records[1] == null){
			label_1.setText(" ");
			s_label_1.setText(" ");
		}
		else{
			label_1.setText("Score: " + records[1].getScore());
			if(records[1].getStars() == 3){
				s_label_1.setText("\u2606 \u2606 \u2606");
			}
			else if(records[1].getStars() == 2){
				s_label_1.setText("\u2606 \u2606");
			}
			else if(records[1].getStars() == 1){
				s_label_1.setText("\u2606");
			}
		}
		add(label_1);
		add(s_label_1);
		
		JButton button_1 = new JButton("2 - Locked");
		button_1.setBounds(115, 34, 100, 23);
		if(level_unlocked > 1){
			if(playerLevels[1] != null){
				button_1.setText("2");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(11);
					}
				});
			}
		}
		add(button_1);
		
		JLabel label_2 = new JLabel();
		label_2.setBounds(225, 55, 100, 23);
		JLabel s_label_2 = new JLabel();
		s_label_2.setBounds(225, 68, 100, 23);
		if(records[2] == null){
			label_2.setText(" ");
			s_label_2.setText(" ");
		}
		else{
			label_2.setText("Score: " + records[2].getScore());
			if(records[2].getStars() == 3){
				s_label_2.setText("\u2606 \u2606 \u2606");
			}
			else if(records[2].getStars() == 2){
				s_label_2.setText("\u2606 \u2606");
			}
			else if(records[2].getStars() == 1){
				s_label_2.setText("\u2606");
			}
		}
		add(label_2);
		add(s_label_2);
		
		JButton button_2 = new JButton("3 - Locked");
		button_2.setBounds(225, 34, 100, 23);
		if(level_unlocked > 2){
			if(playerLevels[2] != null){
				button_2.setText("3");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(12);
					}
				});
			}
		}
		add(button_2);
		
		JLabel label_3 = new JLabel();
		label_3.setBounds(335, 55, 100, 23);
		JLabel s_label_3 = new JLabel();
		s_label_3.setBounds(335, 68, 100, 23);
		if(records[3] == null){
			label_3.setText(" ");
			s_label_3.setText(" ");
		}
		else{
			label_3.setText("Score: " + records[3].getScore());
			if(records[3].getStars() == 3){
				s_label_3.setText("\u2606 \u2606 \u2606");
			}
			else if(records[3].getStars() == 2){
				s_label_3.setText("\u2606 \u2606");
			}
			else if(records[3].getStars() == 1){
				s_label_3.setText("\u2606");
			}
		}
		add(label_3);
		add(s_label_3);
		
		JButton button_3 = new JButton("4 - Locked");
		button_3.setBounds(335, 34, 100, 23);
		if(level_unlocked > 3){
			if(playerLevels[3] != null){
				button_3.setText("4");
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(13);
					}
				});
			}
		}
		add(button_3);

		JLabel label_4 = new JLabel();
		label_4.setBounds(445, 55, 100, 23);
		JLabel s_label_4 = new JLabel();
		s_label_4.setBounds(445, 68, 100, 23);
		if(records[4] == null){
			label_4.setText(" ");
			s_label_4.setText(" ");
		}
		else{
			label_4.setText("Score: " + records[4].getScore());
			if(records[4].getStars() == 3){
				s_label_4.setText("\u2606 \u2606 \u2606");
			}
			else if(records[4].getStars() == 2){
				s_label_4.setText("\u2606 \u2606");
			}
			else if(records[4].getStars() == 1){
				s_label_4.setText("\u2606");
			}
		}
		add(label_4);
		add(s_label_4);
		
		JButton button_4 = new JButton("5 - Locked");
		button_4.setBounds(445, 34, 100, 23);
		if(level_unlocked > 4){
			if(playerLevels[4] != null){
				button_4.setText("5");
				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(14);
					}
				});
			}
		}
		add(button_4);
						
		JLabel label_5 = new JLabel();
		label_5.setBounds(555, 55, 100, 23);
		JLabel s_label_5 = new JLabel();
		s_label_5.setBounds(555, 68, 100, 23);
		if(records[5] == null){
			label_5.setText(" ");
			s_label_5.setText(" ");
		}
		else{
			label_5.setText("Score: " + records[5].getScore());
			if(records[5].getStars() == 3){
				s_label_5.setText("\u2606 \u2606 \u2606");
			}
			else if(records[5].getStars() == 2){
				s_label_5.setText("\u2606 \u2606");
			}
			else if(records[5].getStars() == 1){
				s_label_5.setText("\u2606");
			}
		}
		add(label_5);
		add(s_label_5);
		
		JButton button_5 = new JButton("6 - Locked");
		button_5.setBounds(555, 34, 100, 23);
		if(level_unlocked > 5){
			if(playerLevels[5] != null){
				button_5.setText("6");
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(15);
					}
				});
			}
		}
		add(button_5);
		//end first row
		
		//start second row
		JLabel label_6 = new JLabel();
		label_6.setBounds(5, 131, 100, 23);
		JLabel s_label_6 = new JLabel();
		s_label_6.setBounds(5, 144, 100, 23);
		if(records[6] == null){
			label_6.setText(" ");
			s_label_6.setText(" ");
		}
		else{
			label_6.setText("Score: " + records[6].getScore());
			if(records[6].getStars() == 3){
				s_label_6.setText("\u2606 \u2606 \u2606");
			}
			else if(records[6].getStars() == 2){
				s_label_6.setText("\u2606 \u2606");
			}
			else if(records[6].getStars() == 1){
				s_label_6.setText("\u2606");
			}
		}
		add(label_6);
		add(s_label_6);
		
		JButton button_6 = new JButton("7 - Locked");
		button_6.setBounds(5, 108, 100, 23);
		if(level_unlocked > 6){
			if(playerLevels[6] != null){
				button_6.setText("7");
				button_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(16);
					}
				});
			}
		}
		add(button_6);
		
		JLabel label_7 = new JLabel();
		label_7.setBounds(115, 131, 100, 23);
		JLabel s_label_7 = new JLabel();
		s_label_7.setBounds(115, 144, 100, 23);
		if(records[7] == null){
			label_7.setText(" ");
			s_label_7.setText(" ");
		}
		else{
			label_7.setText("Score: " + records[7].getScore());
			if(records[7].getStars() == 3){
				s_label_7.setText("\u2606 \u2606 \u2606");
			}
			else if(records[7].getStars() == 2){
				s_label_7.setText("\u2606 \u2606");
			}
			else if(records[7].getStars() == 1){
				s_label_7.setText("\u2606");
			}
		}
		add(label_7);
		add(s_label_7);
		
		JButton button_7 = new JButton("8 - Locked");
		button_7.setBounds(115, 108, 100, 23);
		if(level_unlocked > 7){
			if(playerLevels[7] != null){
				button_7.setText("8");
				button_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(17);
					}
				});
			}
		}
		add(button_7);
		
		JLabel label_8 = new JLabel();
		label_8.setBounds(225, 131, 100, 23);
		JLabel s_label_8 = new JLabel();
		s_label_8.setBounds(225, 144, 100, 23);
		if(records[8] == null){
			label_8.setText(" ");
			s_label_8.setText(" ");
		}
		else{
			label_8.setText("Score: " + records[8].getScore());
			if(records[8].getStars() == 3){
				s_label_8.setText("\u2606 \u2606 \u2606");
			}
			else if(records[8].getStars() == 2){
				s_label_8.setText("\u2606 \u2606");
			}
			else if(records[8].getStars() == 1){
				s_label_8.setText("\u2606");
			}
		}
		add(label_8);
		add(s_label_8);
		
		JButton button_8 = new JButton("9 - Locked");
		button_8.setBounds(225, 108, 100, 23);
		if(level_unlocked > 8){
			if(playerLevels[8] != null){
				button_8.setText("9");
				button_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(18);
					}
				});
			}
		}
		add(button_8);
		
		JLabel label_9 = new JLabel();
		label_9.setBounds(335, 131, 100, 23);
		JLabel s_label_9 = new JLabel();
		s_label_9.setBounds(335, 144, 100, 23);
		if(records[9] == null){
			label_9.setText(" ");
			s_label_9.setText(" ");
		}
		else{
			label_9.setText("Score: " + records[9].getScore());
			if(records[9].getStars() == 3){
				s_label_9.setText("\u2606 \u2606 \u2606");
			}
			else if(records[9].getStars() == 2){
				s_label_9.setText("\u2606 \u2606");
			}
			else if(records[9].getStars() == 1){
				s_label_9.setText("\u2606");
			}
		}
		add(label_9);
		add(s_label_9);
		
		JButton button_9 = new JButton("10 - Locked");
		button_9.setBounds(335, 108, 100, 23);
		if(level_unlocked > 9){
			if(playerLevels[9] != null){
				button_9.setText("10");
				button_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(19);
					}
				});
			}
		}
		add(button_9);
		
		JLabel label_10 = new JLabel();
		label_10.setBounds(445, 131, 100, 23);
		JLabel s_label_10 = new JLabel();
		s_label_10.setBounds(445, 144, 100, 23);
		if(records[10] == null){
			label_10.setText(" ");
			s_label_10.setText(" ");
		}
		else{
			label_10.setText("Score: " + records[10].getScore());
			if(records[10].getStars() == 3){
				s_label_10.setText("\u2606 \u2606 \u2606");
			}
			else if(records[10].getStars() == 2){
				s_label_10.setText("\u2606 \u2606");
			}
			else if(records[10].getStars() == 1){
				s_label_10.setText("\u2606");
			}
		}
		add(label_10);
		add(s_label_10);
		
		JButton button_10 = new JButton("11 - Locked");
		button_10.setBounds(445, 108, 100, 23);
		if(level_unlocked > 10){
			if(playerLevels[10] != null){
				button_10.setText("11");
				button_10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(20);
					}
				});
			}
		}
		add(button_10);
				
		JLabel label_11 = new JLabel();
		label_11.setBounds(555, 131, 100, 23);
		JLabel s_label_11 = new JLabel();
		s_label_11.setBounds(555, 144, 100, 23);
		if(records[11] == null){
			label_11.setText(" ");
			s_label_11.setText(" ");
		}
		else{
			label_11.setText("Score: " + records[11].getScore());
			if(records[11].getStars() == 3){
				s_label_11.setText("\u2606 \u2606 \u2606");
			}
			else if(records[11].getStars() == 2){
				s_label_11.setText("\u2606 \u2606");
			}
			else if(records[11].getStars() == 1){
				s_label_11.setText("\u2606");
			}
		}
		add(label_11);
		add(s_label_11);
		
		JButton button_11 = new JButton("12 - Locked");
		button_11.setBounds(555, 108, 100, 23);
		if(level_unlocked > 11){
			if(playerLevels[11] != null){
				button_11.setText("12");
				button_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(21);
					}
				});
			}
		}
		add(button_11);
		//end second row
		
		//start third row
		JLabel label_12 = new JLabel();
		label_12.setBounds(5, 209, 100, 23);
		JLabel s_label_12 = new JLabel();
		s_label_12.setBounds(5, 224, 100, 23);
		if(records[12] == null){
			label_12.setText(" ");
			s_label_12.setText(" ");
		}
		else{
			label_12.setText("Score: " + records[12].getScore());
			if(records[12].getStars() == 3){
				s_label_12.setText("\u2606 \u2606 \u2606");
			}
			else if(records[12].getStars() == 2){
				s_label_12.setText("\u2606 \u2606");
			}
			else if(records[12].getStars() == 1){
				s_label_12.setText("\u2606");
			}
		}
		add(label_12);
		add(s_label_12);
		
		JButton button_12 = new JButton("13 - Locked");
		button_12.setBounds(5, 187, 100, 23);
		if(level_unlocked > 12){
			if(playerLevels[12] != null){
				button_12.setText("13");
				button_12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(22);
					}
				});
			}
		}
		add(button_12);	
		
		JLabel label_13 = new JLabel();
		label_13.setBounds(115, 209, 100, 23);
		JLabel s_label_13 = new JLabel();
		s_label_13.setBounds(115, 224, 100, 23);
		if(records[13] == null){
			label_13.setText(" ");
			s_label_13.setText(" ");
		}
		else{
			label_13.setText("Score: " + records[13].getScore());
			if(records[13].getStars() == 3){
				s_label_13.setText("\u2606 \u2606 \u2606");
			}
			else if(records[13].getStars() == 2){
				s_label_13.setText("\u2606 \u2606");
			}
			else if(records[13].getStars() == 1){
				s_label_13.setText("\u2606");
			}
		}
		add(label_13);
		add(s_label_13);
		
		JButton button_13 = new JButton("14 - Locked");
		button_13.setBounds(115, 187, 100, 23);
		if(level_unlocked > 13){
			if(playerLevels[13] != null){
				button_13.setText("14");
				button_13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(23);
					}
				});
			}
		}
		add(button_13);		
		
		JLabel label_14 = new JLabel();
		label_14.setBounds(225, 209, 100, 23);
		JLabel s_label_14 = new JLabel();
		s_label_14.setBounds(225, 224, 100, 23);
		if(records[14] == null){
			label_14.setText(" ");
			s_label_14.setText(" ");
		}
		else{
			label_14.setText("Score: " + records[14].getScore());
			if(records[14].getStars() == 3){
				s_label_14.setText("\u2606 \u2606 \u2606");
			}
			else if(records[14].getStars() == 2){
				s_label_14.setText("\u2606 \u2606");
			}
			else if(records[14].getStars() == 1){
				s_label_14.setText("\u2606");
			}
		}
		add(label_14);
		add(s_label_14);
		
		JButton button_14 = new JButton("15 - Locked");
		button_14.setBounds(225, 187, 100, 23);
		if(level_unlocked > 14){
			if(playerLevels[14] != null){
				button_14.setText("15");
				button_14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(24);
					}
				});
			}
		}
		add(button_14);
		
		JLabel label_15 = new JLabel();
		label_15.setBounds(335, 209, 100, 23);
		JLabel s_label_15 = new JLabel();
		s_label_15.setBounds(335, 224, 100, 23);
		if(records[15] == null){
			label_15.setText(" ");
			s_label_15.setText(" ");
		}
		else{
			label_15.setText("Score: " + records[15].getScore());
			if(records[15].getStars() == 3){
				s_label_15.setText("\u2606 \u2606 \u2606");
			}
			else if(records[15].getStars() == 2){
				s_label_15.setText("\u2606 \u2606");
			}
			else if(records[15].getStars() == 1){
				s_label_15.setText("\u2606");
			}
		}
		add(label_15);
		add(s_label_15);
		
		JButton button_15 = new JButton("16 - Locked");
		button_15.setBounds(335, 187, 100, 23);
		if(level_unlocked > 15){
			if(playerLevels[15] != null){
				button_15.setText("16");
				button_15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(25);
					}
				});
			}
		}
		add(button_15);
		//end third row	
		
		//start row 4 (builder levels)
		JLabel builderLabel_0 = new JLabel();
		builderLabel_0.setBounds(5, 289, 150, 23);
		JLabel s_builderLabel_0 = new JLabel();
		s_builderLabel_0.setBounds(5, 302, 150, 23);
		if(builderScores[0] == null){
			builderLabel_0.setText(" ");
			s_builderLabel_0.setText(" ");
		}
		else{
			builderLabel_0.setText("Score: " + builderScores[0].getScore());
			if(builderScores[0].getStars() == 3){
				s_builderLabel_0.setText("\u2606 \u2606 \u2606");
			}
			else if(builderScores[0].getStars() == 2){
				s_builderLabel_0.setText("\u2606 \u2606");
			}
			else if(builderScores[0].getStars() == 1){
				s_builderLabel_0.setText("\u2606");
			}
		}
		add(builderLabel_0);
		add(s_builderLabel_0);
		
		JButton builderButton0 = new JButton("Builder 1 - Locked");
		builderButton0.setBounds(5, 266, 150, 23);
		if(builderLevels[0] != null){
			builderButton0.setText("Builder 1");
		}
		builderButton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.toMenu(6);
			}
		});
		add(builderButton0);
		
		JLabel builderLabel_1 = new JLabel();
		builderLabel_1.setBounds(165, 289, 150, 23);
		JLabel s_builderLabel_1 = new JLabel();
		s_builderLabel_1.setBounds(165, 302, 150, 23);
		if(builderScores[1] == null){
			builderLabel_1.setText(" ");
			s_builderLabel_1.setText(" ");
		}
		else{
			builderLabel_1.setText("Score: " + builderScores[1].getScore());
			if(builderScores[1].getStars() == 3){
				s_builderLabel_1.setText("\u2606 \u2606 \u2606");
			}
			else if(builderScores[1].getStars() == 2){
				s_builderLabel_1.setText("\u2606 \u2606");
			}
			else if(builderScores[1].getStars() == 1){
				s_builderLabel_1.setText("\u2606");
			}
		}
		add(builderLabel_1);
		add(s_builderLabel_1);
		
		JButton builderButton1 = new JButton("Builder 2 - Locked");
		builderButton1.setBounds(165, 266, 150, 23);
		if(builderLevels[1] != null){
			builderButton1.setText("Builder 2");
			builderButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					app.toMenu(7);
				}
			});
		}
		add(builderButton1);

		JLabel builderLabel_2 = new JLabel();
		builderLabel_2.setBounds(325, 289, 150, 23);
		JLabel s_builderLabel_2 = new JLabel();
		s_builderLabel_2.setBounds(325, 302, 150, 23);
		if(builderScores[2] == null){
			builderLabel_2.setText(" ");
			s_builderLabel_2.setText(" ");
		}
		else{
			builderLabel_2.setText("Score: " + builderScores[2].getScore());
			if(builderScores[2].getStars() == 3){
				s_builderLabel_2.setText("\u2606 \u2606 \u2606");
			}
			else if(builderScores[2].getStars() == 2){
				s_builderLabel_2.setText("\u2606 \u2606");
			}
			else if(builderScores[2].getStars() == 1){
				s_builderLabel_2.setText("\u2606");
			}
		}
		add(builderLabel_2);
		add(s_builderLabel_2);
		
		JButton builderButton2 = new JButton("Builder 3 - Locked");
		builderButton2.setBounds(325, 266, 150, 23);
		if(builderLevels[2] != null){
			builderButton2.setText("Builder 3");
			builderButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					app.toMenu(8);
				}
			});
		}
		add(builderButton2);
		
		JLabel builderLabel_3 = new JLabel();
		builderLabel_3.setBounds(485, 289, 150, 23);
		JLabel s_builderLabel_3 = new JLabel();
		s_builderLabel_3.setBounds(485, 302, 150, 23);
		if(builderScores[3] == null){
			builderLabel_3.setText(" ");
			s_builderLabel_3.setText(" ");
		}
		else{
			builderLabel_3.setText("Score: " + builderScores[2].getScore());
			if(builderScores[3].getStars() == 3){
				s_builderLabel_3.setText("\u2606 \u2606 \u2606");
			}
			else if(builderScores[3].getStars() == 2){
				s_builderLabel_3.setText("\u2606 \u2606");
			}
			else if(builderScores[3].getStars() == 1){
				s_builderLabel_3.setText("\u2606");
			}
		}
		add(builderLabel_3);
		add(s_builderLabel_3);
		
		JButton builderButton3 = new JButton("Builder 4 - Locked");
		builderButton3.setBounds(485, 266, 150, 23);
		if(builderLevels[3] != null){
			builderButton3.setText("Builder 4");
			builderButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					app.toMenu(9); 
				}
			});
		}
		add(builderButton3);
		//end row 4 (builder levels)
		
		//return to main menu
		JButton btnBack = new JButton("Back to Main Menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.toMenu(1);
			}
		});
		btnBack.setBounds(21, 650, 162, 29);
		add(btnBack);
		
	}
}
