package reader;

public class ConcreteTXTReaderCreator extends ReaderCreator{

	@Override
	public ReaderProduct factoryMethod() {
		return new ConcreteTXTReaderProduct();
	}

}
