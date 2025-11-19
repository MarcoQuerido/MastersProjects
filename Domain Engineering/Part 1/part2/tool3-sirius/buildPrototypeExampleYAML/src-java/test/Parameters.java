package buildPrototypeExampleYAML;

public class Parameters {
	private String name;
	private String value;
	
	public Parameters(String name, String value){
		System.out.println("name= "+this.name+" value="+this.value);
		
	}
	
	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
