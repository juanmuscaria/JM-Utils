package io.github.juanmuscaria.jmutils.discord.game.struct;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class Application extends Structure {
    public IDiscordCore core;
    public IDiscordUserManager users;
    public IDiscordAchievementManager achievements;
    public IDiscordActivityManager activities;
    public IDiscordRelationshipManager relationships;
    public IDiscordApplicationManager application;
    public IDiscordLobbyManager lobbies;
    public DiscordUser user;

    protected List<String> getFieldOrder() {
        return Arrays.asList("core", "users", "achievements", "activities", "relationships", "application", "lobbies", "user");
    }
}
