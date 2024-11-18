package gui;

import java.io.IOException;

import business.MoebelhausModel;
import business.Moebelstueck;
import javafx.stage.Stage;

public class MoebelhausControl {

	private MoebelhausView view;
	private MoebelhausModel model;
	
    public MoebelhausControl(Stage stage) {
		super();
		this.model = new MoebelhausModel(this);
		this.view = new MoebelhausView(stage, this, model);
	
	}
    
	public void nehmeMoebelstueckAuf(){
    	try{
    		model.setMoebelstueck(new Moebelstueck(
    			view.getTxtName().getText(), 
   	            Float.parseFloat(view.getTxtwohnraum().getText()),
   	            view.getTxtstil().getText(),
    		    Float.parseFloat(view.getTxtpreis().getText()),
    		    view.getTxtmaterial().getText().split(";")));
    		view.zeigeInformationsfensterAn("Das Moebelhaus wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
    public void schreibeMoebelstueckInDatei(){
    	try {
			model.schreibeMoebelstueckInCsvDatei();
		} catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
		}
		catch(Exception exc){
			System.out.println(exc);
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
    }
    
    public void leseAusDateien(String typ) {
    	try {
    		if(typ.contentEquals("csv"))
    			model.leseAusDateiCSV(typ);
    		else
    			model.leseAusDateiTXT(typ);
		} catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		} catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
    }
    
	public MoebelhausView getView() {
		return view;
	}

	public void setView(MoebelhausView view) {
		this.view = view;
	}

	public MoebelhausModel getModel() {
		return model;
	}

	public void setModel(MoebelhausModel model) {
		this.model = model;
	}
    
    
    
}
