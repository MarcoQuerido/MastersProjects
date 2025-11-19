package buildPrototypeExampleYAML2;

public class Prefix {
	private String name;
	
	public Prefix(String name){
		this.name = name;
	}
	
	public String getPrefix() {
		return name;
	}
	
	public void setPrefix(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name="+this.name; 
	}
}
