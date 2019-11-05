package io.github.juanmuscaria.jmutils.minecraft.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

//Baseado no "https://github.com/RUSHyoutuber/System"
@Deprecated
public class CommandRegister {

    public static void register(String command, String permission, @NotNull CommandExecutor commandExecutor, @NotNull YamlConfiguration config, @NotNull JavaPlugin plugin, @Nullable TabCompleter tabCompleter) {
        boolean enable = config.getBoolean("commands." + command + ".enable");
        if (enable) {
            List<String> aliases = config.getStringList("commands." + command + ".aliases");
            String description = config.getString("commands." + command + ".description");
            String permissionMessage = config.getString("commands." + command + ".permissionmessage").replace('&', '§');
            PluginCommand pluginCommand = createPluginCommand(command, aliases, permission, permissionMessage, description, commandExecutor, plugin, tabCompleter);
            registerPluginCommand(pluginCommand, plugin);
        }
    }

    @Nullable
    private static PluginCommand createPluginCommand(String command, List<String> aliases, String permission, String permissionMessage, String description, CommandExecutor executor, JavaPlugin plugin, @Nullable TabCompleter tabCompleter) {
        try {
            Constructor<PluginCommand> c = PluginCommand.class.getDeclaredConstructor(String.class, Plugin.class);
            c.setAccessible(true);

            PluginCommand cmd = c.newInstance(command, plugin);
            cmd.setAliases(aliases);
            cmd.setPermission(permission);
            cmd.setPermissionMessage(permissionMessage);
            cmd.setDescription(description);
            cmd.setExecutor(executor);
            if (!(tabCompleter == null)) cmd.setTabCompleter(tabCompleter);
            return cmd;
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void registerPluginCommand(PluginCommand pluginCommand, JavaPlugin plugin) {
        if (pluginCommand == null) return;

        try {
            Field f = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);

            Object commandMapObject = f.get(Bukkit.getPluginManager());
            if (commandMapObject instanceof CommandMap) {
                CommandMap commandMap = (CommandMap) commandMapObject;
                commandMap.register(plugin.getName().toLowerCase(), pluginCommand);
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
