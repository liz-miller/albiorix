
import java.awt.BorderLayout;
import javax.swing.border.*;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Random;
import java.util.Stack;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSlider;




public class LevelBuilderGUI extends JFrame {

	private static JPanel contentPane;
	 private static int tileSize = 60;
	 private static JLabel allTiles[];
	 private static int boardHW = 9;
	 private static int topCorner = 60;
	 private JTextField txtLevelNumber;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JTextField textField_5;
	 private JTextField txtX;
	 private JTextField textField_6;
	 private JTextField textField_7;
	 private static JButton btnSetAsRelease;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilderGUI frame = new LevelBuilderGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelBuilderGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
		 contentPane.setLayout(null);
		 
		 JButton btnSave = new JButton("Save");
		 btnSave.setBounds(6, 6, 60, 29);
		 contentPane.add(btnSave);
		 
		 JButton btnLoad = new JButton("Load");
		 btnLoad.setBounds(68, 6, 60, 29);
		 contentPane.add(btnLoad);
		 
		 JComboBox comboBox = new JComboBox();
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		 JComboBox cb = (JComboBox) arg0.getSource();
		 		 int gameType = (int) cb.getSelectedIndex();
		 		 if(gameType != 3){
		 			btnSetAsRelease.setEnabled(false);
		 		 } else{
		 			btnSetAsRelease.setEnabled(true);
		 		 }
		 		 
		 	}
		 });
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Elimination", "Release"}));
		 comboBox.setToolTipText("Select Level Type");
		 comboBox.setBounds(251, 7, 174, 27);
		 contentPane.add(comboBox);
		 
		 txtLevelNumber = new JTextField();
		 txtLevelNumber.setText("Level Number");
		 txtLevelNumber.setBounds(128, 5, 121, 28);
		 contentPane.add(txtLevelNumber);
		 txtLevelNumber.setColumns(10);
		 
		 JLabel lblSetNumberFrequency = new JLabel("Set Number Frequency:");
		 lblSetNumberFrequency.setBounds(6, 34, 150, 29);
		 contentPane.add(lblSetNumberFrequency);
		 
		 textField = new JTextField();
		 textField.setText("%");
		 textField.setBounds(6, 83, 44, 28);
		 contentPane.add(textField);
		 textField.setColumns(10);
		 
		 JLabel lbls = new JLabel("1's");
		 lbls.setBounds(5, 66, 30, 16);
		 contentPane.add(lbls);
		 
		 JLabel label = new JLabel("2's");
		 label.setBounds(6, 115, 30, 16);
		 contentPane.add(label);
		 
		 textField_1 = new JTextField();
		 textField_1.setText("%");
		 textField_1.setColumns(10);
		 textField_1.setBounds(7, 132, 43, 28);
		 contentPane.add(textField_1);
		 
		 JLabel label_1 = new JLabel("3's");
		 label_1.setBounds(6, 165, 30, 16);
		 contentPane.add(label_1);
		 
		 textField_2 = new JTextField();
		 textField_2.setText("%");
		 textField_2.setColumns(10);
		 textField_2.setBounds(7, 182, 43, 28);
		 contentPane.add(textField_2);
		 
		 JLabel label_2 = new JLabel("4's");
		 label_2.setBounds(6, 222, 30, 16);
		 contentPane.add(label_2);
		 
		 textField_3 = new JTextField();
		 textField_3.setText("%");
		 textField_3.setColumns(10);
		 textField_3.setBounds(7, 239, 43, 28);
		 contentPane.add(textField_3);
		 
		 textField_4 = new JTextField();
		 textField_4.setText("%");
		 textField_4.setColumns(10);
		 textField_4.setBounds(7, 297, 43, 28);
		 contentPane.add(textField_4);
		 
		 JLabel label_3 = new JLabel("5's");
		 label_3.setBounds(6, 280, 30, 16);
		 contentPane.add(label_3);
		 
		 textField_5 = new JTextField();
		 textField_5.setText("%");
		 textField_5.setColumns(10);
		 textField_5.setBounds(7, 354, 43, 28);
		 contentPane.add(textField_5);
		 
		 JLabel label_4 = new JLabel("6's");
		 label_4.setBounds(6, 337, 30, 16);
		 contentPane.add(label_4);
		 
		 JLabel lblBonusFrequency = new JLabel("Bonus");
		 lblBonusFrequency.setBounds(5, 394, 44, 16);
		 contentPane.add(lblBonusFrequency);
		 
		 JLabel lblx = new JLabel("1X");
		 lblx.setBounds(5, 413, 30, 16);
		 contentPane.add(lblx);
		 
		 txtX = new JTextField();
		 txtX.setText("%");
		 txtX.setColumns(10);
		 txtX.setBounds(6, 430, 44, 28);
		 contentPane.add(txtX);
		 
		 textField_6 = new JTextField();
		 textField_6.setText("%");
		 textField_6.setColumns(10);
		 textField_6.setBounds(6, 483, 44, 28);
		 contentPane.add(textField_6);
		 
		 JLabel label_5 = new JLabel("2X");
		 label_5.setBounds(5, 466, 30, 16);
		 contentPane.add(label_5);
		 
		 textField_7 = new JTextField();
		 textField_7.setText("%");
		 textField_7.setColumns(10);
		 textField_7.setBounds(6, 540, 44, 28);
		 contentPane.add(textField_7);
		 
		 JLabel label_6 = new JLabel("3X");
		 label_6.setBounds(5, 523, 30, 16);
		 contentPane.add(label_6);
		 
		 JButton btnReset = new JButton("Reset");
		 btnReset.setBounds(52, 607, 117, 29);
		 contentPane.add(btnReset);
		 
		 JButton btnSetTo = new JButton("Set To 6");
		 btnSetTo.setBounds(174, 607, 117, 29);
		 contentPane.add(btnSetTo);
		 
		 JButton btnSetAsInert = new JButton("Set As Inert");
		 btnSetAsInert.setBounds(297, 607, 117, 29);
		 contentPane.add(btnSetAsInert);
		 
		 btnSetAsRelease = new JButton("Set As Release Area");
		 btnSetAsRelease.setBounds(415, 607, 150, 29);
		 btnSetAsRelease.setEnabled(false);
		 contentPane.add(btnSetAsRelease);
		 
		 
		  allTiles = new JLabel[boardHW*boardHW];
		  
		  
		  Random randomGenerator = new Random();
		  
		  for(int i = 0; i < boardHW*boardHW; i++){
		   
		  
		  allTiles[i] = NewTile(randomGenerator.nextInt(6) + 1,
		    topCorner + (i % boardHW)*tileSize, topCorner + tileSize*(i/boardHW));//, randomGenerator.nextInt(3) + 1);
		  }
	}

	 public static JLabel NewTile(int num, int xcoord, int ycoord){//, int mult){
		  JLabel label = new JLabel(Integer.toString(num));
		  label.addMouseListener(new MouseAdapter() {
		   @Override
		   public void mousePressed(MouseEvent e) {
		    
		    //onMouseEvent(e);
		   
		  
		   }
		   public void mouseReleased(MouseEvent e) {
		    
		  
		   }
		   @Override
		   public void mouseEntered(MouseEvent e) {
		   
		     //onMouseEvent(e);
		   
		   
		   }
		  });
		  
		  if(num == 1){
		   label.setBackground(Color.RED);
		  } else if(num == 2){
		   label.setBackground(Color.ORANGE);
		  } else if(num == 3){
		   label.setBackground(Color.BLUE);
		  } else if( num == 4){
		   label.setBackground(Color.MAGENTA);
		  } else if( num == 5){
		   label.setBackground(Color.GREEN);
		  } else{
		   label.setBackground(Color.YELLOW);
		  }
		  
		  label.setForeground(Color.BLACK);
		  //Color plier;
		  /*if(mult == 1){
		    plier = Color.BLACK;
		  }else if(mult == 2){
		    plier = Color.GRAY;
		  }else{
		    plier = Color.WHITE;
		  }*/
		  label.setBorder(new LineBorder(Color.BLACK));//plier, 5));
		  label.setOpaque(true);
		  label.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		  label.setHorizontalAlignment(SwingConstants.CENTER);
		  label.setBounds(xcoord, ycoord, tileSize, tileSize);
		  
		  contentPane.add(label);
		  return label;
		 }
}
