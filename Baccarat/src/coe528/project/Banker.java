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
public class Banker extends CardHolder  {
    //Overview: Represents the banker of 
    private int cardsValue;
    
    
    public Banker(){
        super.funds=99999;
    
    }

   
    /**
     * 
     * @param betType The current type of bet the player is engaged in at the time of winning.
     * @param betAmount The current amount the player is betting at the time of winning.
     * @return The amount of funds the player has won.
     */
    public int transferFunds(int betType,int betAmount){
        int winning;
        //Player won a bet on the player or banker
        if(betType==1||betType==2){
            winning=betAmount*2;
            super.funds-=winning;
            return winning;
        }
        //Player won a tie bet
        else{
            winning=betAmount*9;
            super.funds-=winning;
            return winning;
        }
            
        
    }
   
    /**
     * 
     * @param playerDrawValue The value of the last card drawn by the player.
     * @param playerDrew True if the player drew a third card, otherwise false.
     * @return Returns true if the banker should draw a card, otherwise returns false.
     */
    public boolean draw(int playerDrawValue,boolean playerDrew){
	//If either the player or banker has a score of 8 or 9, neither player draws. 
	//If the player does not draw, then the banker draw rules are the same as the player draw rules.
	if(!playerDrew)
            return super.draw();
	//Specific Banker rules are implemented based on the value of the third card drawn by the player.
	if(playerDrawValue==2||playerDrawValue==3){
		if(this.getCardsValue()<5)
			return true;	
		else
			return false;
	}

        else if(playerDrawValue==4||playerDrawValue==5){
		if(this.getCardsValue()<6)
			return true;	
		else
			return false;
	}
        else if(playerDrawValue==6||playerDrawValue==7){
		if(this.getCardsValue()<7)
			return true;	
		else
			return false;
	}
        else if(playerDrawValue==8){
		if(this.getCardsValue()<5)
			return true;	
		else
			return false;
	}
        else if(playerDrawValue==1||playerDrawValue==0||playerDrawValue==9){
		if(this.getCardsValue()<4)
			return true;	
		else
			return false;
	}
        return false;
		
	

}
    
}
