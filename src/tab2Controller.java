package assignment1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tab2Controller{


	
	@FXML
	private Button mainMenu;
	
	@FXML
	private MenuItem close;

	
    @FXML 
    private Button next;

	
	@FXML
	private ComboBox<String> ratios;
	
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		ObservableList<String> comboList = FXCollections.observableArrayList(
//				"Current Ratio",
//				"Working Capital Ratio",
//				"Debt to Equity Ratio",
//				"Gross Profit Margin ratio"
//				);
//		
//		ratios.setItems(comboList);
//		System.out.println(comboList);
//		System.out.println(ratios.getItems());
//	}
	
	@FXML
	void goToRatio(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Ratios.fxml"));
		Scene crScene = new Scene(root);
		Stage stage =  (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(crScene);
		stage.setResizable(false);
		stage.show();

	}
	
//	@FXML
//	void ratiosCalculations(ActionEvent Event) throws IOException{
//		Parent root1 = FXMLLoader.load(getClass().getResource("/currentRatio.fxml"));
//		Scene crScene = new Scene(root1);
//		Stage stageCr =  (Stage) ratios.getScene().getWindow();
//		stageCr.setScene(crScene);
//		stageCr.setResizable(false);
//		stageCr.show();
//	}
	
		//Method for returning to the main page.
	@FXML
	void goBack() throws IOException{
		BorderPane mainMenuView = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene mainScene = new Scene(mainMenuView);
		Stage primaryStage = (Stage) mainMenu.getScene().getWindow();
		primaryStage.setScene(mainScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	//Method for closing the application.
	@FXML
	void clickClose(ActionEvent event){
		try{
		Platform.exit();
		System.exit(0);
		}catch(Exception e){
			e.getMessage();
		}
	}
}
