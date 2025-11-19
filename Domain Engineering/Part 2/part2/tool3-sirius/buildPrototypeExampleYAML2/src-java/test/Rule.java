package buildPrototypeExample;

public class Rule {
	private String variables;
	
	public Rule(String variables){
		this.variables = variables;
	}
	
	public String getVariables() {
		return variables;
	}
	
	public void setVariables(String variables) {
		this.variables = variables;
	}
	
	public String toString() {
		return "Variables="+this.variables; 
	}
}
