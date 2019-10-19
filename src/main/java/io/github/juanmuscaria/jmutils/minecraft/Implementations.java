package io.github.juanmuscaria.jmutils.minecraft;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author juanmuscaria
 * This class will be an abstraction to be able to access things that need to be implemented on specific platforms.
 */
public final class Implementations {
    private static UserIdent userIdentImp;

    /**
     * Register an implementation of UserIndent before using it.
     * If an implementation has already been registered it will be ignored.
     *
     * @param userIdent An object of a UserIndent implementation.
     */
    public static void registerImplementation(@NotNull UserIdent userIdent) {
        Objects.requireNonNull(userIdent);
        if (userIdentImp != null) userIdentImp = userIdent;
    }

    /**
     * Get an implementation of UserIndent.
     *
     * @return An object of a UserIndent implementation.
     * @throws IllegalStateException In case no implementation has been registered.
     */
    @NotNull
    public static UserIdent getUserIdentImp() {
        if (userIdentImp == null) throw new IllegalStateException();
        return userIdentImp;
    }
}
