
import java.util.ArrayList;
import java.util.List;
/**
 * ************************CoinSorter Class**********************
 * Description: This .java file contains an implementation of the CoinSorter Class.
 * Purpose: A class (with out a main method) for sorting coins into 
 * the following denominations: 200p, 100p, 50p, 20p and 10p. 
 */


public class CoinSorter {
	
	// List of Variables
	private String currency = "£";
	private int minCoinIn = 0;
	private int maxCoinIn = 10000;
	public List<Integer> coinList;

	// Constructor 1 
	public CoinSorter(String currency, int minCoinIn, int maxCoinIn, List<Integer> coinListIn) {
		super();
		this.currency = currency;
		this.minCoinIn = minCoinIn;
		this.maxCoinIn = maxCoinIn;
		this.coinList = coinListIn;
	}
    
	// Constructor 2 
	public CoinSorter() {
	}
	

	// Set methods  (These “set” methods should set the corresponding attributes.)
	public void setCurrency(String currencyIn) {
		this.currency = currencyIn;
	}

	public void setMinCoinIn(int minCoinIn) {
		this.minCoinIn = minCoinIn;
	}


	public void setMaxCoinIn(int maxCoinIn) {
		this.maxCoinIn = maxCoinIn;
	}

	
	// Get methods (These “get” methods should return the corresponding attribute values.)
	public String getCurrency() {
		return currency;
	}


	public int getMinCoinIn() {
		return minCoinIn;
	}


	public int getMaxCoinIn() {
		return maxCoinIn;
	}
	
	// printCoinList() method: This method should print the contents of the coin list.
	public void printCoinList() {
		// Create an ArrayList
		coinList = new ArrayList<>();
		coinList.add(200);
    	coinList.add(100);
    	coinList.add(50);
    	coinList.add(20);
    	coinList.add(10);
		System.out.println("The current coin denominations in circulation are: \n");
		
		// Call conversion method.
        String result = convertToString(coinList);
        System.out.println(result);
		
	}
	
	// displayProgramConfigs() method: This method returns programs configuration as a String.
		public void displayProgramConfigs() {
			System.out.println("Current currency is: " + getCurrency());
			System.out.println("Current minimum (in pence): " + Integer.toString(getMinCoinIn()));
			System.out.println("Current maximum (in pence): " + Integer.toString(getMaxCoinIn()));
		}
	
	// coinCalculator() method: This method should take two values; the total value to exchange 
	// and a coin type, in order to calculate and return the maximum number of coins of the input 
	// coin type that can be exchanged, in addition to the remainder as a String.
	public void coinCalculator(int totalPenniesIn, int selectDenomIn) {
		final int twoPounds = 200;
		final int onePound = 100;
		final int fiftyPence = 50;
		final int twentyPence = 20;
		final int tenPence = 10;
		int numberOfTwoPounds, numberOfOnePound, numberOffiftyPence, 
			numberOftwentyPence, numberOftenPence; 
		int penceLeft;
		 
		if(selectDenomIn == twoPounds) {
			numberOfTwoPounds = totalPenniesIn / twoPounds;
			penceLeft = totalPenniesIn % twoPounds;
			System.out.println("A total of " + Integer.toString(numberOfTwoPounds) + " x " + 
			"£2 coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p");
		}else if(selectDenomIn == onePound) {
			numberOfOnePound = totalPenniesIn / onePound;
			penceLeft = totalPenniesIn % onePound;
			System.out.println("A total of " + Integer.toString(numberOfOnePound) + " x " + 
			"£1 coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p");
		}else if(selectDenomIn == fiftyPence) {
			numberOffiftyPence = totalPenniesIn / fiftyPence;
			penceLeft = totalPenniesIn % fiftyPence;
			System.out.println("A total of " + Integer.toString(numberOffiftyPence) + " x " + 
			"50p coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p");
		}else if(selectDenomIn == twentyPence) {
			numberOftwentyPence = totalPenniesIn / twentyPence;
			penceLeft = totalPenniesIn % twentyPence;
			System.out.println("A total of " + Integer.toString(numberOftwentyPence) + " x " + 
			"20p coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p");
		}else if(selectDenomIn == tenPence) {
			numberOftenPence = totalPenniesIn / tenPence;
			penceLeft = totalPenniesIn % tenPence;
			System.out.println("A total of " + Integer.toString(numberOftenPence) + " x " + 
			"10p coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p");
		}else {
			System.out.println("Please enter the correct denomination");
		}
	}
	
	// multiCoinCalculator() method: This method should take two values; the total value to exchange and a coin type to
	// exclude, in order to calculate and return the maximum number of coins of the input coin type that can be exchanged 
	// while excluding the input coin type, in addition to the remainder as a String.
	public void multiCoinCalculator(int totPenniesIn, int selDenomIn) {
		final int twoPounds = 200;
		final int onePound = 100;
		final int fiftyPence = 50;
		final int twentyPence = 20;
		final int tenPence = 10;
		int numbOfTwoPounds, numbOfOnePound, numbOffiftyPence, 
			numbOftwentyPence, numbOftenPence; 
		
		if(selDenomIn == twoPounds) {
			numbOfOnePound = totPenniesIn / onePound;
			int onePoundRemainder = totPenniesIn % onePound;
			numbOffiftyPence = onePoundRemainder / fiftyPence;
			int fiftyPenceRemainder = onePoundRemainder % fiftyPence;
			numbOftwentyPence = fiftyPenceRemainder / twentyPence;
			int twentyPenceRemainder = fiftyPenceRemainder % twentyPence;
			numbOftenPence = twentyPenceRemainder / tenPence;
			int tenPenceRemainder = twentyPenceRemainder % tenPence;
			System.out.println("Given " + Integer.toString(totPenniesIn) + " pennies and excluding the £2 coin, \n" + 
			"we can exchange for " + Integer.toString(numbOfOnePound) + " x £1 coin, \n" + 
			Integer.toString(numbOffiftyPence) + " x 50p coin, \n" + Integer.toString(numbOftwentyPence) + " x 20p coin and " 
			+ Integer.toString(numbOftenPence) + " x 10p coin, \n" 
			+ "with a remainder of " + tenPenceRemainder + "p.");
		}else if(selDenomIn == onePound) {
			numbOfTwoPounds = totPenniesIn / twoPounds;
			int twoPoundRemainder = totPenniesIn % twoPounds;
			numbOffiftyPence = twoPoundRemainder / fiftyPence;
			int fiftyPenceRemainder = twoPoundRemainder % fiftyPence;
			numbOftwentyPence = fiftyPenceRemainder / twentyPence;
			int twentyPenceRemainder = fiftyPenceRemainder % twentyPence;
			numbOftenPence = twentyPenceRemainder / tenPence;
			int tenPenceRemainder = twentyPenceRemainder % tenPence;
			System.out.println("Given " + Integer.toString(totPenniesIn) + " pennies and excluding the £1 coin, \n" + 
			"we can exchange for " + Integer.toString(numbOfTwoPounds) + " x £2 coin, \n" + 
			Integer.toString(numbOffiftyPence) + " x 50p coin, \n" + Integer.toString(numbOftwentyPence) 
			+ " x 20p coin and " + Integer.toString(numbOftenPence) + " x 10p coin, \n" + "with a remainder of " 
			+ Integer.toString(tenPenceRemainder) + "p.");
		}else if(selDenomIn == fiftyPence) {
			numbOfTwoPounds = totPenniesIn / twoPounds;
			int twoPoundRemainder = totPenniesIn % twoPounds;
			numbOfOnePound = twoPoundRemainder / onePound;
			int onePoundRemainder = twoPoundRemainder % onePound;
			numbOftwentyPence = onePoundRemainder / twentyPence;
			int twentyPenceRemainder = onePoundRemainder % twentyPence;
			numbOftenPence = twentyPenceRemainder / tenPence;
			int tenPenceRemainder = twentyPenceRemainder % tenPence;
			System.out.println("Given " + Integer.toString(totPenniesIn) + " pennies and excluding the 50p, \n" + 
			"we can exchange for " + Integer.toString(numbOfTwoPounds) + " x £2 coin, \n" + 
			Integer.toString(numbOfOnePound) + " x £1, \n" + Integer.toString(numbOftwentyPence) + " x 20p coin and " 
			+ Integer.toString(numbOftenPence) + " x 10p coin, \n" 
			+ "with a remainder of " + Integer.toString(tenPenceRemainder) + "p.");
		}else if(selDenomIn == twentyPence) {
			numbOfTwoPounds = totPenniesIn / twoPounds;
			int twoPoundRemainder = totPenniesIn % twoPounds;
			numbOfOnePound = twoPoundRemainder / onePound;
			int onePoundRemainder = twoPoundRemainder % onePound;
			numbOffiftyPence = onePoundRemainder / fiftyPence;
			int fiftyPenceRemainder = onePoundRemainder % fiftyPence;
			numbOftenPence = fiftyPenceRemainder / tenPence;
			int tenPenceRemainder = fiftyPenceRemainder % tenPence;
			System.out.println("Given " + Integer.toString(totPenniesIn) + " pennies and excluding the 20p, \n" + 
			"we can exchange for " + Integer.toString(numbOfTwoPounds) + " x £2 coin, \n" + 
			Integer.toString(numbOfOnePound) + " x £1, \n" + Integer.toString(numbOffiftyPence) + " x 50p coin and " 
			+ Integer.toString(numbOftenPence) + " x 10p coin, \n" + "with a remainder of " + Integer.toString(tenPenceRemainder) + "p.");
		}else if(selDenomIn == tenPence) {
			numbOfTwoPounds = totPenniesIn / twoPounds;
			int twoPoundRemainder = totPenniesIn % twoPounds;
			numbOfOnePound = twoPoundRemainder / onePound;
			int onePoundRemainder = twoPoundRemainder % onePound;
			numbOffiftyPence = onePoundRemainder / fiftyPence;
			int fiftyPenceRemainder = onePoundRemainder % fiftyPence;
			numbOftwentyPence = fiftyPenceRemainder / twentyPence;
			int twentyPenceRemainder = fiftyPenceRemainder % twentyPence;
			System.out.println("Given " + Integer.toString(totPenniesIn) + " pennies and excluding the 10p, " + 
			"we can exchange for " + Integer.toString(numbOfTwoPounds) + " x £2 coin, \n" + 
			Integer.toString(numbOfOnePound) + " x £1, \n" + Integer.toString(numbOffiftyPence) + " x 50p coin and \n" + 
			Integer.toString(numbOftwentyPence) + " x 20p coin, \n" 
			+ "with a remainder of " + Integer.toString(twentyPenceRemainder) + "p.");
		}else {
			System.out.println("Please enter the correct denomination");
		}
	}
	
	// Utility Function: convertToString(ArrayList<Integer> numbers). Convert an 
	// Integer ArrayList into a String ArrayList.
	public String convertToString(List<Integer> coinList2) {
        StringBuilder builder = new StringBuilder();
        // Append all Integers in StringBuilder to the StringBuilder.
        for (int number : coinList2) {
            builder.append(number);
            builder.append("p ");
        }
        // Remove last delimiter with setLength.
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
}

