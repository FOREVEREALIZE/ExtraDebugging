package me.foreverealize.mods.extradebugging;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtraDebuggingCommand {
    private static final Logger LOGGER = LogManager.getLogger();

    private static Integer markerAmount = 0;

    static LiteralArgumentBuilder<CommandSource> command = Commands.literal("extradebugging")
            .then(Commands.literal("marker")
                    .then(Commands.literal("add")
                            .executes(commandContext -> addMarker(commandContext))
                    )
            );

    @SubscribeEvent
    public static void onRegisterCommandEvent(RegisterCommandsEvent e) {
        CommandDispatcher<CommandSource> commandDispatcher = e.getDispatcher();

        register(commandDispatcher);
    }

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(command);
    }

    public static int addMarker(CommandContext<CommandSource> ctx) {
        markerAmount++;

        LOGGER.info("Marker Number " + markerAmount);

        return 1;
    }
}
