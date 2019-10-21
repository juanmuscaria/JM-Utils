package io.github.juanmuscaria.jmutils.minecraft.bukkit;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class BukkitUtils {

    public static int getPermissionInteger(@NotNull String node, @NotNull Player player) {
        if (player.hasPermission(node + ".unlimited")) return Integer.MAX_VALUE;
        int nodeInt = 0;
        int len = node.split("\\.").length;
        for (PermissionAttachmentInfo perm : player.getEffectivePermissions()) {
            String pn = perm.getPermission();
            if (pn.startsWith(node + ".")) {
                int foundInt = Integer.parseInt(pn.split("\\.")[len]);
                if (foundInt > nodeInt) {
                    nodeInt = foundInt;
                }
            }
        }
        return nodeInt;
    }

    public static String getProvider(Class<?> clazz) {
        String provider = "Unknown";
        Plugin plugin = JavaPlugin.getProvidingPlugin(clazz);
        if (plugin != null) provider = plugin.getName();
        else {
            if (clazz.getName().startsWith("net.minecraftforge")) provider = "forge";
            else if (clazz.getName().startsWith("net.minecraft")) provider = "minecraft";
            else if (clazz.getName().startsWith("org.bukkit") || clazz.getName().startsWith("org.spigotmc"))
                provider = "bukkit";
        }
        return provider;
    }
}
