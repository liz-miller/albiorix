package SixesWildGame;

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









public class SixesWildGUI{
 private  JLabel scoreBoard;
 private  int windowH = 700;
 private  int windowW = 700;
 private  int boardHW = 9;
 private  int tileSize = 60;
 private  int count = 0;
 //public static int pointMult = 1;
 private  boolean dragging = false;
 private  int numClicked = 0;
 private  int movesLeft = 20;
 private  int point = 0;
 private  JLabel allTiles[];
 private  Stack<JLabel> swipedTiles;
 private  JPanel contentPane;
 private  int topCorner = 40;
 
 private  JButton btnEliminateTile;
 private  int eliminateTilesLeft = 3;
 private  boolean eliminateTileState = false;
 
 private  JButton btnSwapTile;
 private  int swapTilesLeft = 3;
 private  boolean swapTileState = false;

 /**
  * Launch the application.
  */
/* public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     SixesWildGUI frame = new SixesWildGUI();
     frame.setVisible(true);
     
    } catch (Exception e) {
     e.printStackTrace();
    }
     
    

    
   }
  });
    
 }*/

 /**
  * Create the frame.
  */
 public  JPanel initialize() {
  //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //setBounds(100, 100, windowW, windowH);
  contentPane = new JPanel();
  
  
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  //setContentPane(contentPane);
  contentPane.setLayout(null);
  allTiles = new JLabel[boardHW*boardHW];
  swipedTiles = new Stack<JLabel>();
  Random randomGenerator = new Random();
  
  for(int i = 0; i < boardHW*boardHW; i++){
   
  
  allTiles[i] = NewTile(randomGenerator.nextInt(6) + 1,
    topCorner + (i % boardHW)*tileSize, topCorner + tileSize*(i/boardHW));//, randomGenerator.nextInt(3) + 1);
  }
  
  scoreBoard = new JLabel("Score: "+ point+", Moves Left: "+ movesLeft);
  scoreBoard.setBounds(6, 6, 400, 30);
  contentPane.add(scoreBoard);
  
  JButton btnResetBoard = new JButton("Reset Board");
  btnResetBoard.addActionListener(
    new ActionListener() {
     public void actionPerformed(ActionEvent e) {
    movesLeft--;
    scoreBoard.setText("Score: "+ point+", Moves Left: "+ movesLeft);
    Random randomGenerator = new Random();
    for(int i = 0; i < boardHW*boardHW; i++){
    allTiles[i].setVisible(false);
    allTiles[i] = NewTile(randomGenerator.nextInt(6) + 1,
      topCorner + (i % boardHW)*tileSize, topCorner + tileSize*(i/boardHW));//, randomGenerator.nextInt(3) + 1);
    }
    }
  });
  btnResetBoard.setBounds(186, 6, 110, 29);
  contentPane.add(btnResetBoard);
  
  JButton btnBack = new JButton("Back to Main Menu");
  btnBack.addActionListener(
    new ActionListener() {
     public void actionPerformed(ActionEvent e) {
    	
    	 Application.toMenu(1);
    	 
    }
  });
  btnBack.setBounds(6, 600, 200, 29);
  contentPane.add(btnBack);
  
  btnEliminateTile = new JButton("Eliminate Tile ("+eliminateTilesLeft+" left)");
  btnEliminateTile.addActionListener(
    new ActionListener() {
     public void actionPerformed(ActionEvent e) {
    
      if(eliminateTilesLeft > 0){
    eliminateTileState = true;
    swapTileState = false;
      }
    }
  });
  btnEliminateTile.setBounds(286, 6, 200, 29);
  contentPane.add(btnEliminateTile);
  
  btnSwapTile = new JButton("Swap Tiles ("+swapTilesLeft+" left)");
  btnSwapTile.addActionListener(
    new ActionListener() {
     public void actionPerformed(ActionEvent e) {
    if(swapTilesLeft > 0){
    eliminateTileState = false;
    swapTileState = true;
    }
    }
  });
  btnSwapTile.setBounds(476, 6, 200, 29);
  contentPane.add(btnSwapTile);

  JLabel starLabel = new JLabel("\u2606 \u2606 \u2606");
  starLabel.setForeground(Color.BLACK);
  starLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
  
  starLabel.setBounds(590, 40, 200, 29);
  
  contentPane.add(starLabel);
  return contentPane;
 }
 
 
 
 public  int findIndex(int xcoord, int ycoord){
  for(int i = 0; i < boardHW; i++){
  if((xcoord-topCorner)/tileSize == i){
   for(int j = 0; j < boardHW; j++){
   if((ycoord-topCorner)/tileSize == j){
    return boardHW*j+i;}
   
   }
   }
  }
  return -1;
 }
  
 
 public  JLabel SpawnTile(int xcoord, int ycoord) {
  Random randomGenerator = new Random();
  JLabel newLabel = NewTile(randomGenerator.nextInt(6) + 1, xcoord, ycoord);//, randomGenerator.nextInt(3) + 1);
  
  return newLabel;
  
  
 }
 public  void onMouseEvent(MouseEvent e){
  JLabel labelEntered = (JLabel) e.getSource();
  if(!labelEntered.getText().contains("|")){
  count = count + Integer.parseInt(labelEntered.getText());
  numClicked++;
  //labelEntered.getBorder().
  //pointMult = pointMult;
  labelEntered.setText("|"+labelEntered.getText()+"|");
  swipedTiles.push(labelEntered);
  if(
    //(
    (count > 6) 
    //|| (count == 6 && numClicked == 1))
    && !eliminateTileState && !swapTileState){
   count = 0;
   
   //pointMult = 1;
   numClicked = 0;
   movesLeft--;
   while(swipedTiles.empty() == false){
    JLabel popped = swipedTiles.pop();
    if(popped.getText().length() > 1){
    popped.setText(popped.getText().substring(1, 2));
    }
   }
  }else if((((numClicked == 2 && swapTileState) || count == 6 )&& numClicked > 1)  || eliminateTileState){
   if(eliminateTileState){
    eliminateTileState = false;
    eliminateTilesLeft--;
    btnEliminateTile.setText("Eliminate Tile ("+eliminateTilesLeft+" left)");
   } else if(!swapTileState){
   movesLeft--;
   point = point + 10*numClicked;
   }
   
   count = 0;
   //pointMult = 1;
   numClicked = 0;
   while(swipedTiles.empty() == false){
    JLabel popped = (JLabel) swipedTiles.pop();
    
    int poppedIndex = findIndex(popped.location().x,popped.location().y );
    if(swapTileState){
     JLabel popped2 =  (JLabel) swipedTiles.pop();
     int popped2Index = findIndex(popped2.location().x,popped2.location().y );
     allTiles[poppedIndex] = NewTile(Integer.parseInt(popped2.getText().substring(1, 2)), popped.location().x,popped.location().y);
     allTiles[popped2Index] = NewTile(Integer.parseInt(popped.getText().substring(1, 2)), popped2.location().x,popped2.location().y);
     popped.setVisible(false);
     popped2.setVisible(false);
     swapTilesLeft--;
     btnSwapTile.setText("Swap Tiles ("+swapTilesLeft+" left)");
     swapTileState = false;
       
    }else{
     
    if(poppedIndex >= 0 && poppedIndex < boardHW){
     popped.setVisible(false);
     allTiles[poppedIndex] = SpawnTile(popped.location().x,popped.location().y);
    } else{
     JLabel downSlide = (JLabel) allTiles[poppedIndex - boardHW];
     swipedTiles.push(NewTile(0,downSlide.location().x,downSlide.location().y));//, 0));
     downSlide.setLocation(popped.location().x, popped.location().y);
     allTiles[poppedIndex] = downSlide;
     popped.setVisible(false);
    }
    }
    
    
   }
   
  }
  }
  
  scoreBoard.setText("Score: "+ point+", Moves Left: "+ movesLeft);//+", Eliminate Tiles Left: "+ eliminateTilesLeft);
  
  
 }
 
 public  JLabel NewTile(int num, int xcoord, int ycoord){//, int mult){
  JLabel label = new JLabel(Integer.toString(num));
  label.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent e) {
    dragging = true;
    onMouseEvent(e);
   
  
   }
   public void mouseReleased(MouseEvent e) {
    dragging = false;
    while(swipedTiles.empty() == false){
     JLabel popped = swipedTiles.pop();
     if(popped.getText().length() > 1){
     popped.setText(popped.getText().substring(1, 2));
     }
    }
    count = 0;
    //pointMult = 1;
    numClicked = 0;
   }
   @Override
   public void mouseEntered(MouseEvent e) {
    if(dragging){
     onMouseEvent(e);
   }
   
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
