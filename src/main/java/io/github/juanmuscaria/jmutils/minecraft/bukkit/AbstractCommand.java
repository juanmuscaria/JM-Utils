package io.github.juanmuscaria.jmutils.minecraft.bukkit;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;

import java.util.List;

/**
 * A base class to use for creating commands.
 */
public abstract class AbstractCommand implements CommandExecutor {
    PluginCommand pluginCommand;
    private String label;
    private List<String> aliases;
    private String description;
    private String permissionMessage = "&cI'm sorry but you do not have permission to perform this command. " +
            "Please contact the server administrator if you believe that this is in error.";
    private String permissionNode;
    private TabCompleter tabCompleter = null;

    public String getLabel() {
        return label;
    }

    protected void setLabel(String label) {
        this.label = label;
    }

    public List<String> getAliases() {
        return aliases;
    }

    protected void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getPermissionMessage() {
        return permissionMessage;
    }

    protected void setPermissionMessage(String permissionMessage) {
        this.permissionMessage = permissionMessage;
    }

    public String getPermissionNode() {
        return permissionNode;
    }

    protected void setPermissionNode(String permissionNode) {
        this.permissionNode = permissionNode;
    }

    public TabCompleter getTabCompleter() {
        return tabCompleter;
    }

    protected void setTabCompleter(TabCompleter tabCompleter) {
        this.tabCompleter = tabCompleter;
    }

}
