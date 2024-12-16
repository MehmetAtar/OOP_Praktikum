package writer;

import java.io.IOException;

public abstract class WriterProduct {


	public abstract String[] schreibeInDatei(Object object) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;

}
