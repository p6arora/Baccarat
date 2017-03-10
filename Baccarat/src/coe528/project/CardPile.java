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
import java.util.ArrayList;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;

    public CardPile() {
        
        cards = new ArrayList<Card>();
        //Initialize the instance variable.
        
        

    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
        
        //FIX THIS
        
        cards.add(card);
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
     
        
        int i = (int) (Math.random()*(cards.size()));
       
        Card cardRemoved= cards.get(i);
        cards.remove(i);
        
        return cardRemoved;
         
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        
        
        return cards.toString();
        
        
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
     /**
     * Turns the calling CardPile to a full deck of 52 cards.
     */
    public void reset(){
        cards.clear();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                cards.add(new Card(i, j));
            }
        }     
    }

   


}