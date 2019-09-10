package me.seba4316.utilities.command;

import me.seba4316.utilities.module.ModuleManager; // Will be available on GitHub soon
import net.minecraft.client.Minecraft;

public abstract class Command {

	private YourHackedClient yourHackedClient; // This is private instead of protected since I don't think you will create the commands under the me.seba4316.command package. Read the TOS in the GitHub Readme for more informations.
	private ModuleManager moduleManager; // This is private instead of protected since I don't think you will create the commands under the me.seba4316.command package. Read the TOS in the GitHub Readme for more informations.
	private CommandManager commandManager; // This is private instead of protected since I don't think you will create the commands under the me.seba4316.command package. Read the TOS in the GitHub Readme for more informations.
	private String name;
	private String syntax;
	private String description;
	private String[] aliases;
	private Minecraft mc; // This is private instead of protected since I don't think you will create the commands under the me.seba4316.command package. Read the TOS in the GitHub Readme for more informations.

	public Command(String name, String syntax, String description, String... aliases) {
		this.yourHackedClient = YourHackedClient.getInstance();
		this.moduleManager = yourHackedClient.getModuleManager();
		this.commandManager = yourHackedClient.getCommandManager();
		this.name = name;
		this.syntax = syntax;
		this.description = description;
		this.aliases = aliases;
		this.mc = Minecraft.getMinecraft();
	}

	public YourHackedClient getYourHackedClient() {
		return yourHackedClient;
	}
	
	public ModuleManager getModuleManager() {
		return moduleManager;
	}
	
	public CommandManager getCommandManager() {
		return commandManager;
	}

	public String getName() {
		return name;
	}

	public String getSyntax() {
		return syntax;
	}

	public String getDescription() {
		return description;
	}

	public String[] getAliases() {
		return aliases;
	}
	
	public Minecraft mc() {
		return mc;
	}

	public abstract void onCommand(String line, String[] args);

}