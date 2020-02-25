package io.github.pebblecore.core;

import com.mojang.brigadier.CommandDispatcher;
import io.github.pebblecore.lobby.LobbyRegistries;
import net.minecraft.command.CommandSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(PebbleCore.MODID)
public class PebbleCore {

    public static final Logger LOGGER = LogManager.getLogger(); //Logger for console output
    private final CommandDispatcher<CommandSource> dispatcher = new CommandDispatcher<>(); //Command Registry/Dispatcher
    public static final String //Mod Information Constants
            MODID = "pebblecore",
            NAME = "Pebble Core",
            VERSION = "0.0.0";

    public PebbleCore(){
        new LobbyRegistries();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(GlobalForgeEventHandler.class);
    }

    private void setup(final FMLCommonSetupEvent event){
        LOGGER.debug("PEBBLE CORE LOADED");
    }
}
