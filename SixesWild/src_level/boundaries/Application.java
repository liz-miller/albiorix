package boundaries;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import boundaries.*;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Application{
  private static JFrame frame;
  private static JPanel splashScreen, selectionMenu;
  
  public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   @Override
   public void run() {
    try {
     frame = new JFrame("Sixes Wild Level Builder");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     splashScreen = new JPanel();
     selectionMenu = new JPanel();
     
     frame.setSize(1000,600);
     frame.setVisible(true);
     
     
     
     JLabel splashLabel = new JLabel(new ImageIcon("boundaries/splashImg.png"));
     splashLabel.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
      SelectionMenuLevel selMenObject = new SelectionMenuLevel();
      selectionMenu = selMenObject.initialize(selectionMenu);
      frame.setContentPane(selectionMenu);
      frame.setVisible(true);
      
     
    
     }});
     splashScreen.add(splashLabel);
     frame.setContentPane(splashScreen);


     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }
}



