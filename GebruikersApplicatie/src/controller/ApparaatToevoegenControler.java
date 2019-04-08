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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Device;
import model.DeviceFactory;
import model.DeviceTypes;
import view.Main;

public class ApparaatToevoegenControler implements Initializable {

	protected ArrayList<Device> deviceList = Main.deviceList;
	private DeviceFactory devicefactory = new DeviceFactory();

	@FXML
	private GridPane rootPane;
	@FXML
	private TextField deviceName;
	@FXML
	private TextField devicePort;
	@FXML
	private ComboBox<String> comboBox;
	@FXML
	private Button saveButton;

	@FXML
	protected void save(ActionEvent event) throws IOException {

		String selectedType = comboBox.getValue();
		String name = deviceName.textProperty().getValue();
		int port = Integer.parseInt(devicePort.textProperty().getValue());

		Main.deviceList.add(devicefactory.getDevice(selectedType, name, port));
		GridPane pane = FXMLLoader.load(getClass().getResource(Main.FXMLLocation + "ApparatenView.fxml"));
		rootPane.getChildren().setAll(pane);

	}

	@FXML
	protected void back(ActionEvent event) throws IOException {

		GridPane pane = FXMLLoader.load(getClass().getResource(Main.FXMLLocation + "ApparatenView.fxml"));
		rootPane.getChildren().setAll(pane);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		comboBox.getItems().setAll(
				DeviceTypes.READONLY.getDescription(), 
				DeviceTypes.SWITCHABLE.getDescription(),
				DeviceTypes.DIMMABLE.getDescription());
		
		comboBox.getSelectionModel().select(0);
		comboBox.toFront();
		deviceName.toFront();
		devicePort.toFront();
		saveButton.setDisable(checkForContent());
		
		deviceName.requestFocus();
		
		deviceName.textProperty().addListener((observable, oldValue, newValue) -> {
			saveButton.setDisable(!checkForContent());
		    
		});
		
		devicePort.textProperty().addListener((observable, oldValue, newValue) -> {
			saveButton.setDisable(!checkForContent());
		    
		});

	}

	public boolean checkForContent() {

		if (deviceName.getLength() >= 0 && devicePort.getLength() >= 0) {
			
			return true;

		}

		return false;
	}

}
