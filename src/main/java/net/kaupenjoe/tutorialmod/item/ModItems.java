package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.entity.ModEntities;
import net.kaupenjoe.tutorialmod.item.custom.EightBallItem;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    public static final Item EIGHT_BALL = registerItem("eight_ball",
            new EightBallItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(1)));
    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP,
                    new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(4f).build())));

    public static final Item KAUPENSWORD = registerItem("kaupensword",
            new SwordItem(ToolMaterials.DIAMOND, 10, 5f,
                    new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(1)));

    public static final Item CHOMPER_SPAWN_EGG = registerItem("chomper_spawn_egg",
            new SpawnEggItem(ModEntities.CHOMPER,0x22b341, 0x19732e,
                    new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    public static final Item TANZANITE_PICKAXE = registerItem("tanzanite_pickaxe",
            new PickaxeItem(ModToolMaterial.TANZANITE, 4, 2f,
                    new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.debug("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
