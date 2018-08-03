package assignment1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.math.*;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.*;

public class tab1Controller {
	//Buttons to determine which interest value to calculate
	@FXML
	private Button futureValue;
	
	@FXML
	private Button presentValue;
	@FXML
	Text presentResult;
	@FXML
	Text futureResult;
	@FXML 
	TextField amount_Invested;
	@FXML
	TextField annualInterest;
	@FXML
	TextField numberOf;
	@FXML
	Text results;
	//Variables for calculations

	double intRate, amountCal, futureAmount, year;
	

	@FXML
	private MenuItem close;
	
	@FXML
	private Parent root;
	
	@FXML
	private MenuItem about;
	
	@FXML
	private Button mainMenu;
	
	
	//Method for calculation
	
	@FXML
	void calculatePresentValue(ActionEvent event) throws IOException{
		//Present Value = Future Value/(1+Interest_Rate)^
		//The PV is £1,000 in 10 years at an interest rate of 4% is £1,000/(1+0.04)^10
		futureAmount = Double.parseDouble(amount_Invested.getText());
		intRate = Double.parseDouble(annualInterest.getText());
		year = Double.parseDouble(numberOf.getText());
		double calculate =  Math.pow(1+(intRate/100), year);
		double result = futureAmount / calculate;
		double roundResult = Math.round(result * 100)/100;
		presentResult.setText(" £" + roundResult);

	}
	
	@FXML
	void calculateFutureValue(ActionEvent event){
		try{
		amountCal = Double.parseDouble(amount_Invested.getText());
		intRate = Double.parseDouble(annualInterest.getText());
		year = Double.parseDouble(numberOf.getText());
		double calculate =  Math.pow(1+(intRate/100), year);
		double result = amountCal * calculate;
		double roundResult = Math.round(result * 100)/100;
		futureResult.setText(" £" + roundResult);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	@FXML
	void clickClose(ActionEvent event){
		Platform.exit();
		System.exit(0);
	}
	@FXML
	void goBack() throws IOException{
		BorderPane mainMenuView = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene mainScene = new Scene(mainMenuView);
		Stage primaryStage = (Stage)  mainMenu.getScene().getWindow();
		primaryStage.setScene(mainScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
