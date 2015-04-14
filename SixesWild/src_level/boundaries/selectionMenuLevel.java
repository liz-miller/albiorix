package boundaries;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class selectionMenuLevel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectionMenuLevel window = new selectionMenuLevel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public selectionMenuLevel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Stencil Std", Font.PLAIN, 17));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSixesWildWest = new JLabel("SIXES WILD WEST");
		lblSixesWildWest.setFont(new Font("Stencil Std", Font.PLAIN, 17));
		
		JButton btnLoadLevel = new JButton("Load Level");
		
		JButton btnNewLevel = new JButton("New Level");
		
		JLabel lblLevelBuilder = new JLabel("Level Builder");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(lblSixesWildWest))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(184)
							.addComponent(lblLevelBuilder))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewLevel)
								.addComponent(btnLoadLevel))))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblSixesWildWest)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblLevelBuilder)
					.addGap(46)
					.addComponent(btnLoadLevel)
					.addGap(18)
					.addComponent(btnNewLevel)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
