package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class DiscordEntitlement extends Structure {
    public long id;
    public int type;
    public long sku_id;

    public DiscordEntitlement() {
        super();
    }

    public DiscordEntitlement(long id, int type, long sku_id) {
        super();
        this.id = id;
        this.type = type;
        this.sku_id = sku_id;
    }

    public DiscordEntitlement(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("id", "type", "sku_id");
    }
}
