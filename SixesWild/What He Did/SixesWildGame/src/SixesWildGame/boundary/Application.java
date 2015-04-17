package SixesWildGame.boundary;

import java.awt.*;


import javax.swing.*;

import SixesWildGame.model.Model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Application extends JFrame {

	private static SplashScreen splsh; 
	private static SelectionMenu selmen;
	private static selectLevel slvl;
	private static SixesWildGUI game;

	Model model;

	public Application(Model m) {
		super();
		setSize(800, 800);
		this.model = m;
		toMenu(3);
	}
	
	public void toMenu(int selection){
		if(selection == 0){
			splsh = new SplashScreen(this);
			setContentPane(splsh);
		}
		if(selection == 1){
			selmen = new SelectionMenu(this);
			setContentPane(selmen);
		} else if(selection == 2){
			slvl = new selectLevel(this);
			setContentPane(slvl);
		} else if(selection == 3){
			game = new SixesWildGUI(this, model.getBoard(1));
			setContentPane(game);
		}

		// google how to refresh when changing content pane for JFrame
		repaint();
	}
}



