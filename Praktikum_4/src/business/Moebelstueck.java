package business;

import java.util.ArrayList;

public class Moebelstueck {
	
	// Name des Buergeramtes
    private String name;
    // Oeffnungszeiten
    private float wohnraum;
    private String stil;
    // Strasse und Hausnummer des Buergeramtes
    private float preis;
    // Dienstleistungen des Buergeramtes
    // Praktikum 4 String[] -> ArrayList<String>
//    private String[] material;
    private ArrayList<String> material;
    
    public Moebelstueck(String name, float wohnraum, String stil,
    	float preis, String[] material) {
    	// Praktikum 4 add IllegalArgumentExeption throw 
	   	if(name == null) {
	   		throw new IllegalArgumentException();
	   	}
   		this.name = name;
  	    this.wohnraum = wohnraum;
   	    this.stil = stil;
   	    this.preis = preis;

   	    // Praktikum 4 cast from ArrayList to a String Array for the Return
//   	    this.material = material;
   	    setMaterialAusStringArray(material);
    }
    // Praktikum 4 Method to add a String Array into the new ArrayList
    private void setMaterialAusStringArray(String[] material) {
    	this.material = new ArrayList<String>();
    	for (int i = 0; i < material.length; i++) {
			this.material.add(material[i]);
		}
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWohnraum() {
		return wohnraum;
	}

	public void setWohnraum(float geoeffnetVon) {
		this.wohnraum = geoeffnetVon;
	}

	public String getStil() {
		return stil;
	}

	public void setStil(String stil) {
		this.stil = stil;
	}

	public float getPreis() {
		return preis;
	}

	public void setStrasseHNr(float preis) {
		this.preis = preis;
	}

	// Praktikum 4 cast from ArrayList to a String Array for the Return
//	public String[] getMaterial() {
//		return this.material;
//	}
	public String[] getMaterial() {
		String[] array = new String[this.material.size()];
		for (int i = 0; i < this.material.size(); i++) {
			array[i] = this.material.get(i);
		}
		return array;
	}
	

	// Praktikum 4 call new Method to cast array to ArrayList
//	public void setMaterial(String[] material) {
//		this.material = material;
//	}
	public void setMaterial(String[] material) {
		setMaterialAusStringArray(material);
	}
	
	
	
	public String getMaterialAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getMaterial().length - 1; i++) {
			ergebnis = ergebnis + this.getMaterial()[i] + trenner; 
		}
		return ergebnis	+ this.getMaterial()[i];
	}
	
	public String gibMoebelstueckZurueck(char trenner){

  		return this.getName() + trenner 
  			+ this.getWohnraum() + trenner
  		    + this.getStil() + trenner
  		    + this.getPreis() + trenner 
  		    + this.getMaterialAlsString(trenner)
  		    + "\n"; 
	}
}

