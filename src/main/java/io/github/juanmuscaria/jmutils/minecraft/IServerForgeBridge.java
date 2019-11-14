package io.github.juanmuscaria.jmutils.minecraft;

/**
 * A bridge to communicate with things from Forge (Server).
 *
 * @author juanmuscaria
 */
public interface IServerForgeBridge {
    /**
     * Checks if a player is a FakePlayer.
     *
     * @param player The Player object.
     * @return Returns true if the player is a FakePlayer.
     */
    boolean isFakePlayer(Object player);

    /**
     * Checks if a player is a FeatherFakePlayer.
     *
     * @param player The Player object.
     * @return Returns true if the player is a FeatherFakePlayer.
     */
    boolean isFeatherFakePlayer(Object player);

    /**
     * Get the owner of the FeatherFakePlayer.
     *
     * @param player The FeatherFakePlayer object.
     * @return The owner UserIdent.
     * @throws IllegalArgumentException If the player parameter is not an instance of FeatherFakePlayer.
     */
    UserIdent getFeatherFakePlayerOwner(Object player);

    /**
     * Close any container and GuiScreen in the player.
     *
     * @param player The Player object.
     * @throws IllegalArgumentException If the player parameter is not an instance of EntityPlayerMP.
     */
    void closeOpenScreen(Object player);

    /**
     * Checks if the player has an open container
     *
     * @param player The Player object.
     * @return Returns true if open container is not the player's inventory.
     * @throws IllegalArgumentException If the player parameter is not an instance of EntityPlayerMP.
     */
    boolean hasOpenContainer(Object player);

    /**
     * Get the class name of the open container.
     *
     * @param player The Player object.
     * @return The open container class name.
     * @throws IllegalArgumentException If the player parameter is not an instance of EntityPlayerMP.
     */
    String getOpenContainerName(Object player);
}
