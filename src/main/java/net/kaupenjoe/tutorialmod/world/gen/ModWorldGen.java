package net.kaupenjoe.tutorialmod.world.gen;

import net.kaupenjoe.tutorialmod.entity.ModEntities;

public class ModWorldGen {
    public static void generateWorldGen() {
        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();

        ModEntitySpawn.addEntitySpawn();
    }
}
