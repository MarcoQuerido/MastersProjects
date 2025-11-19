package test;

public class Project {
	private String name;
	private String version;
	
	public Project(String name, String version){
		this.name = name;
		this.version = version;
	}
	
	public String getName() {
		return name;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String toString() {
		return "Name="+this.name+", Version="+this.version; 
	}
}
