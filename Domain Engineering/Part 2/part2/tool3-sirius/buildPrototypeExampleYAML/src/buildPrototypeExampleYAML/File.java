package buildPrototypeExampleYAML;

public class File {
	private String filename;
	private File target;
	private File prerequisite;
	
	public File(String filename, File target, File prerequisite){
		System.out.println("name= "+this.filename+" , target= "+this.target+" and prerequisite="+this.prerequisite);
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
}
