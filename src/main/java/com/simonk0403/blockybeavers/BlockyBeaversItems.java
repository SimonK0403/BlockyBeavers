package com.simonk0403.blockybeavers;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
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

    public static final Item RAW_BEAVER = register(
            new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).build())),
            "raw_beaver"
    );

    public static final Item COOKED_BEAVER = register(
            new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build())),
            "cooked_beaver"
    );

    public static Item register(Item item, String id) {
        Identifier itemId = Identifier.of(BlockyBeavers.MOD_ID, id);

        return Registry.register(Registries.ITEM, itemId, item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register((itemGroup) -> itemGroup.add(BEAVER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(RAW_BEAVER));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(COOKED_BEAVER));
    }
}
