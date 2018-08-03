package assignment1;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class mainController {
	
	@FXML
	private Button tab1, tab2;
	
	@FXML
	private MenuItem about;
	
	@FXML
	private MenuItem close;
	
	//When user presses the menu item 'about', they will see a help page which will contain description about the software (for HCI).
	@FXML
	void onClickAbout(ActionEvent event) throws IOException{
		BorderPane aboutPage;//
	}
	
	@FXML
	 void onTab1Clicked(ActionEvent event) throws IOException{
		
		BorderPane tab1Page = FXMLLoader.load(getClass().getResource("Tab1.fxml"));
    	Scene tab1View = new Scene(tab1Page);
    	Stage secondaryStage = (Stage) tab1.getScene().getWindow();
    	secondaryStage.setScene(tab1View);
    	secondaryStage.setResizable(false);
    	secondaryStage.show();

	}
	
	@FXML
	 void onTab2Clicked(ActionEvent event) throws IOException{
		
		BorderPane tab2Page = FXMLLoader.load(getClass().getResource("Tab2.fxml"));
    	Scene tab2View = new Scene(tab2Page);
    	Stage secondaryStage = (Stage) tab2.getScene().getWindow();
    	secondaryStage.setScene(tab2View);
    	secondaryStage.setResizable(false);
    	secondaryStage.show();
	}
	
	@FXML
	void clickClose(ActionEvent event) throws IOException{
		Platform.exit();
		System.exit(0);
	}

}
