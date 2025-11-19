package buildPrototypeExampleYAML2;

public class Command {
	private String commandline;
	
	public Command(String commandline){
		this.commandline = commandline;
	}
	
	public String getCommandline() {
		return commandline;
	}
	
	public void setCommandline(String commandline) {
		this.commandline = commandline;
	}
	
	public String toString() {
		return "Command="+this.commandline; 
	}
}
