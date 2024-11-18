package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCSVReaderProduct extends ReaderProduct{

	private BufferedReader br;
	
	public ConcreteCSVReaderProduct() {
		try {
			br = new BufferedReader(new FileReader("MoebelstueckeAusgabe.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		String[] arr = br.readLine().split(";");
		schliesseDatei();
		return arr;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
	}

}
