package Racko;

public class Player {
	private int[]rack;
	private int playerNum;
	int holder;
	
	//constructor
	public Player(int playerNum)
	{
		rack= new int[10];
		this.playerNum=playerNum;
	}
	
	//returns the player num so that the game
	//can dislay which player's turn it is
	public int getPlayerNum()
	{
		return playerNum;
	}
	
	//fills the rack with cards
	public void fillRack(int index, int card)
	{
		rack[index]=card;
	}
	
	//takes a new card and places it into the rack
	//in place of an old card
	public int switchCard(int newCard, int index)
	{
		holder=rack[index];
		rack[index]=newCard;
		return holder;
	}
	
	//check if the winner really won
	public Boolean checkWinner()
	{
		for(int x=0; x<9;x++)
		{
			if(rack[x] < rack[x+1])
			{
				return false;
			}	
		}
		return true;
	}

	//display the rack
	public String displayRack() {
		StringBuilder str= new StringBuilder();
		for(int x=0; x<rack.length; x++)
		{
			str.append(rack[x]);
			str.append("\n");
		}
		return str.toString();
		
	}

	
	
	
	
	
	

}
