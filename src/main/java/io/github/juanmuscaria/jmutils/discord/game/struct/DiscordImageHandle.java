package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordImageHandle extends Structure {
    public int type;
    public long id;
    public int size;

    public DiscordImageHandle(int type, long id, int size) {
        super();
        this.type = type;
        this.id = id;
        this.size = size;
    }

    public DiscordImageHandle(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("type", "id", "size");
    }
}
