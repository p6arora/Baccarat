/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Donte Graham, Yu Wang and Paarth Arora
 */
public class Card {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  private int rank1;
  
  private int suit1;

  /**
   * Construct a card of the given rank, suit. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   */
  public Card(int rank, int suit) {
      rank1=rank;      
      suit1=suit;
      
    
  }

 

  /**
   * @return the rank
   */
  public int getRank() {
    return rank1; 
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return suit1;
  }

 
 

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
      if(rank1<10||rank1>0)
        return ""+rank1;
      else if(rank1==11)
          return"Jack";
      else if(rank1==12)
          return"Queen";
      else if(rank1==13)
          return"King";
      else if(rank1==14)
          return"Ace";
      else 
          return "invalid";
      
  }
  
  public String getSuitString() {
       if(suit1==CLUB)
          return"Clubs";
      else if(suit1==DIAMOND)
          return"Diamonds";
      else if(suit1==HEART)
          return"Hearts";
      else if(suit1==SPADE)
          return"Spades";
       else
          return"invalid suit";
    
  }

  /**
   * Return the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
      if(rank1<11)
          return (rank1+" of "+this.getSuitString());
      else if(rank1==11)
          return("Jack of " + this.getSuitString());
      else if(rank1==12)
          return("Queen of " + this.getSuitString());
      else if(rank1==13)
          return("King of " + this.getSuitString());
      else if(rank1==14)
          return("Ace of " + this.getSuitString());
      
      else
          return "error";

    
  }

 
  
  public boolean repOk(){
  
      return true;
  }
}