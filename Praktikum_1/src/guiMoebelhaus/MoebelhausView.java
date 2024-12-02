package guiMoebelhaus;


import business.MoebelhausModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;

public class MoebelhausView implements Observer{

	// interface Method -> same content as the Method zeigeMoebelstueckAn
		// also called the Method in an setOnAction and one initListener
	@Override
	public void update() {
		if(this.model.getMoebelstueck() != null){
    		txtAnzeige.setText(
    			this.model.getMoebelstueck().gibMoebelstueckZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Moebelhaus aufgenommen!");
    	}
	}

    
	//---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label name 						= new Label("Name:");
    private Label wohnraum			   		= new Label("Wohnraum:");
    private Label stil  	 				= new Label("Stil:");
    private Label preis   					= new Label("Preis:");
    private Label material			  		= new Label("Materialien:");
    private TextField txtName 	 			= new TextField();
    private TextField txtwohnraum			= new TextField();
    private TextField txtstil				= new TextField();
    private TextField txtpreis				= new TextField();
    private TextField txtmaterial			= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
   
    private MoebelhausModel model;
    private MoebelhausControl control;
    
    public MoebelhausView(Stage primaryStage, MoebelhausControl control, MoebelhausModel model){
    	this.control = control;
    	this.model = model;
    	
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Moebelhaus");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
		// add this Object to Observer of model
		this.model.addObserver(this);
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	name.setLayoutX(20);
    	name.setLayoutY(90);
    	wohnraum.setLayoutX(20);
    	wohnraum.setLayoutY(130);
    	stil.setLayoutX(20);
    	stil.setLayoutY(170);
    	preis.setLayoutX(20);
    	preis.setLayoutY(210);
    	material.setLayoutX(20);
    	material.setLayoutY(250);    	
       	pane.getChildren().addAll(
       		lblEingabe, 
       		lblAnzeige, 
       		name, 
       		wohnraum, 
       		stil,
       		preis, 
       		material);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtwohnraum.setLayoutX(170);
    	txtwohnraum.setLayoutY(130);
    	txtwohnraum.setPrefWidth(200);
    	txtstil.setLayoutX(170);
    	txtstil.setLayoutY(170);
    	txtstil.setPrefWidth(200);
      	txtpreis.setLayoutX(170);
    	txtpreis.setLayoutY(210);
    	txtpreis.setPrefWidth(200);
    	txtmaterial.setLayoutX(170);
    	txtmaterial.setLayoutY(250);
    	txtmaterial.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, 
     		txtwohnraum, 
     		txtstil,
     		txtpreis, 
     		txtmaterial);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    control.nehmeMoebelstueckAuf();
	            model.notifyObserver();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	control.leseAusDateien("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	control.leseAusDateien("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				control.schreibeMoebelstueckInDatei();
			}	
	    });
    }
    // is replaced with the update method from the interface
//    private void zeigeMoebelstueckAn(){
//    	if(this.model.getMoebelstueck() != null){
//    		txtAnzeige.setText(
//    			this.model.getMoebelstueck().gibMoebelstueckZurueck(' '));
//    	}
//    	else{
//    		zeigeInformationsfensterAn("Bisher wurde kein Moebelhaus aufgenommen!");
//    	}
//    }    
		  
    

    public void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    public void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
    public TextField getTxtName() {
		return txtName;
	}

	public void setTxtName(TextField txtName) {
		this.txtName = txtName;
	}

	public TextField getTxtwohnraum() {
		return txtwohnraum;
	}

	public void setTxtwohnraum(TextField txtwohnraum) {
		this.txtwohnraum = txtwohnraum;
	}

	public TextField getTxtstil() {
		return txtstil;
	}

	public void setTxtGeoeffnetBis(TextField txtstil) {
		this.txtstil = txtstil;
	}

	public TextField getTxtpreis() {
		return txtpreis;
	}

	public void setTxtpreis(TextField txtpreis) {
		this.txtpreis = txtpreis;
	}

	public TextField getTxtmaterial() {
		return txtmaterial;
	}

	public void setTxtmaterial(TextField txtmaterial) {
		this.txtmaterial = txtmaterial;
	}


}
