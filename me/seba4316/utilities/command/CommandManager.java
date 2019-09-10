package me.seba4316.utilities.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.seba4316.utilities.command.Bind; // Example command
import me.seba4316.utilities.PlayerUtils; // Will be available on GitHub soon.

public class CommandManager {

	private List<Command> commands;
	private String trigger;

	public CommandManager(String trigger) {
		commands = new ArrayList<Command>();
		this.trigger = trigger;
		registerCommands();
	}
	
	private void registerCommands() {
		registerCommand(new Bind("bind", trigger + "bind <module> <key>", "Bind a module to a key"));
	}

	public Command registerCommand(Command command) {
		if (getCommand(command) != null)
			throw new IllegalStateException(
					"The command " + command.getName() + " or one of his aliases is already registered.");
		commands.add(command);
		return getCommand(command.getName());
	}

	public Command getCommand(Command command) {
		Command commandByName = getCommand(command.getName());
		if (commandByName == null)
			return getCommand(command.getAliases());
		return null;
	}

	public Command getCommand(String... aliases) {
		for (int i = 0; i < commands.size(); i++) {
			Command command = commands.get(i);
			for (int j = 0; j < aliases.length; j++) {
				if (Arrays.stream(command.getAliases()).anyMatch(aliases[j]::equals))
					return command;
			}
		}
		return null;
	}

	public Command getCommand(String name) {
		name = name.toLowerCase();
		for (int i = 0; i < commands.size(); i++) {
			Command command = commands.get(i);
			if (command.getName().equals(name) || Arrays.stream(command.getAliases()).anyMatch(name::equals))
				return command;
		}
		return null;
	}

	public boolean executeCommand(String line) {
		if (!line.startsWith(trigger))
			return false;
		if (line.trim().equals(trigger)) {
			/** Execute the help command if only the message is equal to the trigger */
			getCommand("help").onCommandExecuted(line, line.split(" "));
			return true;
		}
		line = line.substring(1, line.length());
		String[] args = line.split(" ");
		Command command = getCommand(args[0]);
		if (command != null)
			command.onCommandExecuted(line, args);
		else /** If the command is null print the help */
			getCommand("help").onCommandExecuted(line, args);
		return true;
	}

	public String getTrigger() {
		return trigger;
	}

	public List<Command> getCommands() {
		return commands;
	}

}