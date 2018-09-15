package com.rbnsmls.friendlyplugin;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // template for all plugins with command

    @Override
    public void onEnable(){
        getLogger().info("has been loaded...");
    }

    @Override
    public void onDisable(){
        getLogger().info("has been disabled...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("hi")
        || command.getName().equalsIgnoreCase("hello")
        || command.getName().equalsIgnoreCase("yo")){

            Random rand = new Random();

            int randomNumber = rand.nextInt(3) + 1;

            Player player = (Player) sender;

            if(randomNumber == 1){
                player.sendMessage(ChatColor.YELLOW + "Greetings, " + player.getDisplayName());
            } else if (randomNumber == 2){
                player.sendMessage(ChatColor.YELLOW + "Hello, " + player.getDisplayName() + "!");
            } else if (randomNumber == 3){
                player.sendMessage(ChatColor.YELLOW + "Hi there, " + player.getDisplayName() + "!");
            }

            return true;
        }

        return super.onCommand(sender, command, label, args);
    }
}