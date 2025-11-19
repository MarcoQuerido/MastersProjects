package buildPrototypeExampleYAML2;

public class File {
	private String filename;
	private String target;
	private String prerequisite;
	
	public File(String filename, String target, String prerequisite){
		this.filename = filename;
		this.target = target;
		this.prerequisite = prerequisite;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public String getTarget() {
		return target;
	}
	
	public String getPrerequisite() {
		return prerequisite;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public void sePrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}
	
	public String toString() {
		return "Filename="+this.filename+", Target="+this.target+", Prerequisite="+this.prerequisite; 
	}
}
