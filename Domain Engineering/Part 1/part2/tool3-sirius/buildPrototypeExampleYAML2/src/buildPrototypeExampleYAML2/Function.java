package buildPrototypeExampleYAML2;

public class Function {
	private String type;
	
	public Function(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "Type="+this.type; 
	}
}
