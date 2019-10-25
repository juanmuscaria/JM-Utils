package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordFileStat extends Structure {
    public byte[] filename = new byte[260];
    public long size;
    public long last_modified;

    public DiscordFileStat(byte[] filename, long size, long last_modified) {
        super();
        if ((filename.length != this.filename.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.filename = filename;
        this.size = size;
        this.last_modified = last_modified;
    }

    public DiscordFileStat(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("filename", "size", "last_modified");
    }
}
