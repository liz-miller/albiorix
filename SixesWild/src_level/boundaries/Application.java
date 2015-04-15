package boundaries;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import SelectionMenuLevel.*;
//import SelectionMenuLevel.java;

public class Application {
 
 private JFrame frame;

public static void main(String[] args) {
 EventQueue.invokeLater(new Runnable() {
  public void run() {
   try {
    SelectionMenuLevel.selectLevel window = new SelectionMenuLevel.selectLevel();
    window.frame.setVisible(true);
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
 });
}
}
 
