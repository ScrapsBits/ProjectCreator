package main.core.files.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.core.files.ProjectCreatorFileManager;
import main.core.files.enumerations.FileStructure;
import main.models.Project;

public class ProjectsFileReader extends ProjectCreatorFileReader {

	private static final String FILE_NAME = "projects";

	public ProjectsFileReader() throws IllegalArgumentException {
		super(ProjectCreatorFileManager.getApplicationFilesDirectory(), FileStructure.KEYVALUE);
		if(!super.isValidLocation(super.getFileLocation())) throw new IllegalArgumentException("Project location does not exist.");
	}

	@Override
	public Project[] read() throws FileNotFoundException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(super.getFileLocation() + "\\" + FILE_NAME));
			System.out.println("Reading file \"" + ProjectsFileReader.FILE_NAME + "\" at " + super.getFileLocation() + "."); // TODO: Replace with log component.
			final List<String> lines = new ArrayList<>();
			while(scanner.hasNextLine()) lines.add(scanner.nextLine());
			if(lines.size() == 0) { throw new NullPointerException("Could not find any projects."); } else {
				List<Project> projects = new ArrayList<>();
				for(String line : lines) {
					String[] project = line.split("=");
					projects.add(new Project(project[0], project[1]));
				}
				return Arrays.copyOf(projects.toArray(), projects.size(), Project[].class);
			}
		} catch(FileNotFoundException e) {
			throw new FileNotFoundException("Cannot find \"projects\" file.");
		} finally {
			if(scanner != null) scanner.close();
		}
	}
}
