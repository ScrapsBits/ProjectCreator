package eu.electricfrog.projectcreator.core.files.write.project.languages.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import eu.electricfrog.projectcreator.core.files.write.project.ProjectFileWriter;
import eu.electricfrog.projectcreator.core.models.Project;

/**
 * Write a directory and all necessary files required for a Java project.
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
		File directory = new File(super.project().getDirectory().replaceAll("\\.config", "") + "\\" + super.project().getSafeName() + "\\" + "Java");
		directory.mkdirs();
		File srcDirectory = new File(directory.getAbsolutePath() + "/src");
		srcDirectory.mkdir();
		super.setFile(new File(srcDirectory + "/" + super.project().getSafeName() + ".java"));
		
		try {
			// TODO: Check for write permissions
			BufferedWriter writer = new BufferedWriter(new FileWriter(super.getFile()));
			// TODO: Allow programmers to set their own package name(s).
			writer.write("package " + super.project().getSafeName().toLowerCase() + ";\n\n"
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
