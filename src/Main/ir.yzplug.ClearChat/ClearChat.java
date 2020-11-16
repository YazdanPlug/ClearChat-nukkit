package ir.yzplug.ClearChat;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class ClearChat extends PluginBase {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getLogger().info("This Plugin Enabled!");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("clearchat.use")) {
                for(int i = 0; i < 100; ++i) {
                    Server.getInstance().broadcastMessage("");
                }
                Server.getInstance().broadcastMessage(this.getConfig().getString("Chat-Cleared").replace("{player}", p.getDisplayName()));
                return true;
            } else {
                p.sendMessage(this.getConfig().getString("You don't have Premission this Command"));
                return false;
            }
        } else {
            for(int i = 0; i < 100; ++i) {
                Server.getInstance().broadcastMessage("");
            }
            Server.getInstance().broadcastMessage(this.getConfig().getString("Cleared by Console"));
            return true;
        }
    }
}
