package main;
import gui.guiWarenuebersicht.WarenuebersichtControl;
import guiMoebelhaus.MoebelhausControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelhausControl(primaryStage);
		Stage fensterWarenuebersicht = new Stage();
		new WarenuebersichtControl(fensterWarenuebersicht);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
	// nice
}
// Warenuebersicht // View