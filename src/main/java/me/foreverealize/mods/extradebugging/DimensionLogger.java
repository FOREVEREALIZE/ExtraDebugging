package me.foreverealize.mods.extradebugging;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DimensionLogger {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onDimensionLoaded(EntityTravelToDimensionEvent event) {
        if (event.getEntity().getType() == EntityType.PLAYER) {
            LOGGER.info("Player " + event.getEntity().getDisplayName().getString() + " with UUID " + event.getEntity().getUniqueID() + " entered dimension " + event.getDimension().getLocation());
        }
    }
}