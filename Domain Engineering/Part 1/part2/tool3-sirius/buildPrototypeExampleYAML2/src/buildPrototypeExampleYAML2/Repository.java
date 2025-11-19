package buildPrototypeExampleYAML2;

public class Repository {
	private String name;
	
	public Repository(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name="+this.name; 
	}
}
