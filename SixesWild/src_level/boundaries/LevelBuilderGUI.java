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

public class LevelBuilderGUI extends JFrame {

	public static JPanel contentPane;
	public static int tileSize = 60;
	public static JLabel allTiles[];
	public static int boardHW = 9;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		allTiles = new JLabel[boardHW*boardHW];
		Random randomGenerator = new Random();
		
		for(int i = 0; i < boardHW*boardHW; i++){
			   
			  
			  allTiles[i] = NewTile(randomGenerator.nextInt(6) + 1,
					  6 + (i % boardHW)*tileSize, 6 + tileSize*(i/boardHW));
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
		   
		    // onMouseEvent(e);
		   
		   
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
