package me.seba4316.utilities.command;

import org.lwjgl.input.Keyboard;

import me.seba4316.command.Command;
import me.seba4316.module.Module;
import me.seba4316.utilities.command;

import me.seba4316.utilities.PlayerUtils; // Will be available on GitHub soon.

public class BindCommand extends Command {

	public BindCommand(String name, String syntax, String description, String... aliases) {
		super(name, syntax, description, aliases);
	}

	@Override
	public void onCommand(String line, String[] args) {
		if (args.length < 3) {
			PlayerUtils.sendMessage(getSyntax());
			return;
		}

		Module module = moduleManager.getModule(args[1]);
		
		if (module == null) {
			PlayerUtils.sendMessage("&cThe module $s[1] does not exist.", args[1]);
			return;
		}
		
		module.setKey(Keyboard.getKeyIndex(args[2].toUpperCase()));
		PlayerUtils.sendMessage("&6$s[1]&f has been bound to $s[2]", module.getDisplayName(), args[2]);
	}

}