package main.core.files;

import java.io.File;

import main.ProjectCreator;
import main.core.boot.enums.AppPermission;
import main.core.files.enumerations.FileStructure;

/**
 * Manage various aspects of file handling.
 * 
 * @author ScrapsBits
 */
public class FileManager implements AppFileManager {
	/**
	 * Get the AppData directory.
	 * 
	 * @return Returns the absolute directory of the Application Data folder.
	 */
	public static String getApplicationDataDirectory() {
		System.out.println("Locating application data location..."); // TODO: Replace with log component.
		String directory;
		final String os = System.getProperty("os.name").toUpperCase();
		System.out.println("Detected OS: " + os); // TODO: Replace with log component.
		if(os.contains("WIN"))
			directory = System.getenv("AppData");
		else {
			directory = System.getProperty("user.home");
			if(os.contains("MAC")) directory += "/Library/Application Support";
		}
		directory += "\\" + ProjectCreator.getApplicationName();
		final File fileDirectory = new File(directory);
		System.out.println("Located application data location at: " + fileDirectory.getAbsolutePath() + "."); // TODO: Replace with log component.
		if(!fileDirectory.isDirectory()) fileDirectory.mkdir();
		return directory;
	}
	/**
	 * The file used by this instance.
	 */
	private File file;
	/**
	 * The structure the file is applied in.
	 */
	private FileStructure fileStructure;

	/**
	 * Instantiate a new instance of this class.
	 * 
	 * @param file          The file used by this instance.
	 * @param fileStructure The structure the file is applied in.
	 */
	public FileManager(File file, FileStructure fileStructure) {
		this.file = file;
		this.fileStructure = fileStructure;
	}

	/**
	 * Get the structure with which the file is stored.
	 * 
	 * @return Returns the FileStructure value to expect when reading the file.
	 */
	public FileStructure getFileStructure() { return this.fileStructure; }

	@Override
	public boolean canRead() { return (file.canRead() && ProjectCreator.BOOT.isAllowed(AppPermission.FILE_READ)); }

	@Override
	public boolean canWrite() { return (file.canWrite() && ProjectCreator.BOOT.isAllowed(AppPermission.FILE_WRITE)); }

	@Override
	public boolean exists() { return file.isFile(); }

	@Override
	public String getDirectory() { return file.getAbsolutePath(); }

	@Override
	public File getFile() { return file.getAbsoluteFile(); }

}
