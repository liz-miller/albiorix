package boundaries;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LevelSelectionMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LevelSelectionMenu window = new LevelSelectionMenu();
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
	public LevelSelectionMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSixesWildWest = new JLabel("Sixes Wild West");
		lblSixesWildWest.setBounds(175, 6, 105, 16);
		frame.getContentPane().add(lblSixesWildWest);
		
		JLabel lblLevelBuilder = new JLabel("Level Builder");
		lblLevelBuilder.setBounds(180, 69, 84, 16);
		frame.getContentPane().add(lblLevelBuilder);
		
		JButton btnLoadLevel = new JButton("Load Level");
		btnLoadLevel.setBounds(163, 139, 117, 29);
		frame.getContentPane().add(btnLoadLevel);
		
		JButton btnNewLevel = new JButton("New Level");
		btnNewLevel.setBounds(163, 194, 117, 29);
		frame.getContentPane().add(btnNewLevel);
	}
}
