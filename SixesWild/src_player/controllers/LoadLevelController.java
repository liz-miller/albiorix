package controllers;

import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class LoadLevelController implements ActionListener {
	Application application;     /** Application we have control over. */
	Model model;                 /** Model containing state. */
	
	public LoadLevelController(Application app, Model m) {
		this.application = app;
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField tf = application.getNameField();
		

	}
}
