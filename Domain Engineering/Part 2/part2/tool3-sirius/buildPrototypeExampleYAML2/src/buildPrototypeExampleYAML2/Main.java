package buildPrototypeExampleYAML2;

import java.util.Scanner;

/*
 * Prototype main build file 
 */
	
public class Main {
	// TODO Auto-generated constructor stub
	
	public static void main(String[] args) {
		
		boolean exit = false;
		
		while (!exit) {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			System.out.println("YABL builds - Menu");
			System.out.println("1 - Create new build");
			System.out.println("2 - Exit");
			String input = sc.nextLine();
			int option = Integer.valueOf(input);
			
			switch (option) {
				case 1: {
					String name;
					String version;
					String desc;
					String group;
					Boolean enabled;
					Task defaultTask;
						
					@SuppressWarnings("resource")
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Choose your specific build ...");
					System.out.println("1. Build Ant Application...");
					System.out.println("2. Build Make Application...");
					System.out.println("3. Build Gradle Application...");
					input = sc2.nextLine();
					option = Integer.valueOf(input);
					
					switch (option) {
						case 1:
							String value; 
							
							System.out.println("Option 1. Ant chosen");
							
							// Default classes
							executeCommonCode();
										
							// Create Parameters Specifications
							
							System.out.println("Define Parameters Name ...");
							name = sc.nextLine();
							System.out.println("Define Parameters Value ...");
							value = sc.nextLine();
							
							Parameters params = new Parameters(name,value);
							
							JavaCompileClass parameters = new JavaCompileClass();
							parameters.setInputFolder("src-java");
							parameters.setInputFileName("src-java/test/Parameters.java");
							parameters.setOutputFileName("src-java/test/Parameters.class");
							parameters.execute();
							
							break;
							
						case 2:
							String filename; 
							String target; 
							String prerequisite;
							String type;
							String variables;
							String commandline;
							
							System.out.println("Option 2. Make chosen");
							
							// Default classes
							executeCommonCode();
							
							// Create File Specifications
							
							System.out.println("Define Parameters Filename ...");
							filename = sc.nextLine();
							System.out.println("Define Parameters Target ...");
							target = sc.nextLine();
							System.out.println("Define Parameters Prerequisites ...");
							prerequisite = sc.nextLine();
							
							File f = new File(filename,target,prerequisite);
							
							JavaCompileClass file = new JavaCompileClass();
							file.setInputFolder("src-java");
							file.setInputFileName("src-java/test/File.java");
							file.setOutputFileName("src-java/test/File.class");
							file.execute();
							
							// Create Function Specifications
							
							System.out.println("Define Function Type ...");
							type = sc.nextLine();
							
							Function func = new Function(type);
							
							JavaCompileClass function = new JavaCompileClass();
							function.setInputFolder("src-java");
							function.setInputFileName("src-java/test/Function.java");
							function.setOutputFileName("src-java/test/Function.class");
							function.execute();
							
							// Create Rule Specifications
							
							System.out.println("Define Rule Type ...");
							variables = sc.nextLine();
							
							Rule r = new Rule(variables);
							
							JavaCompileClass rule = new JavaCompileClass();
							rule.setInputFolder("src-java");
							rule.setInputFileName("src-java/test/Rule.java");
							rule.setOutputFileName("src-java/test/Rule.class");
							rule.execute();
							
							// Create Command Specifications
							
							System.out.println("Define Command Type ...");
							commandline = sc.nextLine();
							
							Command comm = new Command(commandline);
							
							JavaCompileClass command = new JavaCompileClass();
							command.setInputFolder("src-java");
							command.setInputFileName("src-java/test/Command.java");
							command.setOutputFileName("src-java/test/Command.class");
							command.execute();
							
							// Create Prefix Specifications
							
							System.out.println("Define Prefix Name ...");
							name = sc.nextLine();
							
							Prefix com = new Prefix(commandline);
							
							JavaCompileClass prefix = new JavaCompileClass();
							prefix.setInputFolder("src-java");
							prefix.setInputFileName("src-java/test/Prefix.java");
							prefix.setOutputFileName("src-java/test/Prefix.class");
							prefix.execute();
							break;
							
						case 3:
							int id;
							String prprty;
							System.out.println("Option 3. Gradle chosen");
							
							// Default classes
							executeCommonCode();
							
							// Create Build Specifications
							
							System.out.println("Define Build Group ...");
							group = sc.nextLine();
							System.out.println("Define Build Version ...");
							version = sc.nextLine();
							
							Build b = new Build(group,version);
							
							JavaCompileClass build = new JavaCompileClass();
							build.setInputFolder("src-java");
							build.setInputFileName("src-java/test/Build.java");
							build.setOutputFileName("src-java/test/Build.class");
							build.execute();
							
							// Create Plugin Specifications
							
							System.out.println("Define Plugin Id ...");
							id = sc.nextInt();
							System.out.println("Define Plugin Name ...");
							name = sc.nextLine();
							System.out.println("Define Plugin Type ...");
							type = sc.nextLine();
							
							Plugin plgn = new Plugin(id,name,type);
							
							JavaCompileClass plugin = new JavaCompileClass();
							plugin.setInputFolder("src-java");
							plugin.setInputFileName("src-java/test/Plugin.java");
							plugin.setOutputFileName("src-java/test/Plugin.class");
							plugin.execute();
							
							// Create Method Specifications
							
							System.out.println("Define Method Property ...");
							prprty = sc.nextLine();
							
							Method m = new Method(prprty);
							
							JavaCompileClass method = new JavaCompileClass();
							method.setInputFolder("src-java");
							method.setInputFileName("src-java/test/Method.java");
							method.setOutputFileName("src-java/test/Method.class");
							method.execute();
							
							// Create Dependency Specifications
							
							System.out.println("Define Dependency Name ...");
							name = sc.nextLine();
							System.out.println("Define Dependency Version ...");
							version = sc.nextLine();
							
							Dependency dpndncy = new Dependency(name,version);
							
							JavaCompileClass dependency = new JavaCompileClass();
							dependency.setInputFolder("src-java");
							dependency.setInputFileName("src-java/test/Dependency.java");
							dependency.setOutputFileName("src-java/test/Dependency.class");
							dependency.execute();
							
							// Create Repository Specifications
							
							System.out.println("Define Repository Name ...");
							name = sc.nextLine();
							
							Repository rep = new Repository(name);
							
							JavaCompileClass repository = new JavaCompileClass();
							repository.setInputFolder("src-java");
							repository.setInputFileName("src-java/test/Repository.java");
							repository.setOutputFileName("src-java/test/Repository.class");
							repository.execute();
							
							// Create Action Specifications
							
							System.out.println("Define Action Name ...");
							name = sc.nextLine();
							System.out.println("Define Action Description ...");
							desc = sc.nextLine();
							System.out.println("Define Action Type ...");
							type = sc.nextLine();
							
							Action act = new Action(name,desc,type);
							
							JavaCompileClass action = new JavaCompileClass();
							action.setInputFolder("src-java");
							action.setInputFileName("src-java/test/Action.java");
							action.setOutputFileName("src-java/test/Action.class");
							action.execute();
							
							// Create Script Specifications
							
							System.out.println("Define Script Name ...");
							name = sc.nextLine();
							
							Script scrpt = new Script(name);
							
							JavaCompileClass script = new JavaCompileClass();
							script.setInputFolder("src-java");
							script.setInputFileName("src-java/test/Script.java");
							script.setOutputFileName("src-java/test/Script.class");
							script.execute();
							break;
							
						default:
							System.out.println("Choose a valid option!");
							break;
					}
				}
				
				case 2: 
					exit = true;
					break;
					
				default:
					System.out.println("Choose a valid option!");
			}	
		}	
	}
	
	static void executeCommonCode() {
		
		String name;
		String version;
		String group;
		Boolean enabled;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// Create Model Specifications
		
		System.out.println("Define Model Name ...");
		name = sc.nextLine();
		
		JavaModel mod = new JavaModel(name);
		
		JavaCompileClass model = new JavaCompileClass();
		model.setInputFolder("src-java");
		model.setInputFileName("src-java/test/JavaModel.java");
		model.setOutputFolder("generated");
		model.setOutputFileName("src-java/test/JavaModel.class");
		model.execute();
		
		// Create Project Specifications
		
		System.out.println("Define Project Name ...");
		name = sc.nextLine();
		System.out.println("Define Project Version ...");
		version = sc.nextLine();
		
		Project proj = new Project(name,version);
		
		JavaCompileClass project = new JavaCompileClass();
		project.setInputFolder("src-java");
		project.setInputFileName("src-java/test/Project.java");
		project.setOutputFileName("src-java/test/Project.class");
		project.execute();
		
		// Create Task Specifications
		
		System.out.println("Define Task Name ...");
		name = sc.nextLine();
		System.out.println("Define Task Description ...");
		version = sc.nextLine();
		System.out.println("Define Task Group ...");
		group = sc.nextLine();
		System.out.println("Define Task Enabled ...");
		enabled = sc.nextBoolean();
		System.out.println("Define Task DefaultTask ...");
		//defaultTask = sc.next();
		
		//Task t = new Task(name,version,group,enabled,defaultTask);
		
		JavaCompileClass task = new JavaCompileClass();
		task.setInputFolder("src-java");
		task.setInputFileName("src-java/test/Task.java");
		task.setOutputFileName("src-java/test/Task.class");
		task.execute();
		
		// Create Property Specifications
		
		System.out.println("Define Property Name ...");
		name = sc.nextLine();
		
		Property prop = new Property(name);
		
		JavaCompileClass property = new JavaCompileClass();
		property.setInputFolder("src-java");
		property.setInputFileName("src-java/test/Property.java");
		property.setOutputFileName("src-java/test/Property.class");
		property.execute();
	}
}	
