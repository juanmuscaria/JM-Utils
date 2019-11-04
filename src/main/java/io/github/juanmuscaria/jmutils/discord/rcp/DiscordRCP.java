package io.github.juanmuscaria.jmutils.discord.rcp;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import io.github.juanmuscaria.jmutils.discord.rcp.struct.DiscordEventHandlers;
import io.github.juanmuscaria.jmutils.discord.rcp.struct.DiscordRichPresence;

public interface DiscordRCP extends Library {

    @Deprecated
    void Discord_Initialize(Pointer applicationId, DiscordEventHandlers handlers, int autoRegister, Pointer optionalSteamId);

    void Discord_Initialize(String applicationId, DiscordEventHandlers handlers, int autoRegister, String optionalSteamId);

    void Discord_Shutdown();

    void Discord_RunCallbacks();

    void Discord_UpdatePresence(DiscordRichPresence presence);

    void Discord_ClearPresence();

    @Deprecated
    void Discord_Respond(Pointer userid, int reply);

    void Discord_Respond(String userid, int reply);

    void Discord_UpdateHandlers(DiscordEventHandlers handlers);

    void Discord_Register(String applicationId, String command);

    void Discord_RegisterSteamGame(String applicationId, String steamId);

    enum DiscordReply {
        No(0),
        Yes(1),
        Ignore(2);

        public final int reply;

        DiscordReply(int code) {
            reply = code;
        }
    }
}
