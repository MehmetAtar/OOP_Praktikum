package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import guiMoebelhaus.MoebelhausControl;
import jdk.nashorn.internal.objects.annotations.Constructor;
import ownUtil.Observer;
import reader.ConcreteCSVReaderCreator;
import reader.ConcreteTXTReaderCreator;
import reader.ReaderCreator;
import reader.ReaderProduct;

public class MoebelhausModel implements ownUtil.Observable{
	
	private MoebelhausControl control;
    private Moebelstueck moebelstueck;
    // add attribute for Singleton
    private static MoebelhausModel modelInstance;
    
    // add static method to access the Object
    public static MoebelhausModel getInstance() {
    	if(modelInstance == null)
    		modelInstance = new MoebelhausModel();
    	return modelInstance;
    }
    // private Constructor -> no new Objects of this class
    private MoebelhausModel() {
    	super();
    }
    
    // add a new Observer Array using Vector
    private Vector<Observer> observers = new Vector<Observer>();
    
    // inteface Methods 
	@Override
	public void addObserver(Observer obs) {
		// add an Observer element to the Vector
		observers.addElement(obs);
	}
	@Override
	public void removeObserver(Observer obs) {
		// remove an Observer element from the Vector
		observers.removeElement(obs);
	}
	@Override
	public void notifyObserver() {
		// update each element of observers
		for (int i = 0; i < observers.size(); i++) {
			observers.elementAt(i).update();
		}
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
		notifyObserver();
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
		notifyObserver();
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
