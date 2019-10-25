package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordInputMode extends Structure {
    public int type;
    public byte[] shortcut = new byte[256];

    public DiscordInputMode(int type, byte[] shortcut) {
        super();
        this.type = type;
        if ((shortcut.length != this.shortcut.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.shortcut = shortcut;
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("type", "shortcut");
    }
}
