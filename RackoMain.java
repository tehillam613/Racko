package Racko;
import java.util.Scanner;

public class RackoMain {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		
		Pile deck= new Pile();
		Pile discardPile= new Pile();
		
		Player p1= new Player(1);
		Player p2= new Player(2);
		
		//fill the first players rack
		for(int x=0; x<10; x++)
		{
			p1.fillRack(x, deck.getTop());
		}
		
		//fill the second players rack
		for(int x=0; x<10; x++)
		{
			p2.fillRack(x, deck.getTop());
		}
	
		//display info
		System.out.println("Player 1 rack: ");
		System.out.println(p1.displayRack());
		System.out.println("Player 2 rack: ");
		System.out.println(p2.displayRack());
		
		System.out.println("Top of discard pile: ");
		discardPile.setTop(deck.getTop());
		int topDiscard=discardPile.getTop();
		System.out.println(topDiscard);
		discardPile.setTop(topDiscard);
		
		//initialize players
		Player player=p1;
		Player other=p2;
		Player temp;
		
		int choice=0;
		Boolean win=false;
		
		//while the player didn't call racko!
		while (choice !=3)
		{
			System.out.println("Player " + player.getPlayerNum()+ "'s turn:");
			System.out.println("1- Pick a new card, 2- Take from the discard pile, 3-Say Racko.");
			choice= input.nextInt();
		//data validation
		while(choice !=1 && choice !=2 && choice !=3)
		{
			System.out.println("1- Pick a new card, 2- Take from the discard pile, 3-Say Racko.");
			choice= input.nextInt();
		}
		
		int hold, returnedCard, num;
		
		//flip over the discard pile in case the deck is empty
		if(deck.isEmpty())
		{
			for(int p=0; p<discardPile.size(); p++)
			{
				deck.setTop(discardPile.getTop());
			}
			//reset one card to be the top of the discard pile
			discardPile.setTop(deck.getTop());
		}
		
		//to pick a new card
		if(choice==1)
		{
			hold=deck.getTop();
			System.out.println("New card: "+hold);
			System.out.println("To use this card, press 1. To discard it, press 2.");
			int option= input.nextInt();
			//data validation
			while(option !=1 && option !=2)
			{
				System.out.println("To use this card, press 1. To discard it, press 2.");
				option= input.nextInt();
			}
			//if player wants to use the card they just picked from the pile
			if(option==1)
			{
				System.out.println("Enter the index of the number you would like to switch with"
						+ "? The top number is index 0 and the lowest number is 9");
				num= input.nextInt();
				//data validation
				while (num<0 || num>9)
				{
					System.out.println("Enter the index of the number you would like to switch with"
							+ "? The top number is index 0 and the lowest number is 9");
					num= input.nextInt();
				}
				//switch the card for one in your rack
				returnedCard=player.switchCard(hold, num);
				//set the card you removed to be top of discard
				discardPile.setTop(returnedCard);
			}
			//if player discards the card he just chose
			else
			{
				discardPile.setTop(hold);
			}
			
		}
		
		//if player picks the top of the discard pile
		else if(choice==2)
		{
			hold=discardPile.getTop();
			System.out.println("Enter the index of the number you would like to switch with"
					+ "? The top number is index 0 and the lowest number is 9");
			num= input.nextInt();
			//data validation
			while (num<0 || num>9)
			{
				System.out.println("Enter the index of the number you would like to switch with"
						+ "? The top number is index 0 and the lowest number is 9");
				num= input.nextInt();
			}
			returnedCard=player.switchCard(hold, num);
			discardPile.setTop(returnedCard);
		}
		
		//if player called racko!
		else
		{
			//check if the player actually won
			if(player.checkWinner()==false)
			{
				win=false;
				System.out.println("False alarm! Continue playing!");
				choice=0;
			}
			else
			{
				win=true;
				System.out.println("Player "+ player.getPlayerNum()+" is the winner! Congrats!");
				choice=3;
			}
		}
		
		//after each round
		if(win != true)
		{
			//display both racks
		displayBoards(p1, p2, discardPile);
		//change to next player
		temp=player;
		player=other;
		other=temp;
		}
		
		} //end of while
		}
	
	
		
		public static void displayBoards(Player p1, Player p2, Pile discardPile)
		{
			int topDiscard;
			System.out.println("Player 1 rack: ");
			System.out.println(p1.displayRack());
			System.out.println("Player 2 rack: ");
			System.out.println(p2.displayRack());
			
			System.out.println("Top of discard pile: ");
			//take it out to display it
			topDiscard=discardPile.getTop();
			System.out.println(topDiscard);
			//put it back in where it belongs
			discardPile.setTop(topDiscard);
		}
		
		
		
	}


