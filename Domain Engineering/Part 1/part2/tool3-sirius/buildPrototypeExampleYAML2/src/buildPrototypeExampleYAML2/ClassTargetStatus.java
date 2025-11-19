package buildPrototypeExampleYAML2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ClassTargetStatus {
	
	public static boolean isOutdated(String fileNameTarget, String fileNameSource) {
		Path fileTarget = Paths.get(fileNameTarget);
		Path fileSource = Paths.get(fileNameSource);

		BasicFileAttributes attrTarget;
		try {
			attrTarget = Files.readAttributes(fileTarget, BasicFileAttributes.class);
			BasicFileAttributes attrSource = Files.readAttributes(fileSource, BasicFileAttributes.class);

			return attrSource.lastModifiedTime().compareTo(attrTarget.lastModifiedTime())>0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No file found!");
		}
		return true;
	}

}
