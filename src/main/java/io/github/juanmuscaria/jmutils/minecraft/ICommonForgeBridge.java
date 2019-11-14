package io.github.juanmuscaria.jmutils.minecraft;

/**
 * A bridge to communicate with things from Forge (Common).
 *
 * @author juanmuscaria
 */
public interface ICommonForgeBridge {
    /**
     * Checks if an item is banned.
     *
     * @param itemStack An ItemStack to verify.
     * @return True if the item is banned.
     * @throws IllegalArgumentException If the passed object is not an ItemStack.
     */
    boolean isItemBanned(Object itemStack);
}
