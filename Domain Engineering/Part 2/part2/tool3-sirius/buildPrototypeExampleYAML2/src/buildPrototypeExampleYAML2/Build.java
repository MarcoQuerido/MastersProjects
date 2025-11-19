package buildPrototypeExampleYAML2;

public class Build {
    private String group;
    private String version;

    public Build(String group, String version){
    	this.group = group;
    	this.version = version;
    }
    
	public String getGroup() {
		return group;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String toString() {
		return "Group="+this.group+", Version="+this.version; 
	}
}
