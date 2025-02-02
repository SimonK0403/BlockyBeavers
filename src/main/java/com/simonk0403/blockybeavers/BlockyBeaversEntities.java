package com.simonk0403.blockybeavers;

import com.simonk0403.blockybeavers.entity.BeaverEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;

import static com.simonk0403.blockybeavers.BlockyBeavers.MOD_ID;

@SuppressWarnings("ConstantConditions")
public class BlockyBeaversEntities {
    private BlockyBeaversEntities() {}

    public static final String BEAVER_ID = "beaver";

    public static final EntityType<BeaverEntity> BEAVER = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, BEAVER_ID),
            EntityType.Builder.create(BeaverEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build(keyOf(BEAVER_ID))
    );

    private static RegistryKey<EntityType<?>> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, id));
    }

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(BEAVER, BeaverEntity.createBeaverAttributes());
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                SpawnGroup.CREATURE,
                BEAVER,
                10, 3, 5
        );
    }
}
