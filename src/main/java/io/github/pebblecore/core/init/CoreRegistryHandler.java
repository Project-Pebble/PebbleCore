package io.github.pebblecore.core.init;

import io.github.pebblecore.core.PebbleCore;
import io.github.pebblecore.core.bases.PItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

public class CoreRegistryHandler {

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PebbleCore.MODID)
    public static class ItemRegistry{
        public static final List<Item> ITEMS = new ArrayList<>();

        public static Item itemRegister(String name, Item item) {
            item.setRegistryName(name);
            ITEMS.add(item);
            return item;
        }

        @SubscribeEvent
        @SuppressWarnings("unused")
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            ITEMS.forEach(item -> event.getRegistry().register(item));
            ITEMS.clear();
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PebbleCore.MODID)
    public static class BlockRegistry{
        public static final List<Block> BLOCKS = new ArrayList<>();
        public static final List<Item> ITEMS = new ArrayList<>();

        public static Block blockRegister(String name, Block block, ItemGroup group) {
            return blockRegister(name, block, new Item.Properties().group(group));
        }

        public static Block blockRegister(String name, Block block, Item.Properties properties) {
            return blockRegister(name, block, new BlockItem(block, properties));
        }

        public static Block blockRegister(String name, Block block, BlockItem item) {
            block.setRegistryName(name);
            BLOCKS.add(block);
            if (block.getRegistryName() != null) {
                item.setRegistryName(name);
                ITEMS.add(item);
            }
            return block;
        }

        @SubscribeEvent
        @SuppressWarnings("unused")
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            BLOCKS.forEach(block -> event.getRegistry().register(block));
            BLOCKS.clear();
        }

        @SubscribeEvent
        @SuppressWarnings("unused")
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            ITEMS.forEach(item -> event.getRegistry().register(item));
            ITEMS.clear();
        }
    }

}
