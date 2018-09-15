package com.rbnsmls.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class Main extends JavaPlugin implements Listener {

    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective obj = board.registerNewObjective("Online", "Player");

        obj.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Player Info");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score = obj.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.BLUE + "" + ChatColor.BOLD + "Online: " + ChatColor.YELLOW + "" + ChatColor.BOLD + Bukkit.getOnlinePlayers().size()));
        score.setScore(1);

        for(Player p1 : Bukkit.getServer().getOnlinePlayers()){
            p1.setScoreboard(manager.getNewScoreboard());
            p1.setScoreboard(board);
        }
    }

    @EventHandler
    public void move(PlayerQuitEvent e){

        Player p = e.getPlayer();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("Kills", "Player");

        obj.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Player Info");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);



        Score score = obj.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.BLUE + "" + ChatColor.BOLD + "Online: " + ChatColor.YELLOW + "" + ChatColor.BOLD + (Bukkit.getOnlinePlayers().size() - 1)));
        score.setScore(1);
        for(Player p1 : Bukkit.getServer().getOnlinePlayers()){
            p1.setScoreboard(manager.getNewScoreboard());
            p1.setScoreboard(board);
        }
    }

}
