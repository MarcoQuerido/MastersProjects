package buildPrototypeExampleYAML;

public class File {
	private String filename;
	private File target;
	private File prerequisite;
	
	public File(String filename, File target, File prerequisite){
		this.filename = filename;
		this.target = target;
		this.prerequisite = prerequisite;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public File getTarget() {
		return target;
	}
	
	public File getPrerequisite() {
		return prerequisite;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public void setTarget(File target) {
		this.target = target;
	}
	
	public void sePrerequisite(File prerequisite) {
		this.prerequisite = prerequisite;
	}
	
	public String toString() {
		return "Filename="+this.filename+", Target="+this.target+", Prerequisite="+this.prerequisite; 
	}
}