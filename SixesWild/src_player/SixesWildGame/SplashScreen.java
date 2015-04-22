package SixesWildGame;
import java.awt.*;


import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SplashScreen {
	  private  JPanel splashScreen;
	  
	  public  JPanel initialize(){
		  splashScreen = new JPanel();
		  JLabel splashLabel = new JLabel(new ImageIcon(this.getClass().getResource("/images/splashImg.png")));
		  splashLabel.addMouseListener(new MouseAdapter() {
			     @Override
			     public void mousePressed(MouseEvent e) {
			    	 Application.toMenu(1);
			   	 
			     }});
		  splashScreen.add(splashLabel);
		  return splashScreen;
	  }
}
