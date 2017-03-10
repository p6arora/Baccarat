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
import java.util.Scanner;
/**
 * Main game interface
 * 
 */
public class Game {
    
    
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        Banker bank = new Banker();
        CardPile deck = new CardPile();
        //initializing deck
        deck.reset();
        Card c ; 
        //Card pointer
        String name;
        int bet1; // bet type
        int bet2; //betamount

        System.out.println("Welcome To Baccarat online");
        System.out.println("Enter your name to continue");
        name=scanner.nextLine();
        Player player = new Player(name,1,1 );
        System.out.println("Welcome "+ name+".");
        //Game now Active
        while(true){// Start of while loop
            System.out.println("What would you like to bet on?");
            System.out.println("1)Player wins\n2)Banker wins\n3)Tie");
            bet1=scanner.nextInt();
            player.changeBetType(bet1);
            System.out.println("How much would you like to bet?");
            bet2=scanner.nextInt();
            player.changeBetAmount(bet2);
            //distributing cards
            System.err.println("Distributing Cards...");
            c = deck.removeRandom();


            player.addCard(c);
            c = deck.removeRandom();
            player.addCard(c);
            System.err.println("Player drew: "+ player.getCardPile()+ ". Score: "+player.getCardsValue());
            c = deck.removeRandom();
            bank.addCard(c);
            c = deck.removeRandom();
            bank.addCard(c);
            System.err.println("Banker drew: "+ bank.getCardPile()+ ". Score: "+bank.getCardsValue());
            //Check for third card drawings
            if(player.getCardsValue()==8||player.getCardsValue()==9||bank.getCardsValue()==8||bank.getCardsValue()==9){
                System.err.println("A natural was drawn. Neither player draws a card.");
                //Start of determining the winner
                if(player.getCardsValue()>bank.getCardsValue()){
                    System.err.println("Player Wins!");
                    if(player.getBetType()==1){
                        //Use the banker transfer funds method to find the appropriate winnings for the player 
                        player.changeFunds(bank.transferFunds(player.getBetType(), player.getBetAmount()));
                        System.err.println("You won the bet. You now have "+ player.getFunds());
                    }
                    else{
                        //Reduce players funds if they lost
                        player.changeFunds(-1*player.getBetAmount());
                        System.err.println("You lost the bet. You now have "+player.getFunds());
                    }
                }
                else if(player.getCardsValue()<bank.getCardsValue()){
                    System.err.println("Banker Wins!");
                    if(player.getBetType()==2){
                        //Use the banker transfer funds method to find the appropriate winnings for the player 
                        player.changeFunds(bank.transferFunds(player.getBetType(), player.getBetAmount()));
                        System.err.println("You won the bet. You now have "+ player.getFunds());
                    }
                    else{
                        //Reduce players funds if they lost
                        player.changeFunds(-1*player.getBetAmount());
                        System.err.println("You lost the bet. You now have "+player.getFunds());
                    }
                }
                else {
                    System.err.println("It's A Tie!");
                    if(player.getBetType()==3){
                        //Use the banker transfer funds method to find the appropriate winnings for the player 
                        player.changeFunds(bank.transferFunds(player.getBetType(), player.getBetAmount()));
                        System.err.println("You won the bet. You now have "+ player.getFunds());
                    }
                    else{
                        //Reduce players funds if they lost
                        player.changeFunds(-1*player.getBetAmount());
                        System.err.println("You lost the bet. You now have "+player.getFunds());
                    }
                }
                //End of determining the winner
            }
            else{
                boolean pDraw=player.draw();
                //if the player draws a card
                if(pDraw){
                    c=deck.removeRandom();
                    player.addCard(c);
                    System.err.println("Player drew "+c+". Player's new score is : "+player.getCardsValue());

                }
                else
                    System.err.println("Player does not draw.");

                //Banker drawing, first find the value of the drawn card
                int drawValue=0;
                if(c.getRank()<10){				
                            drawValue=c.getRank();
                }
                if(bank.draw(drawValue,pDraw)){
                    c=deck.removeRandom();
                    bank.addCard(c);
                    System.err.println("Banker drew "+c+". Bankers's new score is : "+bank.getCardsValue());
                }
                else{
                    System.err.println("Banker does not draw.");
                }

                //Start of determining the winner
                if(player.getCardsValue()>bank.getCardsValue()){
                    System.err.println("Player Wins!");
                    if(player.getBetType()==1){
                        //Use the banker transfer funds method to find the appropriate winnings for the player 
                        player.changeFunds(bank.transferFunds(player.getBetType(), player.getBetAmount()));
                        System.err.println("You won the bet. You now have "+ player.getFunds());
                    }
                    else{
                        //Reduce players funds if they lost
                        player.changeFunds(-1*player.getBetAmount());
                        System.err.println("You lost the bet. You now have "+player.getFunds());
                    }
                }
                else if(player.getCardsValue()<bank.getCardsValue()){
                    System.err.println("Banker Wins!");
                    if(player.getBetType()==2){
                        //Use the banker transfer funds method to find the appropriate winnings for the player 
                        player.changeFunds(bank.transferFunds(player.getBetType(), player.getBetAmount()));
                        System.err.println("You won the bet. You now have "+ player.getFunds());
                    }
                    else{
                        //Reduce players funds if they lost
                        player.changeFunds(-1*player.getBetAmount());
                        System.err.println("You lost the bet. You now have "+player.getFunds());
                    }
                }
                else {
                    System.err.println("It's A Tie!");
                    if(player.getBetType()==3){
                        //Use the banker transfer funds method to find the appropriate winnings for the player 
                        player.changeFunds(bank.transferFunds(player.getBetType(), player.getBetAmount()));
                        System.err.println("You won the bet. You now have "+ player.getFunds());
                    }
                    else{
                        //Reduce players funds if they lost
                        player.changeFunds(-1*player.getBetAmount());
                        System.err.println("You lost the bet. You now have "+player.getFunds());
                    }
                }
                //End of determining the winner


            }
            System.err.println("Would you like to play again?\n1)Yes\n2)No");
            if( scanner.nextInt()==2 )
                break;
            else{
                deck.reset();
                //Re shuffle deck.
                //Reset player cards
                player.getCardPile().getCards().clear();
                bank.getCardPile().getCards().clear();
            }
                   
        }//End of while    
        System.err.println("Goodbye. Thanks for playing.");
    }//end of main
    
   
    
}
