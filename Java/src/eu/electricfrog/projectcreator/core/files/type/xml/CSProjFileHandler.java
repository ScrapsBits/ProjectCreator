package eu.electricfrog.projectcreator.core.files.type.xml;

import java.io.File;

/**
 * Handle the CSProj file.
 *
 * @author  ScrapsBits
 * @since   1.1
 * @version 1.1
 */
public class CSProjFileHandler extends XmlFileHandler {
	/**
	 * Receive a .csproj file.
	 *
	 * @param file The project file of the c-sharp project.
	 */
	public CSProjFileHandler(final File file) {
		super(file);
		if(!file.getAbsolutePath().endsWith(".csproj")) throw new IllegalArgumentException("The provided file is not a csproj file.");
	}
}
