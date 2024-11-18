package business;

public class Moebelstueck {
	
	// Name des Buergeramtes
    private String name;
    // Oeffnungszeiten
    private float wohnraum;
    private String stil;
    // Strasse und Hausnummer des Buergeramtes
    private float preis;
    // Dienstleistungen des Buergeramtes
    private String[] material;

    public Moebelstueck(String name, float wohnraum, String stil,
    	float preis, String[] material){
   		this.name = name;
  	    this.wohnraum = wohnraum;
   	    this.stil = stil;
   	    this.preis = preis;
   	    this.material = material;
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

	public String[] getMaterial() {
		return material;
	}

	public void setMaterial(String[] material) {
		this.material = material;
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
  		    + this.getMaterialAlsString(trenner); 
	}
}

