package SixesWildGame.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionMenu extends JPanel {

	Application app;

	public SelectionMenu(Application app) {
		super();
		this.app = app;
		initialize();
	}

	void  initialize() {
		
		JButton btnCampaignMode = new JButton("Campaign Mode");
		btnCampaignMode.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						app.toMenu(3);

					}});

		JButton btnChooseLevel = new JButton("Choose Level");
		btnChooseLevel.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						app.toMenu(2);

					}});

		JButton btnViewAchievements = new JButton("View Achievements");

		JLabel lblSixessWildWest = new JLabel("Sixes Wild West");
		lblSixessWildWest.setFont(new Font("Stencil Std", Font.PLAIN, 17));

		JLabel lblSelectionMenu = new JLabel("Select an Option");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(137)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblSixessWildWest)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addGap(6)
																.addComponent(btnChooseLevel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
																.addComponent(btnCampaignMode, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))))
																.addGroup(groupLayout.createSequentialGroup()
																		.addGap(145)
																		.addComponent(btnViewAchievements, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGap(169)
																				.addComponent(lblSelectionMenu)))
																				.addContainerGap(150, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(16)
						.addComponent(lblSixessWildWest)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblSelectionMenu)
						.addGap(54)
						.addComponent(btnCampaignMode)
						.addGap(12)
						.addComponent(btnChooseLevel)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnViewAchievements)
						.addGap(48))
				);
		setLayout(groupLayout);
		
	}
}
