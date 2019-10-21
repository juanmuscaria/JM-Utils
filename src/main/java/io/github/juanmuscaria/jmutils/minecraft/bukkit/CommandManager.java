package io.github.juanmuscaria.jmutils.minecraft.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * A versatile command manager.
 * Generates a configuration file on demand and allows the end user to modify various aspects of the command.
 *
 * @author juanmuscaria.
 */
public final class CommandManager {
    private Plugin plugin;
    private ConfigYaml config;

    /**
     * Creates a new instance of the command manager.
     *
     * @param plugin Your plugin instance.
     */
    public CommandManager(Plugin plugin) {
        this(plugin, "CommandManager");
    }

    /**
     * Creates a new instance of the command manager.
     *
     * @param plugin     Your plugin instance.
     * @param configName Name of the command settings file.
     */
    public CommandManager(Plugin plugin, String configName) {
        this.plugin = plugin;
        config = new ConfigYaml(new File(plugin.getDataFolder(), configName + ".yml"));
        config.reloadConfig();
    }


    /**
     * Register a command.
     * Ff there are no settings it will generate new settings.
     * If the command is disabled in the settings it will not be registered.
     *
     * @param command The command to register.
     */
    public void registerCommand(AbstractCommand command) {
        String name = command.getClass().getSimpleName();
        YamlConfiguration yaml = config.getYaml();
        generateConfigForCommand(command);
        if (yaml.getBoolean("commands." + name + ".enable")) {
            try {
                Constructor<PluginCommand> pluginCommandConstructor =
                        PluginCommand.class.getDeclaredConstructor(String.class, Plugin.class);
                pluginCommandConstructor.setAccessible(true);
                PluginCommand pluginCommand = pluginCommandConstructor.newInstance(command.getLabel(), plugin);
                pluginCommand.setAliases(command.getAliases());
                pluginCommand.setPermission(command.getPermissionNode());
                pluginCommand.setPermissionMessage(command.getPermissionMessage());
                pluginCommand.setDescription(command.getDescription());
                pluginCommand.setExecutor(command);
                pluginCommand.setTabCompleter(command.getTabCompleter());
                Field commandMapField = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
                commandMapField.setAccessible(true);
                CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getPluginManager());
                commandMap.register(plugin.getName().toLowerCase(), pluginCommand);
                command.pluginCommand = pluginCommand;
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }

    }

    @Deprecated
    public void registerExecutor(String command, CommandExecutor executor, @Nullable TabCompleter tabCompleter) {
        if (!config.getYaml().contains("commands." + command))
            generateConfigForCommand(command);
        if (config.getYaml().getBoolean("commands." + command + ".enable")) {
            String label = config.getYaml().getString("commands." + command + ".label");
            List<String> aliases = config.getYaml().getStringList("commands." + command + ".aliases");
            String description = config.getYaml().getString("commands." + command + ".description");
            String permissionMessage = config.getYaml().getString("commands." + command + ".permissionMessage")
                    .replace('&', '§');
            String permission = config.getYaml().getString("commands" + command + ".permissionNode");
            try {
                Constructor<PluginCommand> pluginCommandConstructor =
                        PluginCommand.class.getDeclaredConstructor(String.class, Plugin.class);
                pluginCommandConstructor.setAccessible(true);
                PluginCommand pluginCommand = pluginCommandConstructor.newInstance(label, plugin);
                pluginCommand.setAliases(aliases);
                pluginCommand.setPermission(permission);
                pluginCommand.setPermissionMessage(permissionMessage);
                pluginCommand.setDescription(description);
                pluginCommand.setExecutor(executor);
                if (!(tabCompleter == null)) pluginCommand.setTabCompleter(tabCompleter);
                Field commandMapField = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
                commandMapField.setAccessible(true);
                CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getPluginManager());
                commandMap.register(plugin.getName().toLowerCase(), pluginCommand);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
    }

    //Generates the settings for the command.
    private void generateConfigForCommand(String command) {
        YamlConfiguration yaml = config.getYaml();
        if (!yaml.contains("commands." + command + ".enable"))
            yaml.set("commands." + command + ".enable", true);
        if (!yaml.contains("commands." + command + ".label"))
            yaml.set("commands." + command + ".label", command);
        if (!yaml.contains("commands." + command + ".aliases"))
            yaml.set("commands." + command + ".aliases", new ArrayList<String>());
        if (!yaml.contains("commands." + command + ".description"))
            yaml.set("commands." + command + ".description", "Autogenerated by CmdManager.");
        if (!yaml.contains("commands." + command + ".permissionMessage"))
            yaml.set("commands." + command + ".permissionMessage", "&cI'm sorry but you do not have permission to perform this command. Please contact the server administrator if you believe that this is in error.");
        if (!yaml.contains("commands." + command + ".permissionNode"))
            yaml.set("commands." + command + ".permissionNode", "void.commands." + command);
        config.save();
    }

    //Generates the settings for the command.
    private void generateConfigForCommand(AbstractCommand command) {
        String name = command.getClass().getSimpleName();
        YamlConfiguration yaml = config.getYaml();
        if (!yaml.contains("commands." + name + ".enable"))
            yaml.set("commands." + name + ".enable", true);
        if (!yaml.contains("commands." + name + ".label"))
            yaml.set("commands." + name + ".label", command.getLabel());
        if (!yaml.contains("commands." + name + ".aliases"))
            yaml.set("commands." + name + ".aliases", command.getAliases());
        if (!yaml.contains("commands." + name + ".description"))
            yaml.set("commands." + name + ".description", command.getDescription());
        if (!yaml.contains("commands." + name + ".permissionMessage"))
            yaml.set("commands." + name + ".permissionMessage", command.getPermissionMessage());
        if (!yaml.contains("commands." + name + ".permissionNode"))
            yaml.set("commands." + name + ".permissionNode", command.getPermissionNode());
        command.setLabel(yaml.getString("commands." + name + ".label"));
        command.setAliases(yaml.getStringList("commands." + name + ".aliases"));
        command.setDescription(yaml.getString("commands." + name + ".description"));
        command.setPermissionMessage(yaml.getString("commands." + name + ".permissionMessage"));
        command.setPermissionNode(yaml.getString("commands." + name + ".permissionNode"));
        config.save();
    }

}
