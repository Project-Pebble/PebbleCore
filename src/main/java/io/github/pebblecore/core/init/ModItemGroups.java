package io.github.pebblecore.core.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups {

    public static class ModItemGroup extends ItemGroup {

        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(final String modID, final String name, Supplier<ItemStack> iconSupplier){
            super(modID + "." + name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon(){
            return iconSupplier.get();
        }

    }
}
