# Command Manager
This is the Command Manager I created for my new Minecraft hacked client.<br>
You can use it on your hacked client, just leave me credits.<br>
The command manager has been tested with the following Minecraft versions:
- 1.8.8
 
 # Terms Of Service
 You can use the command manager in your code for free, but you must leave me credits. You can create the commands under the package me.seba4316.utilities.command to use the: mc, moduleManager, commandManager and your client instance, as protected instead of private (more infos in the class me.seba4316.utilities.command.Command), or you can import the classes in your package, but you must leave credits somewhere.
 
 # Setup
 ## Step 1 - Copying The Files
 Copy the folder "me" (with all of the content) from the zip you downloaded into the sources of your project
 ## Step 2 - Initializing in your hacked client main class
 In the main class of your hacked client create the CommandManager instance with<br>
 > private CommandManager commandManager;<br>
 
 
 In the init function, put this code, where trigger is the first char that makes the commands recognizable:
 > this.commandManagar = new CommandManager(trigger);<br>
 
 
 And last thing: create the return method, always in the main class:
 > public CommandManager getCommandManager() { // Make it static if you don't use instances for your client <br>
 >		return commandManager;<br>
 > }
 ## Step 3 - Hooking Into Minecraft
 Replace the code in the void #sendChatMessage(String message) in the class net.minecraft.client.entity.EntityPlayerSP with this code:
> if (!(YourHackedClient.getInstance().getCommandManager().executeCommand(message))) { // Remove the getInstance() if you use it in a static way <br>
>		this.sendQueue.addToSendQueue(new C01PacketChatMessage(message));<br>
>		return;<br>
> }
 
 # Buy me a coffee
You can <a href="https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=seba14%40outlook.it&item_name=Buy+me+a+coffee&currency_code=EUR&source=url">donate me</a>, so that I can bring more stuff to github.
