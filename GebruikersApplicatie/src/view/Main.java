package view;

import java.io.IOException;
import java.util.ArrayList;

import controller.ApplicationCommon;
import controller.ControllerData;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jserial.jSerialcomm;
import model.Cluster;
import model.Device;
import model.GebruikersApplicatie;
import persistance.SerializeHandler;
import proxy.ProxyOnsDomein;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	public static String FXMLLocation = "/view/";
	private static Stage stage = new Stage();

	public static Stage getStage() {
		return stage;
	}

	private static GebruikersApplicatie gebruikersApplicatie = new GebruikersApplicatie();

	public void start(Stage primaryStage) {

		ControllerData.init();

		int horizontalresolution = 800;
		int verticalresolution = 600;

		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		} catch (IOException e1) {
		 	e1.printStackTrace();
		}
		Scene scene = new Scene(root, horizontalresolution, verticalresolution);
		primaryStage.setTitle("mijnD0Mein  >> ");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage = primaryStage;

		primaryStage.show();

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {

				ApplicationCommon.exit();

			}
		});

	}

	public static void main(String[] args) throws InterruptedException {
		launch(args);

	}

	public static GebruikersApplicatie getGa() {
		return gebruikersApplicatie;
	}

	public static void setGa(GebruikersApplicatie ga) {
		Main.gebruikersApplicatie = ga;
	}

}
