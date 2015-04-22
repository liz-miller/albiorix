package SixesWildGame;

import java.awt.*;


import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Application{
  private static JFrame frame;
  
 private static SplashScreen splsh; 
 private static SelectionMenu selmen;
 private static selectLevel slvl;
 private static SixesWildGUI game;
  
  
  
  public static void main(String[] args) {

  EventQueue.invokeLater(new Runnable() {
   @Override
   public void run() {
    try {
     frame = new JFrame("Sixes Wild");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(700,900);
     toMenu(0);
    
     
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }
  
  public static void toMenu(int selection){
	  if(selection == 0){
		  splsh = new SplashScreen();
		  frame.setContentPane(splsh.initialize());
		  frame.setVisible(true);
	  }
	  if(selection == 1){
		  selmen = new SelectionMenu();
		  frame.setContentPane(selmen.initialize());
		  frame.setVisible(true);
	  } else if(selection == 2){
		  slvl = new selectLevel();
		  frame.setContentPane(slvl.initialize());
		  frame.setVisible(true);
	  } else if(selection == 3){
		  game = new SixesWildGUI();
		  frame.setContentPane(game.initialize());
		  frame.setVisible(true);
	  }
	  
  }
}



