package view;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Cluster;
import model.Device;
import persistance.SerializeHandler;
import proxy.ProxyOnsDomein;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	public static String FXMLLocation = "/view/";
	SerializeHandler SerializeHandler = new SerializeHandler();

	public static ArrayList<Device> deviceList = new ArrayList<Device>();
	public static ArrayList<Cluster> clusterList = new ArrayList<Cluster>();
	public static ProxyOnsDomein ProxyOnsDomein = new ProxyOnsDomein();

	public void start(Stage primaryStage) throws IOException, ClassNotFoundException, InterruptedException {

		deviceList = SerializeHandler.loadDeviceList();
		clusterList = SerializeHandler.loadClusterList();

		Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("mijnD0Mein");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.show();

		System.out.println(java.net.InetAddress.getLocalHost().getHostAddress());
		ProxyOnsDomein.connectClientToServer("12");

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				SerializeHandler.saveAsSerializedData();
				ProxyOnsDomein.closeConnection(); // is eigenlijk niet nodig, just to be sure.
				Platform.exit();
				System.exit(0);
			}
		});

	}

	public static void main(String[] args) throws InterruptedException {
		launch(args);

	}

}
