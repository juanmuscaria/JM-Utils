package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordActivitySecrets extends Structure {
    public byte[] match = new byte[128];
    public byte[] join = new byte[128];
    public byte[] spectate = new byte[128];

    public DiscordActivitySecrets(byte[] match, byte[] join, byte[] spectate) {
        super();
        if ((match.length != this.match.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.match = match;
        if ((join.length != this.join.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.join = join;
        if ((spectate.length != this.spectate.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.spectate = spectate;
    }

    public DiscordActivitySecrets(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("match", "join", "spectate");
    }
}
