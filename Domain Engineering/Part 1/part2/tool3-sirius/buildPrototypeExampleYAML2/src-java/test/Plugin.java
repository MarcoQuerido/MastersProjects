package buildPrototypeExample;

public class Plugin {
    private int id;
    private String name;
    private String type;

    public Plugin(int id, String name, String type){
    	this.id = id;
    	this.name = name;
    	this.type = type;
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "Id="+this.id+", Name="+this.name+", Type="+this.type; 
	}
}

