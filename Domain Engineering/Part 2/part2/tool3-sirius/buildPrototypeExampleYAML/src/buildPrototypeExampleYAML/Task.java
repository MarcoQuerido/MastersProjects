package buildPrototypeExampleYAML;

public class Task{
    private String name;
    private String description;
    private String group;
    private Boolean enabled;
    private Task defaultTask;

    public Task(String name, String description, String group, Boolean enabled, Task defaultTask){
    	this.name = name;
    	this.description = description;
    	this.group = group;
    	this.enabled = enabled;
    	this.defaultTask = defaultTask;
    }
    
    public String getName(){
    	return name;
    }
    
    public String getDescription(){
    	return description;
    }
    
    public String getGroup(){
    	return group;
    }
    
    public Boolean getEnabled(){
    	return enabled;
    }
    
    public Task getDefaultTask(){
    	return defaultTask;
    }
}
