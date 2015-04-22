package SixesWildGame.boundary;
import java.awt.*;


import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SplashScreen extends JPanel {

	Application app;

	public SplashScreen (Application app) {
		super();
		this.app = app;
		initialize();
	}

	void  initialize(){
		JLabel splashLabel = new JLabel(new ImageIcon(this.getClass().getResource("/images/splashImg.png")));
		splashLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("going to 1");
				app.toMenu(1);
			}});
		add(splashLabel);
	}
}
