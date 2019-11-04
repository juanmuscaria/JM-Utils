package io.github.juanmuscaria.jmutils.minecraft.bukkit.commands;

public class CommandException {
    public static class CommandProcessorException extends Exception {
        CommandProcessorException(String reason) {
            super(reason);
        }

        CommandProcessorException(String reason, Exception ex) {
            super(reason, ex);
        }
    }

    static class CommandExecutionException extends Exception {
        CommandExecutionException(String reason) {
            super(reason);
        }

        CommandExecutionException(String reason, Exception ex) {
            super(reason, ex);
        }
    }

    static class CommandRegistrationException extends CommandProcessorException {
        CommandRegistrationException(String reason) {
            super(reason);
        }

        CommandRegistrationException(String reason, Exception ex) {
            super(reason, ex);
        }
    }
}
