package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gui.MoebelhausControl;

public class MoebelhausModel {
	private MoebelhausControl control;
    private Moebelstueck moebelstueck;
    
    public MoebelhausModel(MoebelhausControl control) {
    	this.setControl(control);
	}


	public void schreibeMoebelstueckInCsvDatei() throws IOException{
		BufferedWriter aus = new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", false));
		aus.write(moebelstueck.gibMoebelstueckZurueck(';'));
		aus.close();
		control.getView().zeigeInformationsfensterAn(
   			"Das Moebelhaus wurden gespeichert!");
		System.out.println(moebelstueck.gibMoebelstueckZurueck(';'));
	}
	
	public void leseAusDatei(String typ) throws IOException{
  		if("csv".equals(typ)){
  			BufferedReader ein = new BufferedReader(new FileReader("MoebelstueckeAusgabe.csv"));
  			String[] zeile = ein.readLine().split(";");
  			this.moebelstueck = new Moebelstueck(
  				zeile[0], 
  				Float.parseFloat(zeile[1]), 
  				zeile[2], 
  				Float.parseFloat(zeile[3]), 
  				zeile[4].split("_"));
  			control.getView().zeigeInformationsfensterAn("Die Moebelhaeuser wurden gelesen!");
  		}
   		else{
   			control.getView().zeigeInformationsfensterAn("Noch nicht implementiert!");
   		}
	}
		
	
    
	public Moebelstueck getMoebelstueck() {
		return this.moebelstueck;
	}

	public void setMoebelstueck(Moebelstueck moebelstueck) {
		this.moebelstueck = moebelstueck;
	}


	public MoebelhausControl getControl() {
		return control;
	}


	public void setControl(MoebelhausControl control) {
		this.control = control;
	}
    
    
}
