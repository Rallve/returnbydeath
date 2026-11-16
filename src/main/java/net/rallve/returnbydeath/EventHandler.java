package net.rallve.returnbydeath;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.network.ServerPlayerEntity;

public class EventHandler {
    public static void register() {
        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, v) -> {
            if (entity instanceof ServerPlayerEntity player) {
                PlayerInventory inventory = player.getInventory();
                //ReturnByDeath.LOGGER.info("Before death: {}", inventory.isEmpty());

                player.setHealth(20);
                player.teleport(player.getServerWorld(), 0, 300, 0, 0, 0);

                return false;
            }
            return true;
        });
        // Maybe repurpose the file or move save triggers to a different file
        EntitySleepEvents.STOP_SLEEPING.register((entity, sleepingPos) -> {
            // Trigger save
        });
        // Seems like I may need to use mixins to react to an advancement
    }
}
