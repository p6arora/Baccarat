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



public class Player extends CardHolder{
    //Overview:
    
    
    private String name;
    private int betType;
    private int betAmount;
    
  
    public Player(String name, int betType, int betAmount){
        
	this.name=name;
	this.betType=betType;
	this.betAmount=betAmount;
        //players start with $1000
	super.funds=1000;
    }
    
    public int getFunds(){     
        return super.funds;
    }
    public void changeFunds(int fundsChange){
        super.funds+=fundsChange;
    }
    
    /**
     *@return the current type of bet 
     */
    public int getBetType(){
        return betType;
    }
    /**
     * 
     *Change the current type of bet of the player
     * @param newType The new type of bet the player is now engaged in with a value 1 for betting on the player, a value of 2 for betting on the banker, and a value of 3 for betting on a tie.
     *  
     */
    public void changeBetType(int newType){
        betType=newType;   
    }
    /**
     * 
     * @return The current amount the player is betting.
     */
    public int getBetAmount(){
        return betAmount;
    }
    /**
     * Changes the current amount the of funds the player is betting.
     * @param amt
     * @return True if the the new bet amount is above 0 and the player has sufficient funds to bet
     */
    public boolean changeBetAmount(int amt){
        
        if(amt<0||super.funds<amt)
            return false;
        betAmount=amt;
        return true;
    }
    
    
    
  
     public boolean draw(){
	//implements the default player rules if neither player has drawn a card
	
        return super.draw();
    }
    
    
    
    
    
    
}
