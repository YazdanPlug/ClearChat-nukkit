package ir.yzplug.ClearChat;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;

public class ClearChat extends PluginBase {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getLogger().info("This Plugin Enabled!");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("clearchat.use")) {
                for(int i = 0; i < 100; ++i) {
                    Server.getInstance().broadcastMessage("");
                }
                Server.getInstance().broadcastMessage(this.getConfig().getString("Chat-Cleared").replace("%player%", player.getDisplayName()));
                return true;
            } else {
                player.sendMessage(this.getConfig().getString("No-Permission-Message"));
                return false;
            }
        } else {
            for(int i = 0; i < 100; ++i) {
                Server.getInstance().broadcastMessage("");
            }
            Server.getInstance().broadcastMessage(this.getConfig().getString("Cleared-By-Console"));
            return true;
        }
    }
    @Override
    public void onDisable() { this.getLogger().info("This Plugin Disabled!"); }
}