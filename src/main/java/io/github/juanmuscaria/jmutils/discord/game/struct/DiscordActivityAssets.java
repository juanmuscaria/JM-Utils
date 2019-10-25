package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordActivityAssets extends Structure {
    public byte[] large_image = new byte[128];
    public byte[] large_text = new byte[128];
    public byte[] small_image = new byte[128];
    public byte[] small_text = new byte[128];

    public DiscordActivityAssets(byte[] large_image, byte[] large_text, byte[] small_image, byte[] small_text) {
        super();
        if ((large_image.length != this.large_image.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.large_image = large_image;
        if ((large_text.length != this.large_text.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.large_text = large_text;
        if ((small_image.length != this.small_image.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.small_image = small_image;
        if ((small_text.length != this.small_text.length))
            throw new IllegalArgumentException("Wrong array size !");
        this.small_text = small_text;
    }

    public DiscordActivityAssets(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("large_image", "large_text", "small_image", "small_text");
    }
}
