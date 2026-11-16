package net.rallve.returnbydeath.saving;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;

public class World {
    public static void register() {
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            chunk.
        });
    }
}
