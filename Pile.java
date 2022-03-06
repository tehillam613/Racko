package Racko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Pile {
	private Stack<Integer> pile;
	private int top;
	
	//constructor
	public Pile()
	{
		this.pile= new Stack<Integer>();
		fillWithCards();
	}

	//pop
	public int getTop() {
		top=pile.pop();
		return top;
	}

	//push
	public void setTop(int top) {
		pile.push(top);
		this.top = top;
	}
	
	//creates the deck of cards using an arrayList
	public void fillWithCards()
	{
		//instantiate an arrayList with 1-60
		ArrayList<Integer> holder= new ArrayList<Integer>();
		for(int x=1; x<61; x++)
		{
			holder.add(x);
		}
		//shuffle numbers 1-60
		Collections.shuffle(holder);
		
		//place shuffled numbers into the pile 
		//of cards
		for(int y=0; y<holder.size();y++)
		{
			pile.push(holder.get(y));
		}
		
		//get started with the first card
		int highest=pile.pop();
		setTop(highest);
	}
	
	public int size()
	{
		return pile.size();
	}
	
	public Boolean isEmpty()
	{
		return pile.isEmpty();
	}
	
}
