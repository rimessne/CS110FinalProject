import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/**
   Reed I Messner
   CS110
   This is the code for the war GUI. It uses the war, deck, card
   classes for this.
*/

//MAKE SPECIFIC "WAR" TURNS FOR EACH PLAYER

public class WarGUI extends JFrame //here's my use of inheritance for the assignment req.
{
   //declare variables
   private War game;
   private JLabel status,status2,status3; //status of game
   private JLabel title; //static title
   private JLabel pic; //card image
   ImageIcon front,back;
   private JPanel infoPanel,cardPanel,statusPanel;
   private JButton button;
   Card card1, card2, card3, card4;
   
   /**
      This constructor makes the GUI and displays it on screen
   */
   public WarGUI()
   {
      super("Reed's War Game");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new BorderLayout());      
      game = new War();
      
      //big Panel setup
      infoPanel = new JPanel();
      infoPanel.setLayout(new BorderLayout());
      infoPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
      
      
      statusPanel = new JPanel();
      statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.PAGE_AXIS));
      statusPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      infoPanel.setBackground(Color.pink);
      
      cardPanel = new JPanel();
      cardPanel.setBackground(Color.white);
      cardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      
      //infopanel setup
      title = new JLabel("Reed's Java WAR GAME");
      title.setFont(new Font("HELVETICA",Font.ITALIC,36));
      infoPanel.add(title, BorderLayout.NORTH);
      
      //statusPanel setup
      status = new JLabel("READY TO PLAY?");
      status2 = new JLabel("Player 1's Turn");
      status3 = new JLabel("War: Disabled");
      status.setFont(new Font("ARIAL",Font.BOLD,24));
      status2.setFont(new Font("ARIAL",Font.ITALIC,11));
      status3.setFont(new Font("HELVETICA",Font.ITALIC,11));
      button = new JButton("Continue");
      button.addActionListener(new ButtonListener());
      
      statusPanel.add(status);
      statusPanel.add(status2);
      statusPanel.add(button);
      infoPanel.add(statusPanel, BorderLayout.WEST);
      
      //card image setup
      pic = new JLabel(Card.back);
      cardPanel.add(pic);
      infoPanel.add(cardPanel, BorderLayout.CENTER);
      
      add(infoPanel);
   }
   
   
   /**
      The ButtonListener class is used to handle button
      events, which is basically when to continue the game
      in this implementation
   */
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //indented 1 extra for try
         
            String winner;
            
            //check for empty deck before every move
            if (game.gameWinner().equals("0") == false)
            {
               if (game.gameWinner().equals("1"))
               {
                  status.setText("Player 1 wins the game!");
                  status2.setText("Congratulations!");
                  status3.setText("Please exit.");
                  pic.setIcon(Card.back);
               }
               else
               {       
                  status.setText("Player 2 wins the game!");
                  status2.setText("Congratulations!");
                  status3.setText("Please exit.");
                  pic.setIcon(Card.back);
               }
            }
            
            //Switch to p1's turn
            else if ((status.getText().equals("READY TO PLAY?") ||
                status.getText().equals("P1 wins the round") ||
                status.getText().equals("P2 wins the round") ||
                status.getText().equals("P1 wins the war!") ||
                status.getText().equals("P2 wins the war!") ||
                status.getText().equals("WAR!"))
                && game.gameWinner().equals("0"))
            {
               pic.setIcon(Card.back);
               status.setText("Player 1 FLIP");
               button.setText("FLIP");
               status2.setText("Player 1's turn");
            }
            
            //Regular player 1 turn
            else if (status.getText().equals("Player 1 FLIP") 
                     && game.gameWinner().equals("0") && game.war == false)
            {
               game.setPlayer(1);
               if (game.war == false)
                  card1 = game.draw();
               else
                  card3 = game.draw();   
               status.setText("P1 CARD");
               button.setText("Continue");
               if (game.war == false)
                  pic.setIcon(card1.getImage());
               else
                  pic.setIcon(card3.getImage());
               game.setPlayer(2);
               
            }
            
            //War player 1 turn
            else if (status.getText().equals("Player 1 FLIP")
                     && game.gameWinner().equals("0")
                     && game.war == true)
            {
               game.setPlayer(1);
               card3 = game.draw();   
               status.setText("P1 CARD");
               button.setText("Continue");
               pic.setIcon(card3.getImage());
               game.setPlayer(2);
            }
            
            
            //Advance to Player 2's turn
            else if (status.getText().equals("P1 CARD")
                     && game.gameWinner().equals("0"))
            {
               pic.setIcon(Card.back);
               status.setText("Player 2 FLIP");
               button.setText("FLIP");
               status2.setText("Player 2's turn");
            }
            
            //Regular player 2 turn
            else if (status.getText().equals("Player 2 FLIP") 
                     && game.gameWinner().equals("0") && game.war == false)
            {
               game.setPlayer(2);
               if (game.war == false)
                  card2 = game.draw();
               else
                  card4 = game.draw();   
               status.setText("P2 CARD");
               button.setText("Continue");
               if (game.war == false)
                  pic.setIcon(card2.getImage());
               else
                  pic.setIcon(card4.getImage());
               game.setPlayer(1); 
            }
            
            //War player 2 turn
            else if (status.getText().equals("Player 2 FLIP")
                     && game.gameWinner().equals("0")
                     && game.war == true)
            {
               game.setPlayer(2);
               card4 = game.draw();   
               status.setText("P2 CARD");
               button.setText("Continue");
               pic.setIcon(card4.getImage());
               game.setPlayer(1);
            }
            
            //winner of a round
            else if (status.getText().equals("P2 CARD")
                     && game.gameWinner().equals("0"))
            {
               if (game.war == false)
               {
                  
                  if (game.winner(card1, card2).equals("1"))
                  {
                     pic.setIcon(card2.getImage());
                     status.setText("P1 wins the round");
                     status2.setText("P1 wins this card");
                     //move the cards to respective deck
                     game.moveCard(game.winner(card1, card2));
                  }
                  else if (game.winner(card1, card2).equals("2"))
                  {
                     //set pic and text
                     pic.setIcon(card1.getImage());
                     status.setText("P2 wins the round");
                     status2.setText("P2 wins this card");
                     game.moveCard(game.winner(card1, card2));
                  }
                  else if (game.winner(card1, card2).equals("war"))
                  {
                     status.setText("WAR!");
                     status2.setText("");
                     status3.setText("War: Enabled");
                     game.war = true;
                  }
               }
               else if (game.war == true)
                  
                  if (game.winner(card3, card4).equals("1"))
                  {
                     pic.setIcon(card4.getImage());
                     game.moveCard(game.winner(card3, card4));
                     status.setText("P1 wins the war!");
                     status2.setText("P1 wins 4 cards");
                     game.war = false;
                  }
                  else if (game.winner(card3, card4).equals("2"))
                  {
                     pic.setIcon(card3.getImage());
                     game.moveCard(game.winner(card3, card4));
                     status.setText("P2 wins the war!");
                     status2.setText("P2 wins 4 cards");
                     game.war = false;
                  }
                  else if (game.winner(card3, card4).equals("war"))
                  {
                     status.setText("WAR!");
                     status2.setText("");
                     status3.setText("War: Enabled");
                     game.war = true;
                  }
                     
                  
                  
            }
            
         
      }//end actionPreformed
   
   }//end ButtonListener
   
   //main method for testing
   public static void main(String [] args)
   {
      WarGUI frame = new WarGUI();
      frame.pack();
      frame.setVisible(true);
   }
   

}