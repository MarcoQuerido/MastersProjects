package buildPrototypeExampleYAML;

public class Plugin {
    private int id;
    private String name;
    private String type;

    public Plugin(int id, String name, String type){
    	System.out.println("id= "+this.id+" , name="+this.name+" and type="+this.type);
    }
    
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
}
