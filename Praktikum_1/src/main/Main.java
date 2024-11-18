package main;
// 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
import gui.MoebelhausControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelhausControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
