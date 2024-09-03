package com.simonk0403.blockybeavers;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockyBeaversItems {
    public static final Item BEAVER_SPAWN_EGG = register(
            new SpawnEggItem(BlockyBeaversEntities.BEAVER, 0x502c1a, 0x141414, new Item.Settings()),
            "beaver_spawn_egg"
    );

    public static Item register(Item item, String id) {
        Identifier itemId = Identifier.of(BlockyBeavers.MOD_ID, id);

        return Registry.register(Registries.ITEM, itemId, item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register((itemGroup) -> itemGroup.add(BEAVER_SPAWN_EGG));
    }
}
