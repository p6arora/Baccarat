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
public abstract class CardHolder {
    //Overview: 
    //
    //
    protected CardPile cards = new CardPile();
    protected int cardsValue;
    protected int funds;

    
    
    
    

    
    /**
    Returns the current score of the card holder. The total score is equal the 10th modulo
    of the sum of the score of all cards. Jacks, Queens, Kings and cards ranked 10 have a score of 0.
    Ace is a score of 1.All other cards have a score equal to their rank. Score is used to determine
    the winner of each round.

    @return cardValue 
    */
    public int getCardsValue(){
        //Requires: cards is not null
        //Modifies: cardValue
        //Effects: Updates the cardholder's score based on the current card in their hand.
	int sum=0;
	//loops through all cards in the cardholders hand to get the total score of cards
        for(Card c: cards.getCards()){
		if(c.getRank()<10){				
			sum+=c.getRank();
		}
        }
        cardsValue=sum%10;
	return cardsValue;
	
}

    
    public void addCard(Card c){
        
        cards.add(c);
    }
    
    /**
    Returns true if the cardholder should draw based on their score. Otherwise
    returns false.
    @return boolean
    */
   public boolean draw(){
	//implements the default player rules if neither player has drawn a card
	
        return (this.getCardsValue()<6);
	}
   /**
    * 
    * @return The pile of cards of the CardHolder.
    */
    public CardPile getCardPile(){
        return cards;
    }
    
}
