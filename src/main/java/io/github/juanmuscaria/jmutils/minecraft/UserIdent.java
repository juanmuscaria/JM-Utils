package io.github.juanmuscaria.jmutils.minecraft;

import com.mojang.authlib.GameProfile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * A class to represent a player, it must be immutable.
 * Based on {@link <a href="https://github.com/SleepyTrousers/EnderIO/blob/release/1.7.10/2.3/src/main/java/crazypants/util/UserIdent.java">EnderIO UserIdent</a>}.
 *
 * @author juanmuscaria
 */
public abstract class UserIdent {

    /**
     * Create a UserIdent from a UUID object and a name. Use this when reading
     * stored data, it will check for username changes, implement them and write a
     * log message.
     *
     * @param uuid       The UUID of the player.
     * @param playerName The name of the player.
     * @return An instance of UserIdent containing player data, if the given data is invalid, returns a Nobody UserIdent.
     */
    @NotNull
    public abstract UserIdent create(@Nullable UUID uuid, @Nullable String playerName);

    /**
     * Create a UserIdent from a UUID string and a name. Use this when reading
     * stored data, it will check for username changes, implement them and write a
     * log message.
     *
     * @param suuid      The UUID of the player.
     * @param playerName The name of the player.
     * @return An instance of UserIdent containing player data, if the given data is invalid, returns a Nobody UserIdent.
     */
    @NotNull
    public abstract UserIdent create(@NotNull String suuid, @Nullable String playerName);

    /**
     * Create a UserIdent from a GameProfile. Use this when creating a UserIdent
     * for a currently active player.
     *
     * @param gameProfile The Player's GameProfile.
     * @return An instance of UserIdent containing player data, if the given data is invalid, returns a Nobody UserIdent.
     */
    @NotNull
    public abstract UserIdent create(@Nullable GameProfile gameProfile);

    /**
     * Get the player's name stored in this object.
     *
     * @return The name of the player.
     */
    @NotNull
    public abstract String getPlayerName();

    /**
     * Get the player's UUID stored in this object.
     *
     * @return The UUID of the player.
     */
    @NotNull
    public abstract UUID getUUID();

    /**
     * Get the player's UUID stored in this object.
     *
     * @return The UUID of the player as String.
     */
    @NotNull
    public abstract String getUUIDString();

    /**
     * Checks if an NBTTagCompound contains a UserIndent.
     *
     * @param nbt    An instance of the NBTTagCompound to check.
     * @param prefix The prefix used to save the data in the tag.
     * @return True if the tag contains a UserIdent.
     */
    public abstract boolean existsInNbt(@NotNull Object nbt, @NotNull String prefix);

    /**
     * Saves this object to an NBTTagCompound.
     *
     * @param nbt    An instance of the NBTTagCompound to save.
     * @param prefix The prefix that will be used to save.
     */
    public abstract void saveToNbt(@NotNull Object nbt, @NotNull String prefix);

    /**
     * Read a UserIdent from an NBTTagCompound.
     *
     * @param nbt    An instance of the NBTTagCompound to read.
     * @param prefix The prefix used to save the data in the tag.
     * @return An instance of UserIdent containing player data, if the given data is invalid, returns a Nobody UserIdent.
     */
    @NotNull
    public abstract UserIdent readFromNbt(@NotNull Object nbt, @NotNull String prefix);

    /**
     * @return True if the implementation supports actions using NBTTag
     * eg. {@link UserIdent#readFromNbt(Object, String)}.
     */
    public abstract boolean supportNBTActions();

    /**
     * Nobody's representation,
     * used if it is not possible to create a representation of a player.
     *
     * @return An immutable object representing Nobody.
     */
    public abstract UserIdent getNobody();


}
