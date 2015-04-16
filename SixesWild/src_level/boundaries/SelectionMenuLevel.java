package boundaries;

import java.awt.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import boundaries.*;

public class SelectionMenuLevel extends JFrame{

 
 /**
  * Initialize the contents of the frame.
  */
 public JPanel initialize(JPanel panel) {

   
  
  
  
  panel.setBackground(new Color(244, 164, 96));
  panel.setFont(new Font("Stencil Std", Font.PLAIN, 17));
  
  
  
  JLabel lblSixesWildWest = new JLabel("SIXES WILD WEST");
  lblSixesWildWest.setFont(new Font("Stencil Std", Font.PLAIN, 17));
  
  JButton btnLoadLevel = new JButton("Load Level");
  
  JButton btnNewLevel = new JButton("New Level");
  btnNewLevel.addActionListener(
    new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     //LevelBuilderGUI frame = new LevelBuilderGUI();
     //frame.setVisible(true); 
    }});
  
  JLabel lblLevelBuilder = new JLabel("Level Builder");
  GroupLayout groupLayout = new GroupLayout(panel);
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
  
  panel.setLayout(groupLayout);
  return panel;
 }
 

}