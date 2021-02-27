/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;

public class UnoCard {
	
	enum Color
	{
		 RED,BLUE,GREEN,YELLOW,WILD;
		
		private static final Color colors[]=Color.values();//store all the  elements  of enum  Color into  an array of Color type 
		public static Color getColor(int i) //method to get color
		{  
			return Color.colors[i];   //Return array elements
		}
	}
	
	enum Value
	{
		ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,DRAWTWO,SKIP,REVERSE,WILD,DRAWFOUR;
		
		private static final Value value[]=Value.values();//store all the  elements  of enum  Value into  an array of Value type 
		public static Value getvalues(int i)//method to get value
		{
			return Value.value[i];  //Return array elements
		}
	}
	
	private final Color color;  //Set attributes; color and value of the cards are constant (final)
	private final Value value;
	
	
	public UnoCard ( final Color color,final  Value value) //Constructor
	{
		this.color=color;
		this.value=value;
	}
	
	public Color getColor()  
	{
		return this.color;//referes to the final color variable
	}
	
	public Value getValue()
	{
		return this.value; //referes to the final value variable
	}
	
        //testing///////////////////-delete this 
	public String toString()
	{
		return color + "_" + value;
	}
}
