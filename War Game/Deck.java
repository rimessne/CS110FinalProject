import java.util.*;
import javax.swing.*;


/**
   Reed I Messner
   CS110
   This Deck class represents a deck of cards. 
   It it used for both the original deck as well as
   the individual card piles for each player.
   It uses the Card class also created for this game of war.
*/

public class Deck
{
   //declare variables
   private ArrayList<Card> deck;
   
   /**
      This default constructor makes an empty unshuffled deck.
   */
   public Deck()
   {
      deck = new ArrayList<Card>(0);
   }
   
   
   /**
      The add method adds a card to the deck in the specified pos.
   */
   public void add(int i, Card c)
   {
      deck.add(i,c);
   }
   
   /**
      The remove method gets rid of the top card of
      the deck and returns the card.
   */
   public Card remove()
   {
      Card temp = deck.remove(0);
      return temp;
   }
   
   
   /**
      The size method returns an integer
      representing the deck's size
      @return the deck's size.
   */
   public int size()
   {
      return deck.size();
   }
   
   /**
      The getTopCard returns the top card from a deck
      @return Card The top card of the deck.
   */
   public Card getTopCard()
   {
      return deck.get(0);
   }
   
   /**
      The getSecondCard returns the second card from a deck
      @return Card The second card of the deck.
   */
   public Card getSecondCard()
   {
      return deck.get(1);
   }
   
   /**
      The shuffle method takes a deck than shuffles the
      top card to a random spot in the deck. The repetition
      of this action simulates a shuffle.
   */
   public void shuffle()
   {
      Random rand = new Random();
      
      for (int i=0; i<1000; i++)
      {
         if (size() > 0)
         {
            Card topCard = deck.remove(0);
            int newPos = rand.nextInt(deck.size());
            deck.add(newPos, topCard);
         }
      }//end for loop
   
   }
   
   /**
      The clear method empties the deck.
   */
   public void clear()
   {
      deck.clear();
   }

}