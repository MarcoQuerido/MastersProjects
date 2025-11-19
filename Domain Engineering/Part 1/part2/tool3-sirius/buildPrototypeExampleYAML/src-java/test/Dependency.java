package buildPrototypeExampleYAML;

public class Dependency {
    private String name;
    private String version;

    public Dependency(String group, String version){
    	System.out.println("name= "+this.name+" and version="+this.version);
    }
    
	public String getName() {
		return name;
	}
	
	public String getVersion() {
		return version;
	}
}
