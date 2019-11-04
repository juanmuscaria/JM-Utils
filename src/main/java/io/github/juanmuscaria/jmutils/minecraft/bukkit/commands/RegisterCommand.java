package io.github.juanmuscaria.jmutils.minecraft.bukkit.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterCommand {
    String label();

    String[] aliases() default {};

    String description() default "";

    String permissionMessage() default "&cI'm sorry but you do not have permission to perform this command. " +
            "Please contact the server administrator if you believe that this is in error.";

    String permissionNode();

    Class<? extends TabCompleter>[] tabCompleter() default {};

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Executor {
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface HelpMessage {
    }

    @interface TabCompleter {
    }

}
