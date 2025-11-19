package buildPrototypeExampleYAML;

public class JavaModel {
	private String name;
	
	public JavaModel(String name){
		System.out.println("name= "+this.name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
