import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"hobbies"})
public class Hobbies {
	
	private String[] hobbies;
	
	public Hobbies() {
		
	}
	
	public Hobbies(String[] hobbies) {
		this.setHobbies(hobbies);
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
}
