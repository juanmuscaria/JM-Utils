package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordActivity extends Structure {
    public int type;
    public long application_id;
    public byte[] name = new byte[128];
    public byte[] state = new byte[128];
    public byte[] details = new byte[128];
    public DiscordActivityTimestamps timestamps;
    public DiscordActivityAssets assets;
    public DiscordActivityParty party;
    public DiscordActivitySecrets secrets;
    public byte instance;

    public DiscordActivity() {
        super();
    }

    public DiscordActivity(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("type", "application_id", "name", "state", "details", "timestamps", "assets", "party", "secrets", "instance");
    }
}
