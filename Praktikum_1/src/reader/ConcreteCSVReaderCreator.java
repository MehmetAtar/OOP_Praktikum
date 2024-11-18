package reader;

public class ConcreteCSVReaderCreator extends ReaderCreator{

	@Override
	public ReaderProduct factoryMethod() {
		return new ConcreteCSVReaderProduct();
	}

}
