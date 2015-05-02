import java.awt.EventQueue;

import javax.swing.JFrame;

import SixesWildGame.boundary.Application;


public class LaunchGUI {
	//All this should do is launch a game object
	public static void main(String[] args) {
		
		
		Application app = new Application(); 
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
			  
	}
}
