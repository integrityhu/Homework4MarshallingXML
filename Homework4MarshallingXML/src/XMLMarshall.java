import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XMLMarshall {
	
	public static void marshall() throws JAXBException {
		Client client = new Client();
		client.setName("Prop Etrty");
		Address address = new Address();
		address.setCity("Budapset");
		address.setPostalCode("1145");
		address.setStreet("Kossuth tér 45.");
		client.setAddress(address);
		String[] myHobbies = {"árvíztûrõ","tükörfúró","gép"};
		Hobbies hobbies = new Hobbies(myHobbies);
		client.setHobbies(hobbies);
		List<String> foots = new ArrayList<String>();
		foots.add("spagetti");
		foots.add("spenót");
		foots.add("sóska");
		client.setLovelyFoots(foots);
		List<String> condRef = new ArrayList<String>();
		condRef.add("int6");
		List<String> concRef = new ArrayList<String>();
		concRef.add("int1");
		concRef.add("int6");
		client.getRule().setName("rule1");
		client.getRule().setConclusionReferences(concRef);
		client.getRule().setConditionReferences(condRef);
		
		Class<?>[] classes = {Client.class, Address.class};
		JAXBContext jaxbContext = JAXBContext.newInstance(classes, null);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		//marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		//marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		StringWriter writer = new StringWriter();
		marshaller.marshal(client, writer);
		System.out.println(writer.toString());
		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Client inClient = (Client) unmarshaller.unmarshal(new StringReader(writer.toString()));
		
		System.out.println("Client: "+inClient.getName());
		
		Hobbies inHobbies = inClient.getHobbies();
		System.out.println("- Hobbies");
		for(String hobby : inHobbies.getHobbies()) {
			System.out.println(hobby);
		}
		
		List<String> inFoots = inClient.getLovelyFoots();
		for(String foot : inFoots) {
			System.out.println(foot);
		}

	}

}
