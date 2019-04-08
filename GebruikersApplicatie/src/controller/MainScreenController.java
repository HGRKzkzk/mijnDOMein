package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Cluster;
import model.Device;
import view.Main;
 

public class MainScreenController implements Initializable  {
	
	protected ArrayList<Device> deviceList = Main.deviceList;
	protected ArrayList<Cluster> clusterList = Main.clusterList;
	
 	@FXML private GridPane rootPane;
	@FXML private Button devices;
	@FXML private Button clusters;
	@FXML private Label welcomeUser;
 
	


    
    
    @FXML protected void apparatenKnop(ActionEvent event) throws IOException {
    	GridPane pane = FXMLLoader.load(getClass().getResource(Main.FXMLLocation + "ApparatenView.fxml"));
    	rootPane.getChildren().setAll(pane);
        
    }
    
    @FXML protected void clusterKnop(ActionEvent event) throws IOException {
    	GridPane pane = FXMLLoader.load(getClass().getResource(Main.FXMLLocation + "ClusterView.fxml"));
    	rootPane.getChildren().setAll(pane);
        
    }

    
    
    
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Main.getStage()
		.setTitle(ScreenNames.Prefix.getDescription());
		
		welcomeUser.setVisible(false);
		String username = System.getProperty("user.name");
		welcomeUser.setText(welcomeUser.getText() +  username + ".");
		devices.setText("Apparaten (" + deviceList.size() + ")");
		clusters.setText("Clusters (" + clusterList.size() + ")");
		
		
	
		
		
	}


}
