import java.awt.EventQueue;

import javax.swing.JFrame;

import SixesWildGame.boundary.Application;
import SixesWildGame.model.Model;


public class LaunchGUI {
	public static void main(String[] args) {
		Model m = new Model();
		
		Application app = new Application(m); 
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
			  
	}
}