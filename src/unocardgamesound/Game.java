
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Game {
        public   ArrayList<ArrayList<UnoCard>> Hand;
      
        private  int points[] = new int[10];
	private int currentPlayer; 
	private final String playerIds[]; //stores the names of the players 
       
	private  UnoDeck deck;
	public   ArrayList<ArrayList<UnoCard>> playerHand; 
	private final ArrayList<UnoCard> stockPile;
	 
	public UnoCard.Color validColor;
	public UnoCard.Value validValue;
	
	boolean gameDirection;
        GameStage gameStage;
	public Game(String[] pids,int points[],GameStage gamestage) //constructor 
	{       gameStage=gamestage;
		deck=new UnoDeck(); 
		deck.shuffle();
		this.points=points;
		stockPile=new ArrayList<UnoCard>();
		
   		playerIds=pids;
		currentPlayer=0;
		gameDirection=false;
		
		playerHand= new ArrayList<ArrayList<UnoCard>>();
	
		
		for(int i=0;i<pids.length;i++) //Fill up hand of each player with uno cards
		{
			ArrayList<UnoCard> hand =new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7) )); //there are 7 cards in one hand
			playerHand.add(hand); //add that hand to the playerhand
		}
		
		
	}
 
        
       
        
        //start the game
	public void start(Game game)
	{
		UnoCard card=deck.drawCard(); // first draw card from the deck
		validColor=card.getColor(); //get the the colour and value of that card
		validValue=card.getValue();

		if (card.getValue()==UnoCard.Value.WILD) { //the first card cannot be a wild card
			start(game); //therefore we have to draw another card to start the game
		}
		
		if (card.getValue()==UnoCard.Value.DRAWFOUR) { //the first card cannot be a drawfour card
			start(game); //therefore we have to draw another card to start the game
		}
                
                if (card.getValue()==UnoCard.Value.DRAWTWO) { //if the first card is a drawtwo,then the first player has to draw 2 cards
                        String piD=playerIds[currentPlayer];
			getPlayerhand(piD).add(deck.drawCard());
			getPlayerhand(piD).add(deck.drawCard());
			ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_drawtwo.png"));
                       JOptionPane.showMessageDialog(null,playerIds[currentPlayer]+" drew two cards","",JOptionPane.INFORMATION_MESSAGE,iconic);
                        //turn goes to the next player
                       if(gameDirection==false)
			{
				currentPlayer=(currentPlayer+1)%playerIds.length;
			}
			
			else if(gameDirection==true)
			{
				currentPlayer=(currentPlayer-1)%playerIds.length;
				if(currentPlayer==-1) {
					currentPlayer=playerIds.length-1;
				}
			}
                        
		}
                
                
		
		if (card.getValue()==UnoCard.Value.SKIP) { //if the first card is a SKIP then skip the first player
			
                       ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_skip.png"));
                       JOptionPane.showMessageDialog(null,playerIds[currentPlayer]+" is Skipped ","",JOptionPane.INFORMATION_MESSAGE,iconic);
			
                       //turn goes to the next player
			if (gameDirection==false) {
				currentPlayer=(currentPlayer+1)%playerIds.length;
			}
			
			else if (gameDirection==true) {
				currentPlayer=(currentPlayer-1)%playerIds.length;
				if(currentPlayer==-1) {
					currentPlayer=playerIds.length-1; 
				}
			}
                        
                       
                        
			
		}
		
		if (card.getValue()==UnoCard.Value.REVERSE) { //if the first card is a REVERSE change the direction
			
			gameDirection ^=true; //flip the game direction
			currentPlayer=playerIds.length;
                        if(gameDirection==true)
			{
				currentPlayer=(currentPlayer-2)%playerIds.length;
				if(currentPlayer==-1)
				{
					currentPlayer=playerIds.length-1;
				}
				
				if(currentPlayer==-2)
				{
					currentPlayer=playerIds.length-2;
				}
			}
			
			else if (gameDirection==false) {
				currentPlayer=(currentPlayer+2)%playerIds.length;
			}
                        
                        
                        ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_reverse.png"));
                        JOptionPane.showMessageDialog(null," Game Direction is Reversed ","",JOptionPane.INFORMATION_MESSAGE,iconic);
			
			
			
		}
		stockPile.add(card); //add that card to the stockpile
	}
	
	//get the topmost card on the stockpile
	public UnoCard getTopCard() {
		return new UnoCard(validColor,validValue);
	}
	
	public ImageIcon getTopCardImage() {
           
                    return new ImageIcon(validColor + "_" + validValue + ".png");
		
	}
	
	
	public String getCurrentPlayer() { //method to get the name of the current player
		return this.playerIds[this.currentPlayer];
	}
	
        public ArrayList<UnoCard> getPlayerhand(String pid) //get the hand of the player
	{
		int index=Arrays.asList(playerIds).indexOf(pid);
		return playerHand.get(index);
	}
	
	public int getPlayerHandSize(String pid) { //return size of the player hand
		return getPlayerhand(pid).size();
	}
	
	public UnoCard getPlayercard(String pid,int choice) //get the card selected by the player
	{
		ArrayList<UnoCard> hand=getPlayerhand(pid); //get the hand of the player
		return hand.get(choice); //return the selected card
	}
	
	public boolean hasEmptyHand(String pid) //check whether the hand is empty
	{
		return getPlayerhand(pid).isEmpty();
	} 
	
	public boolean validCardPlay(UnoCard card) //Check whether the card we are playing is valid
	{
		return card.getColor()==validColor||card.getValue()==validValue;
	}
	
	public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException{ //Check for the player turn to ensure that it's correct player turn
		if (this.playerIds[this.currentPlayer]!=pid) {
			throw new InvalidPlayerTurnException("it is not "+pid+"'s turn",pid);
		}
		
	}
        
  
	//method which is called when the players  draw a  card from the deck 
	public void submitDraw(String pid) throws InvalidPlayerTurnException{
		checkPlayerTurn(pid); //check the player turn
		
                //if the deck is empty replace the deck with the stockpile and shuffle it
		if (deck.isEmpty()) {
			deck.replaceDeckWith(stockPile);
			deck.shuffle();
		}
                
                //draw card from the deck and add it to the player hand
		UnoCard newCard=deck.drawCard();
		getPlayerhand(pid).add(newCard);
                
             
                //if the player can't use the drawn card then the turn goes to the next player according to the gamedirection otherwise the play
                //can submit the drawn card
                 if (newCard.getColor()!=validColor && newCard.getValue()!=validValue && newCard.getColor()!=UnoCard.Color.WILD) {
                    
                
		if (gameDirection==false) {
			currentPlayer=(currentPlayer+1)%playerIds.length;
		}
		
		else if (gameDirection==true) {
			currentPlayer=(currentPlayer-1)%playerIds.length;
			if(currentPlayer==-1) {
				currentPlayer=playerIds.length-1;
			}
		}
                 }
	}
	
        
       
	public void setCardColor(UnoCard.Color color) {
		validColor=color;
	}   
	
        
        
        //method which is called when the player tries to submit a card
        public void submitPlayerCard(String pid,UnoCard card,UnoCard.Color declaredColor) throws  InvalidColorSubmissionException,InvalidValueSubmissionException,InvalidPlayerTurnException{
		checkPlayerTurn(pid); //first check the player turn
		ArrayList<UnoCard> pHand=getPlayerhand(pid); //get the player hand
               if (!validCardPlay(card)) { //if the card player  tries to submit is not a valid card
                   
			if(card.getColor()==UnoCard.Color.WILD) { //first check whether the card is a wild card beacuse wild can be placed on top of any card
				 validColor =card.getColor(); 
				 validValue=card.getValue();
			}
			
			if (card.getColor()!=validColor) { //if the cards's colour doesn't match with the valid color
				JLabel message = new JLabel("Invalid player move ,expectected colour : "+validColor);
				JOptionPane.showMessageDialog(null, message);
				throw new InvalidColorSubmissionException("Invalid player move ,expectected colour : "+validColor, card.getColor(), validColor); 
			}
			
			else if (card.getValue()!=validValue) { //if the cards's value doesn't match with the valid value
				JLabel message2 = new JLabel("Invalid player move ,expectected value : "+validValue);
				JOptionPane.showMessageDialog(null, message2);
				throw new InvalidValueSubmissionException("Invalid player move ,expectected value : "+validValue  , card.getValue(), validValue); 
			}
		}
                
                
		pHand.remove(card); //if the player can submit the selected card,remove that card from the player's hand
		
                if (hasEmptyHand(this.playerIds[currentPlayer])) //if the player hand is empty then that round is finished
		{       int player=currentPlayer;
			//JLabel message2 = new JLabel(this.playerIds[currentPlayer]+" won this round!");
			//JOptionPane.showMessageDialog(null, message2);
                        ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/trophy.png"));
			 JOptionPane.showMessageDialog(null, this.playerIds[currentPlayer]+" won this round!","",JOptionPane.INFORMATION_MESSAGE,iconic);
                        
                        //calculate the points for each player
                        int n=playerIds.length;
                        for(int i=0;i<n;i++)
                        {   
                            int size=getPlayerHandSize(playerIds[i]);
                            for (int k=0;k<size;k++){ //assigning points 
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.ONE)
                                        points[player]+=1;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.TWO)
                                        points[player]+=2;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.THREE)
                                        points[player]+=3;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.FOUR)
                                        points[player]+=4;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.FIVE)
                                        points[player]+=5;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.SIX)
                                        points[player]+=6;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.SEVEN)
                                        points[player]+=7;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.EIGHT)
                                        points[player]+=8;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.NINE)
                                        points[player]+=9;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.SKIP)
                                        points[player]+=20;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.REVERSE)
                                        points[player]+=20;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.DRAWTWO)
                                        points[player]+=20;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.DRAWFOUR)
                                        points[player]+=50;
                                if( getPlayerhand(playerIds[i]).get(k).getValue()==UnoCard.Value.WILD)
                                        points[player]+=50;
                              
                          
                        }
                        }
                        //if a player has points>500 then he/she can won the game
                        if (points[player]>=500){
                            
                            
                  
                            
                            //JLabel message3 = new JLabel(this.playerIds[currentPlayer]+" won the game with "+points+" points.");
                            //ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/trophy.png"));
			    JOptionPane.showMessageDialog(null, this.playerIds[currentPlayer]+" won the game with "+points+" points.","",JOptionPane.INFORMATION_MESSAGE,iconic);
			    System.exit(0);
		     }
                        //otherwise the game continues untill one of the players score more than 500 
                        else if (points[player]<500)
                        {   JLabel message = new JLabel("Points = "+points[player]);
			    JOptionPane.showMessageDialog(null, message);
                            JLabel message3 = new JLabel("Welcome to another round");
			    JOptionPane.showMessageDialog(null, message3);
                            gameStage.dispose();//dispose the current round and create a new round
                            new GameStage( new ArrayList<String>(Arrays.asList(playerIds)),points).setVisible(true); //Display the new frame 
                        }
                }
                
                //if a player forgot to click UNO when he/she has only one card left in his/her  hand then  he/she has to draw 2 cards as a penalty 
                if(getPlayerHandSize(getCurrentPlayer())==1 && GameStage.uno==false) //penalty
                {     
                      Music m = new Music();
                      m.caught();
                     JLabel message2 = new JLabel(getCurrentPlayer()+" has to draw two cards");
		      JOptionPane.showMessageDialog(null, message2);
                       if (deck.isEmpty()) {
		     deck.replaceDeckWith(stockPile);
			deck.shuffle();
                    }
                       
		UnoCard newCard1=deck.drawCard();
                UnoCard newCard2=deck.drawCard();
		getPlayerhand(pid).add(newCard1);
                getPlayerhand(pid).add(newCard2);
               
       
                }
                
                
                //if the player has yelled UNO ,then there's no penalty
                 if(getPlayerHandSize(getCurrentPlayer())==1 && GameStage.uno==true)
                {     
                    GameStage.uno=false;
                 }
                
              
               // get the colour and the value of the submitted card 
               validColor =card.getColor();
		validValue=card.getValue();
		stockPile.add(card); //add the submitted card to the stockpile
		
                
                //set the next player as the current player;next player is found according to the game direction
		if(gameDirection==false)
		{
			currentPlayer=(currentPlayer+1)%playerIds.length;
		}
		
		else if(gameDirection==true)
		{
			currentPlayer=(currentPlayer-1)%playerIds.length;
			if(currentPlayer==-1)
			{
				currentPlayer=playerIds.length-1;
			}
		}
		
                //if the chosen card is a wild card then the valid colour will be the color declared by the player
		if(card.getColor()==UnoCard.Color.WILD)
		{
			validColor=declaredColor;
		}
		
                //if the chose card is a drawtwo add two card to the hand of the current player
		if(card.getValue()==UnoCard.Value.DRAWTWO && getPlayerHandSize(pid)!=0 )
		{    
			pid=playerIds[currentPlayer];
			getPlayerhand(pid).add(deck.drawCard());
			getPlayerhand(pid).add(deck.drawCard());
			
                         ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_drawtwo.png"));
                       JOptionPane.showMessageDialog(null,playerIds[currentPlayer]+" drew two cards","",JOptionPane.INFORMATION_MESSAGE,iconic);
                        
                       //find the next player according to the game direction
                       if(gameDirection==false)
			{
				currentPlayer=(currentPlayer+1)%playerIds.length;
			}
			
			else if(gameDirection==true)
			{
				currentPlayer=(currentPlayer-1)%playerIds.length;
				if(currentPlayer==-1) {
					currentPlayer=playerIds.length-1;
				}
			}
			
		}
		
                 //if the chose card is a drawfour add four card to the hand of the current player
		if(card.getValue()==UnoCard.Value.DRAWFOUR && getPlayerHandSize(pid)!=0)
		{       
                  
                        ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/drawfour.png"));
                        JOptionPane.showMessageDialog(null,playerIds[currentPlayer]+" Drew Four cards ","",JOptionPane.INFORMATION_MESSAGE,iconic);
			pid=playerIds[currentPlayer];
			getPlayerhand(pid).add(deck.drawCard());
			getPlayerhand(pid).add(deck.drawCard());
			getPlayerhand(pid).add(deck.drawCard());
			getPlayerhand(pid).add(deck.drawCard());
			
                        //find the next player according to the game direction
                        if(gameDirection==false)
			{
				currentPlayer=(currentPlayer+1)%playerIds.length;
			}
			
			else if(gameDirection==true)
			{
				currentPlayer=(currentPlayer-1)%playerIds.length;
				if(currentPlayer==-1) {
					currentPlayer=playerIds.length-1;
				}
			}
                  	
		}
		
                 //if the chose card is a skip the the current player is skipped 
		if(card.getValue()==UnoCard.Value.SKIP && getPlayerHandSize(pid)!=0)
		{
			
			 ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_skip.png"));
                       JOptionPane.showMessageDialog(null,playerIds[currentPlayer]+" is Skipped","",JOptionPane.INFORMATION_MESSAGE,iconic);
			
			if(gameDirection==false)
			{
				currentPlayer=(currentPlayer+1)%playerIds.length;
			}
			
			else if(gameDirection==true)
			{
				currentPlayer=(currentPlayer-1)%playerIds.length;
				if(currentPlayer==-1) {
					currentPlayer=playerIds.length-1;
				}
			}
		}
		
                 //if the chose card is a reverse ,then flip the game direction
		if(card.getValue()==UnoCard.Value.REVERSE && getPlayerHandSize(pid)!=0)
		{       
                       
			 ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_reverse.png"));
                        JOptionPane.showMessageDialog(null,"Game Direction is Reversed","",JOptionPane.INFORMATION_MESSAGE,iconic);
			
			gameDirection ^=true;
			if(gameDirection==true)
			{
				currentPlayer=(currentPlayer-2)%playerIds.length;
				if(currentPlayer==-1)
				{
					currentPlayer=playerIds.length-1;
				}
				
				if(currentPlayer==-2)
				{
					currentPlayer=playerIds.length-2;
				}
			}
			
			else if (gameDirection==false) {
				currentPlayer=(currentPlayer+2)%playerIds.length;
			}
		}
                
	}
        

}
//Exceptions
class InvalidPlayerTurnException extends Exception{
	String playerId;
	public InvalidPlayerTurnException(String message,String pid)
	{
		super(message);
		playerId=pid;
	}
	
	public String getPid() {
		return playerId;
	}
}

class InvalidColorSubmissionException extends Exception{
	private UnoCard.Color expected;
	private UnoCard.Color actual;
	
	public InvalidColorSubmissionException(String message,UnoCard.Color actual,UnoCard.Color expected )
	{
		this.actual=actual;
		this.expected=expected;
	}
	
}

class InvalidValueSubmissionException extends Exception{
	private UnoCard.Value expected;
	private UnoCard.Value actual;
	
	public InvalidValueSubmissionException(String message,UnoCard.Value actual,UnoCard.Value expected )
	{
		this.actual=actual;
		this.expected=expected;
	}
	
}
