package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTXTReaderProduct extends ReaderProduct{

	private BufferedReader br;
	
	public ConcreteTXTReaderProduct() {
		try {
			br = new BufferedReader(new FileReader("MoebelstueckeAusgabe.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		String[] arr = new String[5];
		String zeile = br.readLine();
		int i = 0;
		
		while (i<arr.length) {
			arr[i] = zeile;
			zeile = br.readLine();
			i++;
		}
		
		schliesseDatei();
		return arr;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
	}

}
