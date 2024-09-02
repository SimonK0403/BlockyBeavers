package com.simonk0403.blockybeavers;

import com.simonk0403.blockybeavers.entity.BeaverEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.simonk0403.blockybeavers.BlockyBeavers.MOD_ID;

public class BlockyBeaversEntities {

    public static final EntityType<BeaverEntity> BEAVER = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "beaver"),
            EntityType.Builder.create(BeaverEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build("beaver")
    );

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(BEAVER, BeaverEntity.createBeaverAttributes());
    }
}
