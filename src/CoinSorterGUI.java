
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * ************************CoinSorter Class**********************
 * Description: This .java file contains an implementation of the CoinSorterGUI Class.
 * Purpose: It calculates the number of denominations of coins you can get from a specified number of coins.
 */

public class CoinSorterGUI extends Application {
	
	// Instantiation of the CoinSorter class and creation of the coinsorter object.
	CoinSorter coinsorter = new CoinSorter();
	
	// main method
	public static void main(String[] args) { 
		launch(args); 
	}
	 
	@Override
	public void start(Stage stage) throws Exception {
		
		// Add Text
		Text scenetitle = new Text("Coin Sorter Application");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
		
		
		// Add Labels
		Label appInstructionsLabel1 = new Label(
				"-- Instructions -- \n"
				+ " Please note that 100 pence is equal to £1 \n"
				+"[1.] Enter total number of coins to be exchanged (in pence) \n"
				+"[2.] Enter desired coin denomination from: [200, 100, 50, 20, 10] \n"
				+"** Enter Values Below **");
		
		Label appInstructionsLabel2 = new Label(
				"-- Main Menu -- \n"
				+"Select an option from below \n"
				+"[1.] Coin Calculator \n"
				+" ** Select to include a specific denomination **\n"
				+"[2.] Multiple Coin Calculator \n"
				+" ** Select to exclude a specific denomination **\n"
				+"[3.] Print Coin List \n"
				+"[4.] Re-Set Details \n"
				+"[5.] Display Program Configuration \n"
				+"[6.] Quit the program \n"
				);
		
		Label numbOfCoinsLabel = new Label();
		numbOfCoinsLabel.setText("Number of Coins");
		numbOfCoinsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		numbOfCoinsLabel.setTextFill(Color.RED);
		
		Label denomOfCoinsLabel = new Label("Coin Denomination");
		denomOfCoinsLabel.setText("Coin Denomination");
		denomOfCoinsLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		denomOfCoinsLabel.setTextFill(Color.RED);
		
		// Add Text Fields
		TextField numbOfCoinsTextField = new TextField();
		numbOfCoinsTextField.setMaxWidth(75);
		TextField denomOfCoinsTextField = new TextField();
		denomOfCoinsTextField.setMaxWidth(75);
		
		// Add Text Area
		TextArea displayTextArea1 = new TextArea();
		displayTextArea1.setEditable(false);
		displayTextArea1.setMinSize(450,70);
		displayTextArea1.setMaxSize(450,70);
		
		// Add Buttons
        Button buttonMainMenu1 = new Button();
        buttonMainMenu1.setText("Option 1");
        // Add Event Handler to Button
        buttonMainMenu1.setOnAction(e -> {
        	// Check that fields are not empty
        	if (numbOfCoinsTextField.getText().isEmpty() || denomOfCoinsTextField.getText().isEmpty()) {
        		displayTextArea1.setText("\"Number of Coins\" and \"Coin Denomination\" must be entered.");
			}else {
				// Validation of user input: Only accept coins between 0 and 10000
				int totVal = Integer.parseInt(numbOfCoinsTextField.getText());
				if((totVal < 0) || (totVal > 10000)) {
	    			displayTextArea1.setText("Enter a coin value between 0p and 10000p");
					totVal = Integer.parseInt(numbOfCoinsTextField.getText());
	        	}else {
	        		// Convert text input to doubles and set the total pennies and 
	    			// selected denomination of the coinCalulator method (in CoinSorter class).
	    			String totalPennies = Integer.toString(totVal);
	    			String selectDenom = denomOfCoinsTextField.getText();
	    			// use the coinCalculator method (in CoinSorter class)
	    			String result = coinCalculationGUI(totalPennies, selectDenom);
	    			displayTextArea1.setText(result);
	    			numbOfCoinsTextField.clear();
	    			denomOfCoinsTextField.clear();
	        	}
			}
        }		
		);
         
        Button buttonMainMenu2 = new Button();
        buttonMainMenu2.setText("Option 2");
        // Add Event Handler to Button
        buttonMainMenu2.setOnAction(e -> {
        	// Check that fields are not empty
        	if (numbOfCoinsTextField.getText().isEmpty() || denomOfCoinsTextField.getText().isEmpty()) {
        		displayTextArea1.setText("\"Number of Coins\" and \"Coin Denomination\" must be entered.");
			}else {
				// Validation of user input: Only accept coins between 0 and 10000
				int totVal = Integer.parseInt(numbOfCoinsTextField.getText());
				if((totVal < 0) || (totVal > 10000)) {
	        		displayTextArea1.setText("Enter a coin value between 0p and 10000p");
					totVal = Integer.parseInt(numbOfCoinsTextField.getText());
	        	}else {
	        		// Convert text input to doubles and set the total pennies and 
	    			// selected denomination of the coinCalulator method (in CoinSorter class).
	    			String totalPennies = Integer.toString(totVal);
	    			String selectDenom = denomOfCoinsTextField.getText();
	    			// use the coinCalculator method (in CoinSorter class)
	    			String result = multiCoinCalculatorGUI(totalPennies, selectDenom);
	    			displayTextArea1.setText(result);
	    			numbOfCoinsTextField.clear();
	    			denomOfCoinsTextField.clear();
	        	}
			}
        }		
		);
        
        Button buttonMainMenu3 = new Button();
        buttonMainMenu3.setText("Option 3");
        // Add Event Handler to Button
        buttonMainMenu3.setOnAction(e -> 
        {
			displayTextArea1.setText("The current coin denominations in circulation are: \n"
					+ printCoinListGUI());
        }
		);
         
        Button buttonMainMenu4 = new Button();
        buttonMainMenu4.setText("Option 4");
        // Add Event Handler to Button
        buttonMainMenu4.setOnAction(
        	new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					final Stage dialog = new Stage();
					// Add Text
					Text scenetitleSubMenu = new Text("Re-Set Details");
					scenetitleSubMenu.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
					
					// Add Label
					Label setCurrencyLabel = new Label();
					setCurrencyLabel.setText("Set Currency");
					setCurrencyLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
					setCurrencyLabel.setTextFill(Color.RED);
					
					Label setMinCoinLabel = new Label();
					setMinCoinLabel.setText("Set Minimum Coin Value");
					setMinCoinLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
					setMinCoinLabel.setTextFill(Color.RED);
					
					Label setMaxCoinLabel = new Label();
					setMaxCoinLabel.setText("Set Maximum Coin Value");
					setMaxCoinLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
					setMaxCoinLabel.setTextFill(Color.RED);
					
					Label appInstSubMenuLabel1 = new Label(
							"-- Sub Menu -- \n"
							+"Select an option from below \n"
							+"[1.] Confirm New Details \n"
							+"[2.] Return to main menu \n"
							);
					
					// Add Text Fields
					TextField setCurrencyTextField = new TextField();
					setCurrencyTextField.setMaxWidth(50);
					
					TextField setMinCoinTextField = new TextField();
					setMinCoinTextField.setMaxWidth(50);
					
					TextField setMaxCoinTextField = new TextField();
					setMaxCoinTextField.setMaxWidth(50);
					
					// Add Text Area
					TextArea displayTextArea2 = new TextArea();
					displayTextArea2.setEditable(false);
					displayTextArea2.setMinSize(320,70);
					displayTextArea2.setMaxSize(320,70);
					
					// Add Buttons
					Button buttonSubMenu1 = new Button();
					buttonSubMenu1.setText("Option 1");
					// Add Event Handler to Button
			        buttonSubMenu1.setOnAction(new EventHandler<ActionEvent>(){
		                 @Override
		                 public void handle(ActionEvent arg0) {
		                	// check that fields are not empty
		         			if (setCurrencyTextField.getText().isEmpty() || setMinCoinTextField.getText().isEmpty() 
		         					|| setMinCoinTextField.getText().isEmpty()) {
		         				displayTextArea2.setText("All fields for must be entered");
		         			}else {
		         				// convert text input to int and set Currency, Minimum Coin and Maximum Coin
		         				coinsorter.setCurrency(setCurrencyTextField.getText());
		         				coinsorter.setMinCoinIn(Integer.parseInt(setMinCoinTextField.getText()));
		         				coinsorter.setMaxCoinIn(Integer.parseInt(setMaxCoinTextField.getText()));
		         				setCurrencyTextField.clear();
		         				setMinCoinTextField.clear();
		         				setMaxCoinTextField.clear();
		         				displayTextArea2.setText(displayProgramConfigsGUI());
		         			}
		                 }
		             });
			        
			        Button buttonSubMenu2 = new Button();
			        buttonSubMenu2.setText("Option 2");
			        // Add Event Handler to Button
			        buttonSubMenu2.setOnAction(new EventHandler<ActionEvent>(){
		                 @Override
		                 public void handle(ActionEvent arg0) {
		                     dialog.close();
		                 }
		             });
			        
					
					// Create and Set properties of HBox
			        HBox inputCompSubMenu1 = new HBox(5);
			        inputCompSubMenu1.setAlignment(Pos.BASELINE_LEFT);
			        inputCompSubMenu1.getChildren().addAll( 
			        		setCurrencyLabel, setCurrencyTextField
	        		);
			        inputCompSubMenu1.setSpacing(145);
			        
			        HBox inputCompSubMenu2 = new HBox(5);
			        inputCompSubMenu2.setAlignment(Pos.BASELINE_LEFT);
			        inputCompSubMenu2.getChildren().addAll( 
			        		setMinCoinLabel, setMinCoinTextField
	        		);
			        inputCompSubMenu2.setSpacing(50);
			        
			        HBox inputCompSubMenu3 = new HBox(5);
			        inputCompSubMenu3.setAlignment(Pos.BASELINE_LEFT);
			        inputCompSubMenu3.getChildren().addAll( 
			        		setMaxCoinLabel, setMaxCoinTextField
	        		);
			        inputCompSubMenu3.setSpacing(45);
			        
			        HBox inputCompSubMenu4 = new HBox(5);
			        inputCompSubMenu4.setAlignment(Pos.CENTER);
			        inputCompSubMenu4.getChildren().addAll( 
			        		buttonSubMenu1, buttonSubMenu2
	        		);
			        inputCompSubMenu4.setSpacing(15);
			        
			        HBox inputCompSubMenu5 = new HBox(5);
			        inputCompSubMenu5.setAlignment(Pos.CENTER);
			        inputCompSubMenu5.getChildren().addAll( 
			        		displayTextArea2
	        		);
			        inputCompSubMenu5.setSpacing(15);
			        
	                // Add and set properties of VBox
	                VBox dialogVbox = new VBox(20);
	                dialogVbox.getChildren().addAll(scenetitleSubMenu, inputCompSubMenu1, 
	                		inputCompSubMenu2, inputCompSubMenu3, appInstSubMenuLabel1, 
	                		inputCompSubMenu4, inputCompSubMenu5);
	                dialogVbox.setAlignment(Pos.CENTER);
	                
	                // Add Scene and set properties
	                Scene dialogScene = new Scene(dialogVbox, 360, 500);
	                dialog.initModality(Modality.WINDOW_MODAL);
	                dialog.initOwner(stage);
	                dialog.setTitle("Re-Set Details Sub-Menu");
	                dialog.setScene(dialogScene);
	                dialog.show();
				}
        	});
        
        Button buttonMainMenu5 = new Button();
        buttonMainMenu5.setText("Option 5");
        // Add Event Handler to Button
        buttonMainMenu5.setOnAction(e ->
		{
			displayTextArea1.setText(displayProgramConfigsGUI());		
        }	
		);
        
        Button buttonMainMenu6 = new Button();
        buttonMainMenu6.setText("Option 6");
        // Add Event Handler to Button
        buttonMainMenu6.setOnAction(e -> {
        	stage.hide();
        }
        );
        
        // Create and Set properties of HBox
        HBox inputComponents1 = new HBox(5);
        inputComponents1.setAlignment(Pos.CENTER);
        inputComponents1.getChildren().addAll( 
        		numbOfCoinsLabel, numbOfCoinsTextField
        		);
        
        HBox inputComponents2 = new HBox(5);
        inputComponents2.setAlignment(Pos.CENTER);
        inputComponents2.getChildren().addAll( 
        		denomOfCoinsLabel,denomOfCoinsTextField
        		);
        
        HBox inputComponents3 = new HBox(5);
        inputComponents3.setAlignment(Pos.CENTER);
        inputComponents3.getChildren().addAll( 
        		buttonMainMenu1, buttonMainMenu2, buttonMainMenu3,
        		buttonMainMenu4, buttonMainMenu5, buttonMainMenu6
        		);
        inputComponents3.setSpacing(15);
        
        // Create and Set properties for VBox
        VBox root = new VBox(20);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(scenetitle, appInstructionsLabel1, inputComponents1, 
				inputComponents2, appInstructionsLabel2,inputComponents3);
		root.getChildren().add(displayTextArea1);
		
		// Create and Set properties of Scene
		Scene scene = new Scene(root, 500, 600);
		
		// Create and Set the Properties of the Stage
		stage.setTitle("Coin Sorter Application - Main Menu");
		stage.setScene(scene);
		stage.show();
	}
	
	// displayProgramConfigsGUI() method: This method returns programs configuration as a String.
	public String displayProgramConfigsGUI() {
		String currentCurrency = coinsorter.getCurrency();
		String currentMinimum = Integer.toString(coinsorter.getMinCoinIn());
		String currentMaximum = Integer.toString(coinsorter.getMaxCoinIn());
		return " Current currency is: " + currentCurrency + " \n" 
				+ " Current minimum (in pence): " + currentMinimum + " \n"
				+ " Current maximum (in pence): " + currentMaximum + " \n";
	}
	
	// printCoinList() method: This method should print the contents of the coin list.
	public String printCoinListGUI() {
		// Create an ArrayList
    	List<Integer> coinList = new ArrayList<>();
		coinList.add(200);
    	coinList.add(100);
    	coinList.add(50);
    	coinList.add(20);
    	coinList.add(10);
	
		// Call conversion method.
        String result = coinsorter.convertToString(coinList);
		return result;
	}

	// coinCalculationGUI() method:This method should take two values; the total value to exchange 
	// and a coin type, in order to calculate and return the maximum number of coins of the input 
	// coin type that can be exchanged, in addition to the remainder as a String.
	private String coinCalculationGUI(String totalPenniesIn, String selectDenomIn) {
		int totalPen = Integer.parseInt(totalPenniesIn);
		int selectDom = Integer.parseInt(selectDenomIn);
		final int twoPounds = 200;
		final int onePound = 100;
		final int fiftyPence = 50;
		final int twentyPence = 20;
		final int tenPence = 10;
		int numbOfTwoPounds, numbOfOnePound, numbOffiftyPence, 
			numbOftwentyPence, numbOftenPence; 
		int penceLeft;
		String result;
		
		if(selectDom == twoPounds) {
			numbOfTwoPounds = totalPen / twoPounds;
			penceLeft = totalPen % twoPounds;
			result = "A total of " + Integer.toString(numbOfTwoPounds) + " x " + 
					"£2 coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p";
			return result;
		}else if(selectDom == onePound) {
			numbOfOnePound = totalPen / onePound;
			penceLeft = totalPen % onePound;
			result = "A total of " + Integer.toString(numbOfOnePound) + " x " + 
					"£1 coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p";
			return result;
		}else if(selectDom == fiftyPence) {
			numbOffiftyPence = totalPen / fiftyPence;
			penceLeft = totalPen % fiftyPence;
			result = "A total of " + Integer.toString(numbOffiftyPence) + " x " + 
					"50p coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p";
			return result;
		}else if(selectDom == twentyPence) {
			numbOftwentyPence = totalPen / twentyPence;
			penceLeft = totalPen % twentyPence;
			result = "A total of " + Integer.toString(numbOftwentyPence) + " x " + 
					"20p coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p";
			return result;
		}else if(selectDom == tenPence) {
			numbOftenPence = totalPen / tenPence;
			penceLeft = totalPen % tenPence;
			result = "A total of " + Integer.toString(numbOftenPence) + " x " + 
					"10p coin can be exchanged, with a remainder of " + Integer.toString(penceLeft) + "p";
			return result;
		}
	
	String error = "Please re-enter the correct denomination";
	return error;
	}
	
	// multiCoinCalculatorGUI() method: This method should take two values; the total value to exchange and a coin type to
	// exclude, in order to calculate and return the maximum number of coins of the input coin type that can be exchanged 
	// while excluding the input coin type, in addition to the remainder as a String.
	private String multiCoinCalculatorGUI(String totalPenniesIn, String selectDenomIn) {
		int totalPen = Integer.parseInt(totalPenniesIn);
		int selectDom = Integer.parseInt(selectDenomIn);
		final int twoPounds = 200;
		final int onePound = 100;
		final int fiftyPence = 50;
		final int twentyPence = 20;
		final int tenPence = 10;
		int numbOfTwoPounds, numbOfOnePound, numbOffiftyPence, 
			numbOftwentyPence, numbOftenPence; 
		String result;
		
		if(selectDom == twoPounds) {
			numbOfOnePound = totalPen / onePound;
			int onePoundRemainder = totalPen % onePound;
			numbOffiftyPence = onePoundRemainder / fiftyPence;
			int fiftyPenceRemainder = onePoundRemainder % fiftyPence;
			numbOftwentyPence = fiftyPenceRemainder / twentyPence;
			int twentyPenceRemainder = fiftyPenceRemainder % twentyPence;
			numbOftenPence = twentyPenceRemainder / tenPence;
			int tenPenceRemainder = twentyPenceRemainder % tenPence;
			result = "Given " + Integer.toString(totalPen) + " pennies and excluding the £2 coin, \n" + 
					"we can exchange for " + Integer.toString(numbOfOnePound) + " x £1 coin, " + 
					Integer.toString(numbOffiftyPence) + " x 50p coin, " + Integer.toString(numbOftwentyPence) + " x 20p coin and " 
					+ Integer.toString(numbOftenPence) + " x 10p coin, \n" 
					+ "with a remainder of " + tenPenceRemainder + "p.";
			return result;
		}else if(selectDom == onePound) {
			numbOfTwoPounds = totalPen / twoPounds;
			int twoPoundRemainder = totalPen % twoPounds;
			numbOffiftyPence = twoPoundRemainder / fiftyPence;
			int fiftyPenceRemainder = twoPoundRemainder % fiftyPence;
			numbOftwentyPence = fiftyPenceRemainder / twentyPence;
			int twentyPenceRemainder = fiftyPenceRemainder % twentyPence;
			numbOftenPence = twentyPenceRemainder / tenPence;
			int tenPenceRemainder = twentyPenceRemainder % tenPence;
			result = "Given " + Integer.toString(totalPen) + " pennies and excluding the £1 coin, \n" + 
					"we can exchange for " + Integer.toString(numbOfTwoPounds) + " x £2 coin, " + 
					Integer.toString(numbOffiftyPence) + " x 50p coin, " + Integer.toString(numbOftwentyPence) 
					+ " x 20p coin and " + Integer.toString(numbOftenPence) + " x 10p coin, \n" + "with a remainder of " 
					+ Integer.toString(tenPenceRemainder) + "p.";
			return result;
		}else if(selectDom == fiftyPence) {
			numbOfTwoPounds = totalPen / twoPounds;
			int twoPoundRemainder = totalPen % twoPounds;
			numbOfOnePound = twoPoundRemainder / onePound;
			int onePoundRemainder = twoPoundRemainder % onePound;
			numbOftwentyPence = onePoundRemainder / twentyPence;
			int twentyPenceRemainder = onePoundRemainder % twentyPence;
			numbOftenPence = twentyPenceRemainder / tenPence;
			int tenPenceRemainder = twentyPenceRemainder % tenPence;
			result = "Given " + Integer.toString(totalPen) + " pennies and excluding the 50p, \n" + 
					"we can exchange for " + Integer.toString(numbOfTwoPounds) + " x £2 coin, " + 
					Integer.toString(numbOfOnePound) + " x £1, " + Integer.toString(numbOftwentyPence) + " x 20p coin and " 
					+ Integer.toString(numbOftenPence) + " x 10p coin, \n" 
					+ "with a remainder of " + Integer.toString(tenPenceRemainder) + "p.";
			return result;
		}else if(selectDom == twentyPence) {
			numbOfTwoPounds = totalPen / twoPounds;
			int twoPoundRemainder = totalPen % twoPounds;
			numbOfOnePound = twoPoundRemainder / onePound;
			int onePoundRemainder = twoPoundRemainder % onePound;
			numbOffiftyPence = onePoundRemainder / fiftyPence;
			int fiftyPenceRemainder = onePoundRemainder % fiftyPence;
			numbOftenPence = fiftyPenceRemainder / tenPence;
			int tenPenceRemainder = fiftyPenceRemainder % tenPence;
			result = "Given " + Integer.toString(totalPen) + " pennies and excluding the 20p, \n" + 
					"we can exchange for " + Integer.toString(numbOfTwoPounds) + " x £2 coin, " + 
					Integer.toString(numbOfOnePound) + " x £1, " + Integer.toString(numbOffiftyPence) + " x 50p coin and " 
					+ Integer.toString(numbOftenPence) + " x 10p coin, \n" + "with a remainder of " + Integer.toString(tenPenceRemainder) + "p.";
			return result;
		}else if(selectDom == tenPence) {
			numbOfTwoPounds = totalPen / twoPounds;
			int twoPoundRemainder = totalPen % twoPounds;
			numbOfOnePound = twoPoundRemainder / onePound;
			int onePoundRemainder = twoPoundRemainder % onePound;
			numbOffiftyPence = onePoundRemainder / fiftyPence;
			int fiftyPenceRemainder = onePoundRemainder % fiftyPence;
			numbOftwentyPence = fiftyPenceRemainder / twentyPence;
			int twentyPenceRemainder = fiftyPenceRemainder % twentyPence;
			result = "Given " + Integer.toString(totalPen) + " pennies and excluding the 10p, \n" + 
					"we can exchange for " + Integer.toString(numbOfTwoPounds) + " x £2 coin, " + 
					Integer.toString(numbOfOnePound) + " x £1, " + Integer.toString(numbOffiftyPence) + " x 50p coin and " + 
					Integer.toString(numbOftwentyPence) + " x 20p coin, \n" 
					+ "with a remainder of " + Integer.toString(twentyPenceRemainder) + "p.";
			return result;
		}
		
		String error = "Please re-enter the correct denomination";
		return error;
	}

}
