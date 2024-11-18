package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import gui.MoebelhausControl;
import reader.ConcreteCSVReaderCreator;
import reader.ConcreteTXTReaderCreator;
import reader.ReaderCreator;
import reader.ReaderProduct;

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
	
	public void leseAusDateiCSV(String typ) throws IOException{

//  		BufferedReader ein = new BufferedReader(new FileReader("MoebelstueckeAusgabe.csv"));
// 			String[] zeile = ein.readLine().split(";");
		ReaderCreator creator = new ConcreteCSVReaderCreator();
		ReaderProduct product = creator.factoryMethod();
		String[] zeile = product.leseAusDatei();
		
		this.moebelstueck = new Moebelstueck( 
			zeile[0], 
			Float.parseFloat(zeile[1]), 
			zeile[2], 
			Float.parseFloat(zeile[3]), 
			zeile[4].split("_"));
		control.getView().zeigeInformationsfensterAn("Die Moebelhaeuser wurden gelesen! CSV");
  	}
	
	
	public void leseAusDateiTXT(String typ) throws IOException{
		
		ReaderCreator creator = new ConcreteTXTReaderCreator();
		ReaderProduct product = creator.factoryMethod();
		String[] zeile = product.leseAusDatei();
		
		this.moebelstueck = new Moebelstueck( 
			zeile[0], 
			Float.parseFloat(zeile[1]), 
			zeile[2], 
			Float.parseFloat(zeile[3]), 
			zeile[4].split("_"));
		control.getView().zeigeInformationsfensterAn("Die Moebelhaeuser wurden gelesen! TXT");
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
