package buildPrototypeExampleYAML;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaCompileClass {
	
	private String fileName;
	private String folderName;
	private String outputFileName;
	private String outputFolderName;
	
	public void setInputFolder(String folderName) {
		this.folderName = folderName;
	}
	
	public void setOutputFolder(String outputFolderName) {
		this.outputFolderName = outputFolderName;
	}
	
	public void setInputFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setOutputFileName(String fileName) {
		this.outputFileName = fileName;
	}
	
	public void execute() {
		
		if (!(FileTargetStatus.isOutdated(outputFileName, fileName))) {
			System.out.println("Nothing to do...");
			return;
		}
		
		String command = "javac -cp "+ this.folderName + " "+ this.fileName + " -d "+ this.outputFolderName;
		try {
			Process pro = Runtime.getRuntime().exec(command);
			printLines(command + " stdout:", pro.getInputStream());
			printLines(command + " stderr:", pro.getErrorStream());

			pro.waitFor();
			System.out.println(command + " exitValue() " + pro.exitValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }
}
