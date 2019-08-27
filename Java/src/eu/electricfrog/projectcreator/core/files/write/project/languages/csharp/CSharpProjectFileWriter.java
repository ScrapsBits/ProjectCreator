package eu.electricfrog.projectcreator.core.files.write.project.languages.csharp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import eu.electricfrog.projectcreator.core.files.write.project.ProjectFileWriter;
import eu.electricfrog.projectcreator.core.models.Project;

/**
 * Write a directory and all necessary files required for a C# project.
 * @author ScrapsBits
 * @version 1.0
 */
public class CSharpProjectFileWriter extends ProjectFileWriter {

	/**
	 * Receive a C# project.
	 * @param project A C# project.
	 */
	public CSharpProjectFileWriter(Project project) {
		super(project);
	}

	/**
	 * Write all required C# files to the system.
	 */
	@Override
	public void write() {
		// TODO: Check for write permissions
		System.out.println("Creating C# mandatory files."); // TODO: Replace with log component.
		File directory = new File(super.project().getDirectory().replaceAll("\\.config", "") + "/" + super.project().getSafeName() + "/CSharp");
		directory.mkdirs();
		String safeName = super.project().getSafeName().replaceAll("-", "_");
		super.setFile(new File(directory.getAbsolutePath() + "/" + safeName + ".sln"));

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(super.getFile()));
			// TODO: Split function to methods that each write one specific file.
			// TODO: Generate random project GUIDs
			writer.write("\n"
					+ "Microsoft Visual Studio Solution File, Format Version 12.00\n"
					+ "Project(\"{FAE04EC0-301F-11D3-BF4B-00C04F79EFBC}\") = \"" + safeName + "\", \"" + safeName + "\\" + safeName + ".csproj\", \"{8CDD8387-B905-44A8-B5D5-07BB50E05BEA}\n"
					+ "EndProject\n"
					+ "Global\n"
					+ "\tGlobalSelection(SolutionConfigurationPlatforms) = preSolution\n"
					+ "\t\tDebug|Any CPU = Debug|Any CPU\n"
					+ "\t\tRelease|Any CPU = Release|Any CPU\n"
					+ "\tEndGlobalSection"
					+ "\tGlobalSelection(ProjectConfigurationPlatforms) = postSolution\n"
					+ "\t\t{8CDD8387-B905-44A8-B5D5-07BB50E05BEA}.Debug.ActiveCfg = Debug|Any CPU"
					+ "\t\t{8CDD8387-B905-44A8-B5D5-07BB50E05BEA}.Debug.Build.0 = Debug|Any CPU"
					+ "\t\t{8CDD8387-B905-44A8-B5D5-07BB50E05BEA}.Release.ActiveCfg = Release|Any CPU"
					+ "\t\t{8CDD8387-B905-44A8-B5D5-07BB50E05BEA}.Release.Build.0 = Release|Any CPU"
					+ "\tEndGlobalSection\n"
					+ "\tGlobalSection(SolutionProperties) = preSolution\n"
					+ "\t\tHideSolutionNode = FALSE\n"
					+ "\tEndGlobalSection\n"
					+ "\tGlobalSection(ExtensibilityGlobals) = postSolution\n"
					+ "\tEndGlobalSection\n"
					+ "EndGlobal");
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		File csprojFileDirectory = new File(directory.getAbsolutePath() + "\\" + safeName );
		csprojFileDirectory.mkdirs();
		try {
			File csprojFile = new File(csprojFileDirectory.getAbsolutePath()+ "\\" + safeName + ".csproj");
			
			final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			final Document document = documentBuilder.newDocument();
			
			final Element root = document.createElement("Project");
			root.setAttribute("Sdk", "Microsoft.NET.Sdk");
			document.appendChild(root);
			
			final Element propertyGroup = document.createElement("PropertyGroup");
			root.appendChild(propertyGroup);
			final Element outputType = document.createElement("OutputType");
			outputType.setTextContent("Exe");
			propertyGroup.appendChild(outputType);
			final Element targetFrameWork = document.createElement("TargetFramework");
			targetFrameWork.setTextContent("netcoreapp2.1");
			propertyGroup.appendChild(targetFrameWork);
			final Element rootNameSpace = document.createElement("RootNameSpace");
			rootNameSpace.setTextContent(safeName);
			propertyGroup.appendChild(rootNameSpace);
			final Element startupObject = document.createElement("StartupObject");
			startupObject.setTextContent(safeName + ".Program");
			propertyGroup.appendChild(startupObject);
			
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			final DOMSource domSource = new DOMSource(document);
			final StreamResult streamResult = new StreamResult(csprojFile);
			transformer.transform(domSource, streamResult);
			
		} catch(ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO: Generate Main method file in the above project.
		File mainClass = new File(csprojFileDirectory+ "\\" + "Program.cs");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(mainClass));
			writer.write("using System;\n"
					+ "\n"
					+ "namespace " + safeName + "\n"
					+ "{\n"
					+ "\tclass Program\n"
					+ "\t{\n"
					+ "\t\tstatic void Main(string[] args)\n"
					+ "\t\t{\n"
					+ "\t\t\tConsole.WriteLine(\"Hello World!\");\n"
					+ "\t\t}\n"
					+ "\t}\n"
					+ "}"
					);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("C# mandatory files have been created."); // TODO: Replace with log component.
	 }
}
