package Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainWindow {
	private static Stage stage;
	public static BorderPane borderPane = new BorderPane();
	public static ObservePrimaryStage observe_primary_stage;
	public MainWindow(Stage primaryStage) throws IOException {
		observe_primary_stage = new ObservePrimaryStage();
		stage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("/Main/Login.fxml"));
		Scene scene = new Scene(root);
		stage.setMaximized(false);
		stage.setAlwaysOnTop(true);
		stage.setScene(scene);
		stage.show();
	}
	public static void relance_login() throws IOException {
		observe_primary_stage.notifyObservateur();
		stage.close();
		stage = new Stage();
		Parent root = FXMLLoader.load(MainWindow.class.getResource("/Main/Login.fxml"));
		Scene scene = new Scene(root);
		stage.setMaximized(false);
		stage.setAlwaysOnTop(true);
		stage.setScene(scene);
		stage.show();
	}
	/*public static AnchorPane getPane() {
		return pane;
	}*/
	public static void setMain(){
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(MainWindow.class.getResource("/Gestion/Menu.fxml"));
			borderPane = loader.load();
			stage.setMaximized(true);
			stage.setAlwaysOnTop(false);
			Scene scene = new Scene(borderPane);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void setPaneFragment(String url) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainWindow.class.getResource(url));
		AnchorPane center = loader.load();
		borderPane.setCenter(center);
	}

	public static void setPane(AnchorPane pane) {
		MainWindow.borderPane.setCenter(pane);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setRoot(Stage stage) {
		MainWindow.stage = stage;
	}
}
