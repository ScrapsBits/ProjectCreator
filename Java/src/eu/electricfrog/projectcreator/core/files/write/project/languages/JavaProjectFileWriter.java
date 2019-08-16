package eu.electricfrog.projectcreator.core.files.write.project.languages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import eu.electricfrog.projectcreator.core.files.write.project.ProjectFileWriter;
import eu.electricfrog.projectcreator.core.models.Project;

/**
 * Write a directory and all necessary files for a Java project.
 * @author ScrapsBits
 * @version 1.0
 */
public class JavaProjectFileWriter extends ProjectFileWriter {
	/**
	 * Receive a Java project.
	 * @param project A java project.
	 */
	public JavaProjectFileWriter(Project project) {
		super(project);
	}

	/**
	 * Write all required Java files to the file system.
	 */
	@Override
	public void write() {
		System.out.println("Creating Java mandatory files."); // TODO: Replace with log component.
		String projectNameDirectory = project.getName().replaceAll("\\s", "").replaceAll("\\\\", "").replaceAll("/", "-");
		System.out.println(projectNameDirectory);
		File directory = new File(project.getDirectory().replaceAll("\\.config", "") + "/" + projectNameDirectory + "/Java/" + projectNameDirectory + "/src");
		directory.mkdirs();
		super.file = new File(directory.getAbsolutePath() + "/" + projectNameDirectory + ".java");
		
		try {
			// TODO: Check for write permissions
			BufferedWriter writer = new BufferedWriter(new FileWriter(super.file));
			// TODO: Allow programmers to set their own package name(s).
			writer.write("package " + projectNameDirectory.toLowerCase() + ";\n\n"
					+ "public class ApplicationLauncher {\n"
					+ "\tpublic static void main(String[] args) {\n"
					+ "\t\t// TODO: Write program.\n"
					+ "\t}\n"
					+ "}");
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Java mandatory files have been created."); // TODO: Replace with log component.
	 }
}
