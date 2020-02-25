package io.github.pebblecore.lobby;

import io.github.pebblecore.core.PebbleCore;
import io.github.pebblecore.core.bases.PItem;
import io.github.pebblecore.core.init.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import static io.github.pebblecore.core.init.CoreRegistryHandler.ItemRegistry.itemRegister;

public class LobbyRegistries {

    //Item Groups
    public static final ItemGroup PEBBLE_LOBBY = new ModItemGroups.ModItemGroup(PebbleCore.MODID, "lobby", () -> getTabItem());

    //Items
    public static final Item MENU_ITEM = itemRegister("menu_item", new PItem(new Item.Properties().group(PEBBLE_LOBBY)));

    //Blocks

    private static ItemStack getTabItem(){
        return new ItemStack(MENU_ITEM);
    }

}
