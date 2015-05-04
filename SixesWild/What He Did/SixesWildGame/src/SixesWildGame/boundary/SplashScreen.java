package SixesWildGame.boundary;

import java.awt.*;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * SplashScreen - This is the boundary class which displays the splash screen
 * @author Liz
 *
 */
public class SplashScreen extends JPanel {

	Application app;
/**
 * Constructor for SplashScreen uses the application class
 * @param app The application class which handles going through the different screens
 */
	public SplashScreen(Application app) {
		super();
		this.app = app;
		initialize();
	}
/**
 * initialize() will create the splash screen
 */
	void initialize() {
		JLabel splashLabel = new JLabel(new ImageIcon(this.getClass()
				.getResource("/images/splashImg.png")));
		splashLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				app.toMenu(1);
			}
		});
		add(splashLabel);
	}
}
