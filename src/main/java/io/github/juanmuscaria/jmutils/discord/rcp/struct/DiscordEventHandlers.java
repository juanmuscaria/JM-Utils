package io.github.juanmuscaria.jmutils.discord.rcp.struct;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordEventHandlers extends Structure {
    public DiscordEventHandlers.ready_callback ready;
    public DiscordEventHandlers.disconnected_callback disconnected;
    public DiscordEventHandlers.errored_callback errored;
    public DiscordEventHandlers.joinGame_callback joinGame;
    public DiscordEventHandlers.spectateGame_callback spectateGame;
    public DiscordEventHandlers.joinRequest_callback joinRequest;

    protected List<String> getFieldOrder() {
        return Arrays.asList("ready", "disconnected", "errored", "joinGame", "spectateGame", "joinRequest");
    }

    public interface ready_callback extends Callback {
        void apply(DiscordUser request);
    }

    public interface disconnected_callback extends Callback {
        void apply(int errorCode, Pointer message);
    }

    public interface errored_callback extends Callback {
        void apply(int errorCode, Pointer message);
    }

    public interface joinGame_callback extends Callback {
        void apply(String joinSecret);
    }

    public interface spectateGame_callback extends Callback {
        void apply(String spectateSecret);
    }

    public interface joinRequest_callback extends Callback {
        void apply(DiscordUser request);
    }
}
