package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

public class DiscordCreateParams extends Structure {
    public long client_id;
    public long flags;
    public PointerByReference events;
    public Pointer event_data;
    public PointerByReference application_events;
    public int application_version;
    public IDiscordUserEvents.ByReference user_events;
    public int user_version;
    public PointerByReference image_events;
    public int image_version;
    public IDiscordActivityEvents.ByReference activity_events;
    public int activity_version;
    public IDiscordRelationshipEvents.ByReference relationship_events;
    public int relationship_version;
    public IDiscordLobbyEvents.ByReference lobby_events;
    public int lobby_version;
    public IDiscordNetworkEvents.ByReference network_events;
    public int network_version;
    public IDiscordOverlayEvents.ByReference overlay_events;
    public int overlay_version;
    public PointerByReference storage_events;
    public int storage_version;
    public IDiscordStoreEvents.ByReference store_events;
    public int store_version;
    public IDiscordVoiceEvents.ByReference voice_events;
    public int voice_version;
    public IDiscordAchievementEvents.ByReference achievement_events;
    public int achievement_version;

    public DiscordCreateParams(Pointer peer) {
        super(peer);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("client_id", "flags", "events", "event_data", "application_events", "application_version", "user_events", "user_version", "image_events", "image_version", "activity_events", "activity_version", "relationship_events", "relationship_version", "lobby_events", "lobby_version", "network_events", "network_version", "overlay_events", "overlay_version", "storage_events", "storage_version", "store_events", "store_version", "voice_events", "voice_version", "achievement_events", "achievement_version");
    }
}
