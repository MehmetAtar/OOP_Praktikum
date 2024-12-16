package gui.guiWarenuebersicht;
import business.MoebelhausModel;
import javafx.stage.Stage;

public class WarenuebersichtControl {	
	private WarenuebersichtView
 		warenuebersichtView;
	private MoebelhausModel moebelModel;
	public WarenuebersichtControl(Stage primaryStage){
		// change model Object with new Singleton Method
 		this.moebelModel = MoebelhausModel.getInstance(); 		
		this.warenuebersichtView 
		 	= new WarenuebersichtView(this, primaryStage,
			moebelModel);
	}
}
