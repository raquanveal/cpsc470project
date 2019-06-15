package project.cpsc470;

import java.util.Random;
import java.util.Iterator;
import java.util.Arrays;

class Deck
{
	private static Deck instance;

	private static String[] deck;
	private static String[] playedCards;
	private Iterator<String> i;

	private int nextShoeIndex;
	private int numCardsLeft;

	public static synchronized Deck getSingleton()
	{
		if (instance == null)
			instance = new Deck();
		return instance;
	}

	private Deck() { this(52); }

	private Deck(int shoeSize)
	{
		deck = new String[shoeSize];
		playedCards = new String[shoeSize];
		shuffle(shoeSize);
	}

	private void shuffle(int shoeSize)
	{
		nextShoeIndex = 0;
		numCardsLeft = shoeSize;
		Random random = new Random();
		for (int i=0; i<shoeSize; i++) {
			int rNum = random.nextInt(13);
			switch (rNum) {
			case 0:
				deck[i] = "K";
				break;
			case 1:
				deck[i] = "A";
				break;
			case 2:
				deck[i] = "2";
				break;
			case 3:
				deck[i] = "3";
				break;
			case 4:
				deck[i] = "4";
				break;
			case 5:
				deck[i] = "5";
				break;
			case 6:
				deck[i] = "6";
				break;
			case 7:
				deck[i] = "7";
				break;
			case 8:
				deck[i] = "8";
				break;
			case 9:
				deck[i] = "9";
				break;
			case 10:
				deck[i] = "10";
				break;
			case 11:
				deck[i] = "J";
				break;
			case 12:
				deck[i] = "Q";
				break;
			}
		}
		i = Arrays.asList(deck).iterator();

	}

	String getCard() 
	{ 
		if (!i.hasNext())
			shuffle(52);
		String card = i.next();

		playedCards[nextShoeIndex] = card;
		
		nextShoeIndex++;
		numCardsLeft--;
		
		return card;
		 
	}	

	String[] getPlayedCards() { return playedCards; }

	int getNumCardsLeft() { return numCardsLeft; } 
}
