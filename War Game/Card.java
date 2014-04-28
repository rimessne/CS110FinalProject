import javax.swing.*;

/**
   Reed I Messner
   CS110
   This program stores information about a card for a game of war
*/

public class Card
{
   //declare variables and field
   final static int[] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10,
                                          11, 12, 13, 14};
   final static String[] suits = {"SPADES", "HEARTS", "CLUBS", "DIAMONDS"};
   final static String[] images = 
         {"2s.jpg","2h.jpg","2c.jpg","2d.jpg",
         "3s.jpg","3h.jpg","3c.jpg","3d.jpg",
         "4s.jpg","4h.jpg","4c.jpg","4d.jpg",
         "5s.jpg","5h.jpg","5c.jpg","5d.jpg",
         "6s.jpg","6h.jpg","6c.jpg","6d.jpg",
         "7s.jpg","7h.jpg","7c.jpg","7d.jpg",
         "8s.jpg","8h.jpg","8c.jpg","8d.jpg",
         "9s.jpg","9h.jpg","9c.jpg","9d.jpg",
         "10s.jpg","10h.jpg","10c.jpg","10d.jpg",
         "jacks.jpg","jackh.jpg","jackc.jpg","jackd.jpg",
         "queens.jpg","queenh.jpg","queenc.jpg","queend.jpg",
         "kings.jpg","kingh.jpg","kingc.jpg","kingd.jpg",
         "aces.jpg","aceh.jpg","acec.jpg","aced.jpg"};
   final static ImageIcon back = new ImageIcon("back.jpg");
         
   public int rank;
   private String suit;
   private ImageIcon im;

   
   
   /**
      This constructor takes a suit, rank and imageicon as
      parameters then sets the fields to those values.
      @param rank The rank of the card
      @param suit The suit of the card
      @param im The ImageIcon
   */  
   public Card(int rank, String suit, ImageIcon im)
   {
      this.rank = rank;
      this.suit = suit;
      this.im = im;
   }
   
   /**
      This is a copy constructor
      @param c The card to copy
   */
   public Card(Card c)
   {
      rank = c.rank;
      suit = c.suit;
      im = c.im;
   }
   
   /**
      The getRank method returns the rank.
      @return rank The rank to return
   */
   public int getRank()
   {
      return rank;
   }
   
   /**
      The getSuit method returns the suit.
      @return suit The suit to return
   */
   public String getSuit()
   {
      return suit;
   }
   
   /**
      The getImage method returns the image
      of the card for the GUI
      @return im The image.
   */
   public ImageIcon getImage()
   {
      return im;
   }
   
   /**
      Main Method!
   */
   public static void main(String [] args)
   {
      //Card c = new Card(
   }


}