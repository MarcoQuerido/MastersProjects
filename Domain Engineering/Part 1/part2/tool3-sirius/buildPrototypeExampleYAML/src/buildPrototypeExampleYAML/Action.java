package buildPrototypeExampleYAML;

public class Action {
    private String name;
    private String description;
    private String type;

    public Action(String name, String description, String type){
    	System.out.println("name= "+this.name+" , description="+this.description+"and type="+this.type);
    }
    
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getType() {
		return type;
	}
}
