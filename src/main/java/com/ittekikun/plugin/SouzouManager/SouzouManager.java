package com.ittekikun.plugin.SouzouManager;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SouzouManager extends JavaPlugin
{
    @Override
    public void onEnable()
    {

    }

    @Override
    public void onDisable()
    {

    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event)
    {
        if(event.getPlayer().hasPlayedBefore());
        {

            Location location = new Location(event.getPlayer().getWorld(), 50, 50, 80);
            event.getPlayer().teleport(location);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("tpm"))
        {
            if(!(args.length == 1))
            {
                return false;
            }
            if(sender instanceof Player)
            {
                Player player = getServer().getPlayer(args[0]);
                if(player == null)
                {
                    return false;
                }

                ((Player)sender).teleport(player.getLocation());

                return true;
            }
        }
        if(cmd.getName().equalsIgnoreCase("tph"))
        {
            if(!(args.length == 1))
            {
                return false;
            }
            if(sender instanceof Player)
            {
                Player player = getServer().getPlayer(args[0]);
                if(player == null)
                {
                    return false;
                }

                player.teleport(((Player)sender).getLocation());

                return true;
            }
        }
        if(cmd.getName().equalsIgnoreCase("tpp"))
        {
            if(!(args.length == 2))
            {
                return false;
            }
            Player player1 = getServer().getPlayer(args[0]);
            Player player2 = getServer().getPlayer(args[1]);
            if(player1 == null || player2 == null)
            {
                return false;
            }

            player1.teleport(player2.getLocation());
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("gm"))
        {
            if(sender instanceof Player)
            {
                if(((Player)sender).getGameMode() == GameMode.CREATIVE)
                {
                    ((Player)sender).setGameMode(GameMode.SURVIVAL);
                    return true;
                }
                else if(((Player)sender).getGameMode() == GameMode.SURVIVAL)
                {
                    ((Player)sender).setGameMode(GameMode.CREATIVE);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}