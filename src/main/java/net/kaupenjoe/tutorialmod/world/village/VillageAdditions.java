package net.kaupenjoe.tutorialmod.world.village;

import fzzyhmstrs.structurized_reborn.impl.FabricStructurePoolRegistry;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.util.Identifier;

public class VillageAdditions {
    // Using https://github.com/fzzyhmstrs/structurized-reborn (Under MIT License)
    public static void registerNewVillageStructures() {
        FabricStructurePoolRegistry.registerSimple(
                new Identifier("minecraft:village/plains/houses"),
                new Identifier(TutorialMod.MOD_ID, "plains_jump_master"),
                150
        );
    }
}
