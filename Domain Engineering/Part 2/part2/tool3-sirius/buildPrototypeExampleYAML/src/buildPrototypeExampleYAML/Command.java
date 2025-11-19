package buildPrototypeExampleYAML;

public class Command {
	private String commandline;
	
	public Command(String commandline){
		System.out.println("commandline= "+this.commandline);
	}
	
	public String getCommandline() {
		return commandline;
	}
}
