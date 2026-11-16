package net.rallve.returnbydeath;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class Commands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("checkpoint")
                            .requires(source -> source.hasPermissionLevel(2)) // ops only
                            .executes(commandContext -> {
                                // trigger save
                                commandContext.getSource().sendFeedback(() -> Text.literal("Checkpoint created"), false);
                                return 1;
                            })
            );
        });
    }
}
