package buildPrototypeExample;

import buildPrototypeExampleYAML.Task;

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
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public void setGroup(String group) {
    	this.group = group;
    }
    
    public void setEnabled(Boolean enabled) {
    	this.enabled = enabled;
    }
    
    public void setDefaultTtask(Task defaultTask) {
    	this.defaultTask = defaultTask;
    }
    
	public String toString() {
		return "Name="+this.name+", Description="+this.description+", Group="+this.group+", Enabled="+this.enabled+", DefaultTask="+this.defaultTask; 
	}
}
