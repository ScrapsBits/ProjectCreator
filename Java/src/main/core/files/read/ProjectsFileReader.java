package main.core.files.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.core.files.AppFileManager;
import main.core.files.FileManager;
import main.core.files.enumerations.FileStructure;
import main.models.Project;

public class ProjectsFileReader implements AppFileReader {
	private final AppFileManager fileManager;

	private final String fileName = "projects";

	public ProjectsFileReader() {
		this.fileManager = new FileManager(new File(FileManager.getApplicationDataDirectory() + "\\" + this.fileName), FileStructure.KEY_VALUE);
	}

	@Override
	public Project[] read() throws FileNotFoundException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(this.fileManager.getFile());
			System.out.println("Reading file \"" + this.fileName + "\" at " + this.fileManager.getDirectory() + "."); // TODO: Replace with log component.
			final List<String> lines = new ArrayList<>();
			while(scanner.hasNextLine()) lines.add(scanner.nextLine());
			if(lines.size() == 0)
				throw new NullPointerException("Could not find any projects.");
			else {
				final List<Project> projects = new ArrayList<>();
				for(final String line : lines) {
					final String[] project = line.split("=");
					projects.add(new Project(project[0], project[1]));
				}
				return Arrays.copyOf(projects.toArray(), projects.size(), Project[].class);
			}
		} catch(final FileNotFoundException e) {
			throw new FileNotFoundException("Cannot find \"" + this.fileName +"\" file.");
		} finally {
			if(scanner != null) scanner.close();
		}
	}
}
