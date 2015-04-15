package boundaries;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SelectionMenuLevel extends JFrame{

 private JFrame frame;

<<<<<<< HEAD
 /**
  * Launch the application.
  */
 /*public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     SelectionMenuLevel window = new SelectionMenuLevel();
     window.frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }*/
=======
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SelectionMenuLevel window = new SelectionMenuLevel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
>>>>>>> liz

 /**
  * Create the application.
  */
 public SelectionMenuLevel() {
  initialize();
 }

<<<<<<< HEAD
 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
  
  // Set the window's bounds, centering the window
  int width = 1000;
  int height = 600;
  Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
  int x = (screen.width-width)/2;
  int y = (screen.height-height)/2;
  setBounds(x,y,width,height);
   
  frame = new JFrame();
  frame.getContentPane().setBackground(new Color(244, 164, 96));
  frame.getContentPane().setFont(new Font("Stencil Std", Font.PLAIN, 17));
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
=======
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Set the window's bounds, centering the window
//		int width = 1000;
//		int height = 600;
//		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//		int x = (screen.width-width)/2;
//		int y = (screen.height-height)/2;
//		setBounds(x,y,width,height);
		
		
		 
		frame = new JFrame();
		frame.setBounds(500, 300,1000,600);
		frame.getContentPane().setBackground(new Color(244, 164, 96));
		frame.getContentPane().setFont(new Font("Stencil Std", Font.PLAIN, 17));
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
>>>>>>> liz

}