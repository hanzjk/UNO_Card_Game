/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static unocardgamesound.PcvsPlayer.uno;


public class GameSingle {
        PcvsPlayer pcvsplayer;
        public   ArrayList<ArrayList<UnoCard>> Hand;
        private  int points[] = new int[2];
	private int currentPlayer;
	private final String playerIds[];//stores the names of the players 
       
	private  UnoDeck deck;
	public   ArrayList<ArrayList<UnoCard>> playerHand; //made it static
	private final ArrayList<UnoCard> stockPile;
	 
	public UnoCard.Color validColor;
	public UnoCard.Value validValue;
	

          public GameSingle(String[] pids,int points[],PcvsPlayer pcvsplayer)//constructor 
	{       
                this.pcvsplayer=pcvsplayer;
		deck=new UnoDeck();
		deck.shuffle();
		this.points=points;
		stockPile=new ArrayList<UnoCard>();
		
   		playerIds=pids;
		currentPlayer=0;
		
		playerHand= new ArrayList<ArrayList<UnoCard>>();
	
		
		for(int i=0;i<pids.length;i++)//Fill up hand of each player with uno cards
		{
			ArrayList<UnoCard> hand =new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7) ));//there are 7 cards in one hand
			playerHand.add(hand);//add that hand to the playerhand
		}
		
		
	}
          
          
          
         //start the game 
         public int  startplayer2(GameSingle game)  //shoud start with the player;
	{       currentPlayer=0;
		UnoCard card=deck.drawCard();// first draw card from the deck
		validColor=card.getColor();//get the the colour and value of that card
		validValue=card.getValue();

		if (card.getValue()==UnoCard.Value.WILD) { //the first card cannot be a wild card
			startplayer2(game);//therefore we have to draw another card to start the game
		}
		
                
              
		if (card.getValue()==UnoCard.Value.DRAWFOUR) {//the first card cannot be a drawfour card
			startplayer2(game);//therefore we have to draw another card to start the game
		}
                
                if (card.getValue()==UnoCard.Value.DRAWTWO) { //if the first card is a drawtwo,then the player has to draw 2 cards
                        String piD=playerIds[0]; //0-player 1-PC
			getPlayerhand(piD).add(deck.drawCard());
			getPlayerhand(piD).add(deck.drawCard());
			ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_drawtwo.png"));
                     /**/  JOptionPane.showMessageDialog(null,playerIds[0]+" drew two cards","",JOptionPane.INFORMATION_MESSAGE,iconic);
                        
                       currentPlayer=1; //turn goes to the PC
                        
		}
                
                
		
		if (card.getValue()==UnoCard.Value.SKIP) {//if the first card is a SKIP then skip the player
			
			
			currentPlayer=1;//turn goes to the PC
                        
                       
                        ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_skip.png"));
                        JOptionPane.showMessageDialog(null,playerIds[0]+" is Skipped","",JOptionPane.INFORMATION_MESSAGE,iconic);
			
		}
		
		if (card.getValue()==UnoCard.Value.REVERSE) {//if the first card is a REVERSE change the direction
			currentPlayer=0;//turn goes to the player
                        
                        
                        ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_reverse.png"));
                        JOptionPane.showMessageDialog(null,"Game Direction is Reversed","",JOptionPane.INFORMATION_MESSAGE,iconic);
			
			
			
		}
                
		stockPile.add(card);//add that card to the stockpile
                return currentPlayer;
	}
         
         
         public ArrayList<UnoCard> getPlayerhand(String pid)//get the hand of the player
	{
		int index=Arrays.asList(playerIds).indexOf(pid);
		return playerHand.get(index);
	}
         
         public int getPlayerHandSize(String pid) {//return size of the player hand
		return getPlayerhand(pid).size();
	}
    
         //Play pc cards
       
	
	public boolean validCardPlay(UnoCard card)//Check whether the card we are playing is valid
	{
		return card.getColor()==validColor||card.getValue()==validValue;
	} 

    //method which is called when the players  draw a  card from the deck
            public int submitDraw(String pid) throws  InvalidColorSubmissionException,InvalidValueSubmissionException,InvalidPlayerTurnException {
           //assign whose turn 
                if (pid=="PC")
               currentPlayer=0;
           else
               currentPlayer=1;
           
           //if the deck is empty replace the deck with the stockpile and shuffle it
           if (deck.isEmpty()) {
			deck.replaceDeckWith(stockPile);
			deck.shuffle();
		}
                
           //draw card from the deck and add it to the player hand
		UnoCard newCard=deck.drawCard();
		getPlayerhand(pid).add(newCard);
                
                //if the player can't use the drawn card then the turn goes to the PC 
                //can submit the drawn card
                 if (newCard.getColor()==validColor || newCard.getValue()==validValue || newCard.getColor()==UnoCard.Color.WILD) {
                       currentPlayer=(currentPlayer==0)?1:0;
                 }
                 return currentPlayer;
	}
            
        
        //method which is called when the player tries to submit a card
         public int submitPlayerCard(String pid,UnoCard card,UnoCard.Color declaredColor, JButton topcardButton) throws  InvalidColorSubmissionException,InvalidValueSubmissionException,InvalidPlayerTurnException{
         if(pid=="PC")
             currentPlayer=0; //switch players //pc=>1
            
         
         else
             currentPlayer=1;
         
             
               
		ArrayList<UnoCard> pHand=getPlayerhand(pid);//get the player hand
               if (!validCardPlay(card)) {//if the player tries to submit an invalid card
			if(card.getColor()==UnoCard.Color.WILD) {//first check whether the card is a wild card beacuse wild can be placed on top of any card
				 validColor =card.getColor();
				 validValue=card.getValue();
			}
			
			if (card.getColor()!=validColor) {//if the cards's colour doesn't match with the valid color
				JLabel message = new JLabel(/*"GOT "+card.getColor()+" "+card.getValue()+*/"Invalid player move ,expectected colour : "+validColor);
				JOptionPane.showMessageDialog(null, message);
				throw new InvalidColorSubmissionException("Invalid player move ,expectected colour : "+validColor, card.getColor(), validColor); 
			}
			
			else if (card.getValue()!=validValue) {//if the cards's value doesn't match with the valid value
				JLabel message2 = new JLabel("Invalid player move ,expectected value : "+validValue);
				JOptionPane.showMessageDialog(null, message2);
				throw new InvalidValueSubmissionException("Invalid player move ,expectected value : "+validValue  , card.getValue(), validValue); 
			}
		}
                
               
		pHand.remove(card);//if the player can submit the selected card,remove that card from the player's hand
                
		if (getPlayerHandSize(pid)==0)//if the player/PC hand is empty then that round is finished
		{       int c;
			//JLabel message2 = new JLabel(pid+" WON THIS ROUND");
			//JOptionPane.showMessageDialog(null, message2);
                        if (pid=="PC")
                            c=0;
                        else
                            c=1;
                        //calculate the points for player and PC
                         int size=getPlayerHandSize(playerIds[c]);
                            for (int k=0;k<size;k++){
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.ONE)
                                        points[c]+=1;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.TWO)
                                        points[c]+=2;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.THREE)
                                        points[c]+=3;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.FOUR)
                                        points[c]+=4;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.FIVE)
                                        points[c]+=5;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.SIX)
                                        points[c]+=6;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.SEVEN)
                                        points[c]+=7;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.EIGHT)
                                        points[c]+=8;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.NINE)
                                        points[c]+=9;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.SKIP)
                                        points[c]+=20;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.REVERSE)
                                        points[c]+=20;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.DRAWTWO)
                                        points[c]+=20;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.DRAWFOUR)
                                        points[c]+=50;
                                if( getPlayerhand(playerIds[c]).get(k).getValue()==UnoCard.Value.WILD)
                                        points[c]+=50;
                              
                          
                        }
                            //if a player/PC has points>500 then player/PC can win the game
                             if (points[c]>=500){
                            ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/trophy.png"));
			    JOptionPane.showMessageDialog(null, pid+" won the game with "+points[c]+" points.","",JOptionPane.INFORMATION_MESSAGE,iconic);
                            //JLabel message3 = new JLabel(pid+"Won the game with "+points[c]+" points.");
			    //JOptionPane.showMessageDialog(null, message3);
			    System.exit(0);
		     }
                        //otherwise the game continues untill either score more than 500 
                        else if (points[c]<500)
                        {   
                            ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/trophy.png"));
			    JOptionPane.showMessageDialog(null, pid+" won the game with "+points[c]+" points.","",JOptionPane.INFORMATION_MESSAGE,iconic);
                            //JLabel message = new JLabel(pid+"  Won this round with "+points[c]+" points.");
			    //JOptionPane.showMessageDialog(null, message);
                            JLabel message3 = new JLabel("Welcome to another round");
			    JOptionPane.showMessageDialog(null, message3);
                            pcvsplayer.dispose();//dispose the current round and create a new round
                           new PcvsPlayer( new ArrayList<String>(Arrays.asList(playerIds)),points).setVisible(true); //Display the new frame  //playerIds
                        }
                            
                     
		}
                
                
                
               
                //if the player forgot to click UNO when he/she has only one card left in his/her hand then  he/she has to draw 2 cards as a penalty
                 if (pid!="PC"){
                if(getPlayerHandSize(pid)==1 && PcvsPlayer.uno==false) //penalty
                {     
                     Music m = new Music();
        m.caught();
                     JLabel message2 = new JLabel(pid+" have to draw two cards");
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
                   if(getPlayerHandSize(pid)==1 && PcvsPlayer.uno==true)//no penalty
                 {     
                    PcvsPlayer.uno=false;
                 }
                 }
                 
                 if (pid=="PC" && getPlayerHandSize(pid)==1)//plays when PC has only two cards left
                 {
                      Music m = new Music();
        m.uno();
                   
                 }
                
                
		// get the colour and the value of the submitted card
		validColor =card.getColor();
		validValue=card.getValue();
                //add the submitted card to the stockpile
		stockPile.add(card);
		
		
		//if the chosen card is a wild card then the valid colour will be the color declared by the player/PC
		if(card.getValue()==UnoCard.Value.WILD  && getPlayerHandSize(pid)!=0 )
		{
			
                        //JLabel message2 = new JLabel("Change Color");
			//JOptionPane.showMessageDialog(null, message2);
                        currentPlayer=(currentPlayer==1)?0:0; //after choosing the color player gets to play again 
                        
                        if (pid=="PC") //PC chose a color
                        {
                        Random r=new Random(); //random value to select a color
                        topcardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/cardSprites/WILD_WILD.png")));
		        int randomValue= r.nextInt()%4;   
                      
			validColor=UnoCard.Color.getColor(Math.abs(randomValue));
                        JLabel message24 = new JLabel("Color is changed to "+ validColor.name());
			JOptionPane.showMessageDialog(null, message24);
                       
                        }
                        
                       
                        
                        
		}
		//if the chose card is a drawtwo add two card to the hand of the current player
		if(card.getValue()==UnoCard.Value.DRAWTWO  && getPlayerHandSize(pid)!=0)
		{
			pid=playerIds[(currentPlayer==1)?1:0]; //ternary operation to find the current player 
			getPlayerhand(pid).add(deck.drawCard());
			getPlayerhand(pid).add(deck.drawCard());
			
                         ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_drawtwo.png"));
                      /**/  JOptionPane.showMessageDialog(null,pid+" drew two cards","",JOptionPane.INFORMATION_MESSAGE,iconic);
                        currentPlayer=(currentPlayer==1)?0:1;
			
		}
		//if the chose card is a drawfour add four card to the hand of the current player
		if(card.getValue()==UnoCard.Value.DRAWFOUR  && getPlayerHandSize(pid)!=0)
		{       
                 pid=playerIds[(currentPlayer==1)?1:0];//ternary operation to find the current player
                  ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/drawfour.png"));
                 /**/  JOptionPane.showMessageDialog(null,pid+" Drew Four cards","",JOptionPane.INFORMATION_MESSAGE,iconic);
			
			getPlayerhand(pid).add(deck.drawCard());
			getPlayerhand(pid).add(deck.drawCard());
			getPlayerhand(pid).add(deck.drawCard());
			getPlayerhand(pid).add(deck.drawCard());
			
                        currentPlayer=(currentPlayer==1)?0:1;
                        if (pid!="PC")
                        {topcardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/cardSprites/WILD_DRAWFOUR.png")));
                       Random r=new Random();
                       int randomValue= r.nextInt()%4;   
		       validColor=UnoCard.Color.getColor(Math.abs(randomValue));
                       JLabel message2 = new JLabel("Color is changed to "+ validColor.name());
		       JOptionPane.showMessageDialog(null, message2);

                        }
			
		}
		//if the chose card is a skip the the current player is skipped
		if(card.getValue()==UnoCard.Value.SKIP  && getPlayerHandSize(pid)!=0)
		{
			
			 ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_skip.png"));
                       JOptionPane.showMessageDialog(null,playerIds[(currentPlayer==1)?1:0]+" is Skipped","",JOptionPane.INFORMATION_MESSAGE,iconic);
			
			 currentPlayer=(currentPlayer==1)?0:1;
		}
		//if the chose card is a reverse ,then flip the game direction
		if(card.getValue()==UnoCard.Value.REVERSE && getPlayerHandSize(pid)!=0)
		{
			 ImageIcon iconic=new ImageIcon(getClass().getResource("/unocardgamesound/images/"+card.getColor()+"_reverse.png"));
                        JOptionPane.showMessageDialog(null,"Game Direction is Reversed","",JOptionPane.INFORMATION_MESSAGE,iconic);
			 currentPlayer=(currentPlayer==1)?1:0;
                        
                        
		}
                
                return currentPlayer;
         }
         
         ///////////////////////////////////////////////////////////////////
          
          //player plays cards
         
          
          
          public UnoCard getTopCard() {
		return new UnoCard(validColor,validValue);
	}
	
	public ImageIcon getTopCardImage() {
              
                    return new ImageIcon(validColor + "_" + validValue + ".png");
		
	}
        
        public void setCardColor(UnoCard.Color color) {
		validColor=color;
	}   
        
        public String getCurrentPlayer() {
		return this.playerIds[this.currentPlayer];
	}
        
        
    }



