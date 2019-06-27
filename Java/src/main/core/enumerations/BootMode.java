package main.core.enumerations;

public enum BootMode {
	DEFAULT("default"), NORMAL(""), SAFE("safe"), DEVELOPMENT("development");

	private String bootCommand;

	public String getBootCommand() { return bootCommand; }

	private BootMode(String bootCommand) { this.bootCommand = bootCommand; }
}
