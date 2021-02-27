/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;


import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;


public class UnoDeck {
   private UnoCard  cards[]; //unoCard array named cards[] 
   private int cardsInDeck; //to indicate how many cards are in the deck
   public UnoDeck() //constructor
   {
	   cards = new UnoCard[108]; //108 cards are in the pack
	   reset();
	   
   }
   
   public void reset() //method to initialize the deck - create the card pack
   {
	   UnoCard.Color colors[]=UnoCard.Color.values(); //Make an array of enum type Color and fill it  with all the values in Color enum (RED,BLUE,GREEN,YELLOW)
	   cardsInDeck=0;
	   for (int i=0;i<colors.length-1;i++)   //Wild is not considered
	   {
		   UnoCard.Color color=colors[i];  //color varaible is used to store the Color
		   cards[cardsInDeck++]=new UnoCard(color, UnoCard.Value.getvalues(0)); //Each color has 1 zero card
		   
		   for(int j=1;j<13;j++)
		   {
			   cards[cardsInDeck++]=new UnoCard(color, UnoCard.Value.getvalues(j));  //Every color has 2 card from one to nine ,reverse,skip,draw_two
			   cards[cardsInDeck++]=new UnoCard(color, UnoCard.Value.getvalues(j));
		   }
         
           }
           
           for(int j=13;j<15;j++)
		   {
			   cards[cardsInDeck++]=new UnoCard(UnoCard.Color.WILD, UnoCard.Value.getvalues(j)); //There are 4 wild card and 4 DrawFour cards
			   cards[cardsInDeck++]=new UnoCard(UnoCard.Color.WILD, UnoCard.Value.getvalues(j));
                           cards[cardsInDeck++]=new UnoCard(UnoCard.Color.WILD, UnoCard.Value.getvalues(j));  
			   cards[cardsInDeck++]=new UnoCard(UnoCard.Color.WILD, UnoCard.Value.getvalues(j));
		   }
           }
   
   
   
   
   public void replaceDeckWith(ArrayList <UnoCard> cards) //method to replace the deck with an ArrayList of UnoCard
   {
	   this.cards=cards.toArray(new UnoCard[cards.size()] );
	   this.cardsInDeck=this.cards.length;
   }
   
   public boolean isEmpty() { //check whether the deck is empty or not
	   return cardsInDeck==0;
   }
   
   public  void shuffle() { //method to shufflr the cards in deck
	   int m=cards.length; //amount of cards in the deck
	   Random random =new Random();
	   for(int i=0;i<cards.length;i++) //shuffle the cards
	   {
		   int randomValue=i+random.nextInt(m-i);
		   UnoCard randomCard=cards[randomValue]; //pick a random card from the deck
		   cards[randomValue]=cards[i]; //swap cards
		   cards[i]=randomCard; //swap cards
	   	}
   }
   
   public UnoCard drawCard()  throws IllegalArgumentException{
	   if (isEmpty())
	   {
		   throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");
		   
	   }
	   return cards[--cardsInDeck];
   }
   
   public ImageIcon drawCardsImage() throws IllegalArgumentException{
	   if (isEmpty())
	   {
		   throw new IllegalArgumentException("Cannot draw a card since the deck is empty");
		   
	   }
	   return new ImageIcon(cards[--cardsInDeck].toString()+".png"); //return the card with the color and the number
   }
   
   public UnoCard[] drawCard(int n) //Call this method when the player has to draw cards (n-no of card to draw)
   {
	   if (n<0)
	   {
		   throw new IllegalArgumentException("Must draw postive cards  but tried to draw "+ n+ " cards");
	   }
	   
	   if (n>cardsInDeck) //if player tries to draw more cards than in the deck
	   {
		   throw new IllegalArgumentException("Cannot draw "+ n+ " cards since there are only "+ cardsInDeck+" cards");
		   
	   }
	   UnoCard ret[]=new UnoCard[n]; //new array of uno cards ; n = the no of cards to draw 
	   for(int i=0;i<n;i++)
	   {
		   ret[i]=cards[--cardsInDeck];
	   }
	   return ret; //cards which are drawn by the player
   }



}
