package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordActivityParty extends Structure {
    public byte[] id = new byte[128];
    public DiscordPartySize size;

    public DiscordActivityParty(byte[] id, DiscordPartySize size) {
        super();
        if ((id.length != this.id.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.id = id;
        this.size = size;
    }

    public DiscordActivityParty(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("id", "size");
    }
}
