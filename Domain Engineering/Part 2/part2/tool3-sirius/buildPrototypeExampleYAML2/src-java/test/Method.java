package buildPrototypeExample;

public class Method {
	private String property;
	
	public Method(String property){
		this.property = property;
	}
	
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	
	public String toString() {
		return "Property="+this.property; 
	}
}
