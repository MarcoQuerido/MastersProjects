package buildPrototypeExampleYAML;

import java.util.Scanner;

/*
 * Prototype main build file 
 */
	
public class Main {
	// TODO Auto-generated constructor stub
	
	public static void main(String[] args) {
		System.out.println("Executing build...");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose your specific build ...");
		System.out.println("1. Build Ant Application...");
		System.out.println("2. Build Make Application...");
		System.out.println("3. Build Gradle Application...");
		String input = sc.nextLine();
		
		switch (input) {
			case "1":
				System.out.println("Option 1. Ant chosen");
				executeCommonCode();
					
				JavaCompileClass parameters = new JavaCompileClass();
				parameters.setInputFolder("src-java");
				parameters.setInputFileName("src-java/test/Parameters.java");
				parameters.setOutputFileName("src-java/test/Parameters.class");
				parameters.setOutputFolder("generated");
				parameters.execute();
				
				break;
				
			case "2":
				System.out.println("Option 2. Make chosen");
				executeCommonCode();
				
				JavaCompileClass file = new JavaCompileClass();
				file.setInputFolder("src-java");
				file.setInputFileName("src-java/test/File.java");
				file.setOutputFileName("src-java/test/File.class");
				file.setOutputFolder("generated");
				file.execute();
				
				JavaCompileClass function = new JavaCompileClass();
				function.setInputFolder("src-java");
				function.setInputFileName("src-java/test/Function.java");
				function.setOutputFileName("src-java/test/Function.class");
				function.setOutputFolder("generated");
				function.execute();
				
				JavaCompileClass rule = new JavaCompileClass();
				rule.setInputFolder("src-java");
				rule.setInputFileName("src-java/test/Rule.java");
				rule.setOutputFileName("src-java/test/Rule.class");
				rule.setOutputFolder("generated");
				rule.execute();
				
				JavaCompileClass command = new JavaCompileClass();
				command.setInputFolder("src-java");
				command.setInputFileName("src-java/test/Command.java");
				command.setOutputFileName("src-java/test/Command.class");
				command.setOutputFolder("generated");
				command.execute();
				
				JavaCompileClass prefix = new JavaCompileClass();
				prefix.setInputFolder("src-java");
				prefix.setInputFileName("src-java/test/Prefix.java");
				prefix.setOutputFileName("src-java/test/Prefix.class");
				prefix.setOutputFolder("generated");
				prefix.execute();
				break;
				
			case "3":
				System.out.println("Option 3. Gradle chosen");
				executeCommonCode();
				
				JavaCompileClass build = new JavaCompileClass();
				build.setInputFolder("src-java");
				build.setInputFileName("src-java/test/Build.java");
				build.setOutputFileName("src-java/test/Build.class");
				build.setOutputFolder("generated");
				build.execute();
				
				JavaCompileClass plugin = new JavaCompileClass();
				plugin.setInputFolder("src-java");
				plugin.setInputFileName("src-java/test/Plugin.java");
				plugin.setOutputFileName("src-java/test/Plugin.class");
				plugin.setOutputFolder("generated");
				plugin.execute();
				
				JavaCompileClass method = new JavaCompileClass();
				method.setInputFolder("src-java");
				method.setInputFileName("src-java/test/Method.java");
				method.setOutputFileName("src-java/test/Method.class");
				method.setOutputFolder("generated");
				method.execute();
				
				JavaCompileClass dependency = new JavaCompileClass();
				dependency.setInputFolder("src-java");
				dependency.setInputFileName("src-java/test/Dependency.java");
				dependency.setOutputFileName("src-java/test/Dependency.class");
				dependency.setOutputFolder("generated");
				dependency.execute();
				
				JavaCompileClass repository = new JavaCompileClass();
				repository.setInputFolder("src-java");
				repository.setInputFileName("src-java/test/Repository.java");
				repository.setOutputFileName("src-java/test/Repository.class");
				repository.setOutputFolder("generated");
				repository.execute();
				
				JavaCompileClass action = new JavaCompileClass();
				action.setInputFolder("src-java");
				action.setInputFileName("src-java/test/Action.java");
				action.setOutputFileName("src-java/test/Action.class");
				action.setOutputFolder("generated");
				action.execute();
				
				JavaCompileClass script = new JavaCompileClass();
				script.setInputFolder("src-java");
				script.setInputFileName("src-java/test/Script.java");
				script.setOutputFileName("src-java/test/Script.class");
				script.setOutputFolder("generated");
				script.execute();
				break;
				
			default:
				System.out.println("Choose a valid option!");
				break;
		}
	}
	
	static void executeCommonCode() {
		
		JavaCompileClass model = new JavaCompileClass();
		model.setInputFolder("src-java");
		model.setInputFileName("src-java/test/JavaModel.java");
		model.setOutputFolder("generated");
		model.setOutputFileName("src-java/test/JavaModel.class");
		model.execute();
		
		JavaCompileClass project = new JavaCompileClass();
		project.setInputFolder("src-java");
		project.setInputFileName("src-java/test/Project.java");
		project.setOutputFolder("generated");
		project.setOutputFileName("src-java/test/Project.class");
		project.execute();
		
		JavaCompileClass property = new JavaCompileClass();
		property.setInputFolder("src-java");
		property.setInputFileName("src-java/test/Property.java");
		property.setOutputFolder("generated");
		property.setOutputFileName("src-java/test/Property.class");
		property.execute();
		
		JavaCompileClass task = new JavaCompileClass();
		task.setInputFolder("src-java");
		task.setInputFileName("src-java/test/Task.java");
		task.setOutputFolder("generated");
		task.setOutputFileName("src-java/test/Task.class");
		task.execute();
	}
}	
