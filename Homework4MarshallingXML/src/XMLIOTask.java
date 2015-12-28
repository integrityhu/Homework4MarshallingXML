import javax.xml.bind.JAXBException;


public class XMLIOTask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			XMLMarshall.marshall();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
