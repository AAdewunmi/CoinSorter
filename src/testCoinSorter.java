
import java.util.Scanner;
/**
 * ************************testCoinSorter Class**********************
 * Description: This .java file contains an implementation of the testCoinSorter Class.
 * Purpose: A class which will test the CoinSorter class.
 */

public class testCoinSorter {
		
	public static void main(String[] args) {
		// Instance variables
		int selectMainMenu;
		int selectSubMenu;
		
		// Instantiation of the CoinSorter class and creation of the coinsorter object.
		CoinSorter coinsorter = new CoinSorter();
		
		// Textual menu
		do {
			// Main menu 
			System.out.println();
			System.out.println("*** Coin Sorter - Main Menu ***\n" +
					"1 - Coin calculator\n" +
					"2 - Multiple coin calculator\n" +
					"3 - Print coin list\n" +
					"4 - Set details\n" +
					"5 - Display program configurations\n" +
					"6 - Quit the program\n");
			System.out.println();
			Scanner scannerMainMenu = new Scanner(System.in);
			selectMainMenu = scannerMainMenu.nextInt();
			switch (selectMainMenu) {
			// Option 1: Coin calculator
			case 1:
				System.out.println("1 - Coin calculator"); 
				int totalPence;
				int selectedDenom;	
				System.out.println("Enter total number of pence: ");
				Scanner scannerOption1Main = new Scanner(System.in);
				totalPence = scannerOption1Main.nextInt();
				// Validation of user input: Only accept coins between 0 and 10000
				while ((totalPence < 0) || (totalPence > 10000)) {
					System.out.println("Enter a coin value between 0p and 10000p");
					totalPence = scannerOption1Main.nextInt();
				}
				System.out.println("Enter a denomination (200,100,50,20,10): ");
		        selectedDenom = scannerOption1Main.nextInt();
				coinsorter.coinCalculator(totalPence, selectedDenom);
				System.out.println();
				break;
			// Option 2: Multiple coin calculator
			case 2:
				System.out.println("2 - Multiple coin calculator");
				int totalPence1;
				int selectedDenom1;
				System.out.println("Enter total number of pence: ");
				Scanner scannerOption2Main = new Scanner(System.in);
				totalPence1 = scannerOption2Main.nextInt();
				// Validation of user input: Only accept coins between 0 and 10000
				while ((totalPence1 < 0) || (totalPence1 > 10000)) {
					System.out.println("Enter a coin value between 0p and 10000p");
					totalPence1 = scannerOption2Main.nextInt();
				}
				System.out.println("Enter a denomination to exclude \n (200,100,50,20,10): ");
		        selectedDenom1 = scannerOption2Main.nextInt();
				coinsorter.multiCoinCalculator(totalPence1, selectedDenom1);
				System.out.println();
				break;
			// Option 3: Print coin list
			case 3:
				System.out.println();
				System.out.println("3 - Print coin list\n");
				coinsorter.printCoinList();
				System.out.println();
				break;
			case 4:
				System.out.println("4 - Set details");
				        // Sub Menu
						do {
							System.out.println("*** Set Details Sub-Menu ***\n" +
									"1 - Set currency\n" +
									"2 - Set minimum coin input value\n" +
									"3 - Set maximum coin input value\n" +
									"4 - Return to main menu\n");
							Scanner scannerSumMenu = new Scanner(System.in);
							selectSubMenu = scannerSumMenu.nextInt();
							switch (selectSubMenu) {
							// Option 1: Set Currency
							case 1:
								System.out.println("1 - Set currency");
								Scanner scannerOption1SubMenu = new Scanner(System.in);
								System.out.println("Enter new currency: ");
								String currencyIn = scannerOption1SubMenu.next();
								coinsorter.setCurrency(currencyIn);
								System.out.println("New currency set.");
								break;
							// Option 2: Set minimum coin input value
							case 2:
								System.out.println("2 - Set minimum coin input value");
								Scanner scannerOption2SubMenu = new Scanner(System.in);
								System.out.println("Enter minimum coin input value: ");
								int minCoinIn = scannerOption2SubMenu.nextInt();
								// Validation of user input: Only accept coins between 0 and 10000
								while ((minCoinIn < 0) || (minCoinIn > 10000)) {
									System.out.println("Enter a coin value between 0p and 10000p");
									minCoinIn = scannerOption2SubMenu.nextInt();
								}
								coinsorter.setMinCoinIn(minCoinIn);
								System.out.println("New minimum coin input value set.");
								break;	
							// Option 3: Set maximum coin input value
							case 3:
								System.out.println("3 - Set maximum coin input value");
								Scanner scannerOption3SubMenu = new Scanner(System.in);
								System.out.println("Enter maximum coin input value: ");
								int maxCoinIn = scannerOption3SubMenu.nextInt();
								// Validation of user input: Only accept coins between 0 and 10000
								while ((maxCoinIn < 0) || (maxCoinIn > 10000)) {
									System.out.println("Enter a coin value between 0p and 10000p");
									maxCoinIn = scannerOption3SubMenu.nextInt();
								}
								coinsorter.setMaxCoinIn(maxCoinIn);
								System.out.println("New maximum coin input value set.");
								break;
							// Option 4: Return to main menu
							case 4:
								System.out.println("4 - Return to main menu");
								break;
							default: System.out.println("Please select a number between 1 - 4");
							}
							scannerSumMenu.close();
						} while (selectSubMenu != 4);
			// Option 5: Display program configurations
			case 5:
				System.out.println();
				System.out.println("5 - Display program configurations\n");
				coinsorter.displayProgramConfigs();
				System.out.println();
				break;
			// Option 6: Quit the program
			case 6:
				System.out.println("6 - Quit the program\n");
				System.out.println("Goodbye!!!");
				break;
			default: System.out.println("Please select a number between 1 - 6");
			     }
			scannerMainMenu.close();
		} while (selectMainMenu != 6);
	}
}
