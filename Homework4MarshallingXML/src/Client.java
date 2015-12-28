import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "name", "address", "hobbies", "lovelyFoots", "rule" })
public class Client {

	private Address address;
	private String name;
	private Hobbies hobbies;
	private List<String> lovelyFoots = new ArrayList<String>();
	private Rule rule = new Rule();
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hobbies getHobbies() {
		return hobbies;
	}

	public void setHobbies(Hobbies hobbies) {
		this.hobbies = hobbies;
	}
	
	public void setLovelyFoots(List<String> foots) {
		this.lovelyFoots.addAll(foots);
	}
	
	@XmlElementWrapper(name="foots")
	public List<String> getLovelyFoots() {
		return lovelyFoots;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

}
