package SixesWildGame.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class selectLevel extends JPanel {

	Application app;
	
	public selectLevel(Application app) {
		super();
		this.app = app;
		
		initialize();
	}

	
	
 /**
  * Initialize the contents of the frame.
  */
 void initialize() {
	 
  JLabel lblSelectYourLevel = new JLabel("Select Your Level");
  lblSelectYourLevel.setBounds(168, 6, 113, 16);
  add(lblSelectYourLevel);
  
  JButton btnLevel = new JButton("1");
  btnLevel.setBounds(19, 49, 39, 29);
  btnLevel.addActionListener(
		    new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		    	 app.toMenu(3);
		      	  
		     }});
  add(btnLevel);
  
  JButton button = new JButton("2");
  button.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  button.setBounds(133, 49, 39, 29);
  add(button);
  
  JButton button_1 = new JButton("3");
  button_1.setBounds(242, 49, 39, 29);
  add(button_1);
  
  JButton button_2 = new JButton("4");
  button_2.setBounds(367, 49, 39, 29);
  add(button_2);
  
  JButton button_3 = new JButton("5");
  button_3.setBounds(19, 104, 39, 29);
  add(button_3);
  
  JButton button_4 = new JButton("6");
  button_4.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  button_4.setBounds(133, 104, 39, 29);
  add(button_4);
  
  JButton button_5 = new JButton("7");
  button_5.setBounds(242, 104, 39, 29);
  add(button_5);
  
  JButton button_6 = new JButton("8");
  button_6.setBounds(367, 104, 39, 29);
  add(button_6);
  
  JButton button_7 = new JButton("9");
  button_7.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  button_7.setBounds(19, 161, 39, 29);
  add(button_7);
  
  JButton button_8 = new JButton("13");
  button_8.setBounds(19, 218, 39, 29);
  add(button_8);
  
  JButton button_9 = new JButton("10");
  button_9.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  button_9.setBounds(133, 161, 39, 29);
  add(button_9);
  
  JButton button_10 = new JButton("11");
  button_10.setBounds(242, 161, 39, 29);
  add(button_10);
  
  JButton button_11 = new JButton("12");
  button_11.setBounds(367, 161, 39, 29);
  add(button_11);
  
  JButton button_12 = new JButton("14");
  button_12.setBounds(133, 218, 39, 29);
  add(button_12);
  
  JButton button_13 = new JButton("15");
  button_13.setBounds(242, 218, 39, 29);
  add(button_13);
  
  JButton button_14 = new JButton("16");
  button_14.setBounds(367, 218, 39, 29);
  add(button_14);
  
 }

}
