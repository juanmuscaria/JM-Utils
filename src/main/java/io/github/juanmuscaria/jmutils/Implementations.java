package io.github.juanmuscaria.jmutils;

import com.sun.jna.Native;
import io.github.juanmuscaria.jmutils.discord.game.DiscordGameSDK;
import io.github.juanmuscaria.jmutils.discord.rcp.DiscordRCP;
import io.github.juanmuscaria.jmutils.minecraft.UserIdent;
import io.github.juanmuscaria.jmutils.utils.Reflection;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class will be an abstraction to be able to access things that need to be implemented on specific platforms.
 *
 * @author juanmuscaria
 */
public final class Implementations {
    private static UserIdent userIdentImp;
    private static DiscordGameSDK discordGameSDK;
    private static DiscordRCP discordRCP;

    //Seal class.
    private Implementations() {
    }

    /**
     * Register an implementation of UserIndent before using it.
     * If an implementation has already been registered it will be ignored.
     *
     * @param userIdent An object of a UserIndent implementation.
     */
    public static void registerImplementation(@NotNull UserIdent userIdent) {
        Objects.requireNonNull(userIdent);
        if (userIdentImp != null) userIdentImp = userIdent;
    }

    /**
     * Get an implementation of UserIndent.
     *
     * @return An object of a UserIndent implementation.
     * @throws IllegalStateException In case no implementation has been registered.
     */
    @NotNull
    public static UserIdent getUserIdentImp() {
        if (userIdentImp == null) throw new IllegalStateException("No implementation has been registered yet.");
        return userIdentImp;
    }

    public static DiscordGameSDK getDiscordGameSDK(){
        if (discordGameSDK != null)return discordGameSDK;
        discordGameSDK = Native.load("discord_game_sdk", DiscordGameSDK.class);
        return discordGameSDK;
    }

    public static DiscordRCP getDiscordRCP(){
        if (discordRCP != null)return discordRCP;
        discordRCP = Native.load("discord-rpc", DiscordRCP.class);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

        }));
        return discordRCP;
    }

    public static boolean hasForge(){
        return Reflection.doesClassExist("net.minecraftforge.common.ForgeVersion");
    }

    public static boolean hasMCPCPlus(){
        return Reflection.doesClassExist("za.co.mcportcentral.MCPCHooks");
    }

    public static boolean hasCauldron(){
        return Reflection.doesClassExist("net.minecraftforge.cauldron.CauldronUtils");
    }

    public static boolean hasThermos(){
        return Reflection.doesClassExist("thermos.Thermos");
    }

    public static boolean hasBukkit(){
        return Reflection.doesClassExist("org.bukkit.Bukkit");
    }

}
