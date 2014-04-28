import java.util.*;
import javax.swing.*;

/**
   Reed I Messner
   CS110
   This is the "guts" of the game War. This uses the card
   and deck classes to play the game.
*/

public class War
{
   //declare variables
   private Deck deck, pile1, pile2; //deck and players piles
   private int player; //whose turn it is
   public boolean war; //is it a war situation or no
   
   /**
      Default constructor sets up the game for the GUI.
   */
   public War()
   {
      deck = new Deck();
      pile1 = new Deck();
      pile2 = new Deck();
      int count = 0;
      war = false;
      player = 1;
      
      // "Parse" through arrays in order to make arraylist of
      // 52 different cards
      for (int i = 0; i <= Card.ranks.length-1; i++)
      {
         for (int j = 0; j <= Card.suits.length-1; j++)
         {
            deck.add(0, new Card(Card.ranks[i], Card.suits[j], createImageIcon(Card.images[count])));
            count++;
         }
      
      }//end for
      
      //shuffle deck
      deck.shuffle();
      
      //splits deck into 2 piles, one for each player.
      for(int i = 0; i < 26; i++)
      {
         pile1.add(0,deck.remove());
         pile2.add(0,deck.remove());
      }
      
      pile1.shuffle();
      pile2.shuffle();
      
      
   }//end War constructor
   
   
   /**
      The winner method checks whose Card is higher.
      @param cd1 player 1's card
      @param cd2 player 2's card
   */
   public String winner(Card cd1, Card cd2)
   {
      if (cd1.rank > cd2.rank)
         return "1";
      else if (cd2.rank > cd1.rank)
         return "2";
      else if (cd2.rank == cd1.rank)
         war = true;
         return "war";
   }
   
   /**
      This overloaded gameWinner checks if either pile is empty.
      @return str The str showing if there is a winner
   */
   public String gameWinner()
   {
      if (pile1.size() == 0)
         return "2";
      else if (pile2.size() == 0)
         return "1";
      else
         return "0";
   }
   
   /**
      The getPlayer method returns whose turn it is
      represented by an int, either 1 or 2.
      @return Whose turn it is
   */
   public int getPlayer()
   {
      return player;
   }
   
   /**
      The setPlayer method allows the player variable
      to be manually set for a War game.
      @param The player whose turn it is
   */
   public void setPlayer(int pl)
   {
      player = pl;
   }
   
   /**
      The setWar method allows the war variable
      to be manually set.
      @param war Is it a war situation?
   */
   public void setWar(boolean w)
   {
      war = w;
   }
   
   /**
      The draw method draws a card from the deck
      and returns if it was successful, a boolean.
      @return the top card 
   */
   public Card draw()
   {
      if (war == false)
      {
         if (player == 1)
            return pile1.getTopCard();
         else
            return pile2.getTopCard();       
      }
      else
      {
         if (player == 1)
            return pile1.getSecondCard();
         else
            return pile2.getSecondCard();       
      }
      
   }
   
   /**
      This moveCard method moves cards from a regular round
      to the winner's pile then shuffles the deck.
      @param c1 The first card to move
      @param c2 The second card to move
   */
   public void moveCard(String i)
   {
      String str = i;
      //Pass in a 1 if player 1 won
      Card temp;
      if (str.equals("1"))
      {
         temp = pile2.remove();
         pile1.add(0,temp);
      }
      else if (str.equals("2"))
      {
         temp = pile1.remove();
         pile2.add(0,temp);
      }
      else if (str.equals("war1"))
      {
         temp = pile2.remove();
         pile1.add(0,temp);
         temp = pile2.remove();
         pile1.add(0,temp);
      }
      else
      {
         temp = pile1.remove();
         pile2.add(0,temp);
         temp = pile1.remove();
         pile2.add(0,temp);
      }
      
      //shuffle decks
      pile1.shuffle();
      pile2.shuffle();
   
   }
   
   
   //for adding imageicons
   protected ImageIcon createImageIcon(String path)
   {
   java.net.URL imgURL = getClass().getResource(path);
   if (imgURL != null) 
   {
       return new ImageIcon(imgURL);
   }
   else
   {
       System.err.println("Couldn't find file: " + path);
       return null;
   }
}
}