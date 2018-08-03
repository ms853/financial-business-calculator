package assignment1;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.EventObject;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RatioController implements Initializable {

	
	@FXML
	private ComboBox<String> ratios;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<String> comboList = FXCollections.observableArrayList(
				"Current Ratio",
				"Working Capital Ratio",
				"Debt to Equity Ratio",
				"Gross Profit Margin ratio"
				);
		
		ratios.setItems(comboList);	
	}
	
  @FXML private Button confirm;
  @FXML private Button calculate;
  @FXML private Button main_menu;
  @FXML private MenuItem close;
  @FXML private MenuItem about;

	//
	//Text variables for modifications
	@FXML private Text input1; 
	@FXML private Text input2;
	
	//Below are the different variables used to perform the ratio calculations
	@FXML private Text result;
	
	//@FXML private Button calculateCurrentRatio;
	@FXML private TextField textField1;
	@FXML private TextField textField2;
	//@FXML private Text currentResults;
	

	//Methods for calculating the ratios: 
	
		@FXML
		void modifyRatios(ActionEvent event) throws IOException{
			if(ratios.getValue().contentEquals("Current Ratio") && event.getSource() == confirm){
				input1.setText("Current Assests");
				input2.setText("Current Liabilities");
			} 
			if(ratios.getValue().contentEquals("Working Capital Ratio") && event.getSource() == confirm){
				input1.setText("Current Assests");
				input2.setText("Current Liabilities");
			}
			if(ratios.getValue().contentEquals("Debt to Equity Ratio") && event.getSource() == confirm){
				input1.setText("Total Debt");
				input2.setText("Total Equity");
			}
			if(ratios.getValue().contentEquals("Gross Profit Margin ratio") && event.getSource() == confirm){
				input1.setText("Gross Profit");
				input2.setText("Revenue");
			}else{
				System.out.println("Nothing Selected!");
			}
		}
		
		//This method checks if non-numeric values such as text or characters have been entered into the text boxes. 
		
		public static boolean isNumeric(String str) throws ArrayIndexOutOfBoundsException{
		        boolean non_numeric = true;
		        
		        for(int i=0; i<str.length(); i++){
		            if(Character.isDigit(str.charAt(i))){
		            }else{
		                return false;
		            }
		        }
		        return non_numeric;
		    }
		
		@FXML
		void calculateRatios(ActionEvent Event)throws IOException{
			
			//Here I am using I have instantiated an object that will format the result of the calculations to two decimal places.
			 DecimalFormat df = new DecimalFormat("#0.00");  
			 
			 //Below I have created boolean variables that will check whether the Text fields are empty before any calculations take place.
		        boolean textBoxEmpty = textField1.getText().isEmpty();   
		        boolean textBox2Empty = textField2.getText().isEmpty();   
		         //This part of the method invokes  an alert only if the text fields are empty. 
		        if(textBoxEmpty || textBox2Empty){
		            Alert alert = new Alert(AlertType.WARNING);
		            alert.setTitle("Warning Dialog");
		            alert.setHeaderText("Missing Input");
		            alert.setContentText("Please, provide suitable inputs to empty text fields.");
		            alert.showAndWait();
		        }else{
		            if(isNumeric(textField1.getText()) && isNumeric(textField2.getText())){
		                double inputOne = Integer.parseInt(textField1.getText());   
		                double inputTwo = Integer.parseInt(textField2.getText());
		                switch(ratios.getValue()){
		                case "Current Ratio":
		                    result.setText("Value: " + df.format(inputOne/inputTwo)+" (%)");
		                    break;
		                case "Working Capital Ratio":
		                    result.setText("Value: £" + df.format(inputOne-inputTwo));
		                    break;
		                case "Debt to Equity Ratio":
		                    result.setText("Value: " + df.format(inputOne/inputTwo) +" (%)");
		                    break;
		                case  "Gross Profit Margin ratio":
		                    result.setText("Value: " + df.format(inputOne/inputTwo)+" (%)");
		                    break;
		                }
		                
		            }else{  //This alert message is only invoked if non numerical values are inputed.
		                Alert alert = new Alert(AlertType.WARNING);
		                alert.setTitle("Warning Dialog");
		                alert.setHeaderText("Input Error");
		                alert.setContentText("Please only enter numerical values as inputs.");
		                alert.showAndWait();
		            }
		        }
		}
	
		
		@FXML
		void clickClose(ActionEvent event){
			try{
			Platform.exit();
			System.exit(0);
			}catch(Exception e){
				e.getMessage();
			}
		}
		//Method for returning to main menu!
		@FXML
		void toMainMenu(ActionEvent event)throws IOException{
			BorderPane main = FXMLLoader.load(getClass().getResource("MainView.fxml"));
			Scene sceneMain = new Scene(main);
			Stage stage1 =  (Stage) main_menu.getScene().getWindow();
			stage1.setScene(sceneMain);
			stage1.setResizable(false);
			stage1.show();
		}
		
		@FXML
		void aboutApp(ActionEvent event)throws IOException{
		BorderPane help = FXMLLoader.load(getClass().getResource("MainHelp.fxml"));	
		Scene mainHelp = new Scene(help);
		Stage myStage = (Stage) ((Stage) event.getSource()).getScene().getWindow();
	    myStage.setResizable(false);
	    myStage.setScene(mainHelp);
	    myStage.show();
		}
}
