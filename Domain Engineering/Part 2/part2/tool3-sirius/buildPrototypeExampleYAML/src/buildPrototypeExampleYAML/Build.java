package buildPrototypeExampleYAML;

public class Build {
    private String group;
    private String version;

    public Build(String group, String version){
    	System.out.println("group= "+this.group+" and version="+this.version);
    }
    
	public String getGroup() {
		return group;
	}
	
	public String getVersion() {
		return version;
	}
}
