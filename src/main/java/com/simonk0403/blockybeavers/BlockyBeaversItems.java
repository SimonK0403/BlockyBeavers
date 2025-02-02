package com.simonk0403.blockybeavers;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class BlockyBeaversItems {
    private BlockyBeaversItems() {}

    public static final Item BEAVER_SPAWN_EGG = register(
            "beaver_spawn_egg",
            settings -> new SpawnEggItem(BlockyBeaversEntities.BEAVER, 0x502c1a, 0x141414, settings),
            new Item.Settings()
    );

    public static final Item RAW_BEAVER = register(
            "raw_beaver",
            new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).build())
    );

    public static final Item COOKED_BEAVER = register(
            "cooked_beaver",
            new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build())
    );

    public static final Item BEAVER_FUR = register(
            "beaver_fur",
            new Item.Settings()
    );

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BlockyBeavers.MOD_ID, id));
    }

    public static Item register(String id, Item.Settings settings) {
        return register(id, Item::new, settings);
    }

    public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(keyOf(id)));
        return Registry.register(Registries.ITEM, keyOf(id), item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(itemGroup -> itemGroup.add(BEAVER_SPAWN_EGG));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> itemGroup.addAfter(Items.COOKED_RABBIT, RAW_BEAVER, COOKED_BEAVER));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> itemGroup.addAfter(Items.RABBIT_HIDE, BEAVER_FUR));
    }
}
