package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordActivityTimestamps extends Structure {
    public long start;
    public long end;

    public DiscordActivityTimestamps(long start, long end) {
        super();
        this.start = start;
        this.end = end;
    }

    public DiscordActivityTimestamps(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("start", "end");
    }

}
