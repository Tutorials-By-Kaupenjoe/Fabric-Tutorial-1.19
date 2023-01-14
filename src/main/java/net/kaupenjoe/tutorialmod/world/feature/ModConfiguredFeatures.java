package net.kaupenjoe.tutorialmod.world.feature;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> TANZANITE_ORE_KEY = registerKey("citrine_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> NETHER_TANZANITE_ORE_KEY = registerKey("nether_citrine_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> ENDSTONE_TANZANITE_ORE_KEY = registerKey("endstone_citrine_ore");

    public static final RegistryKey<ConfiguredFeature<?,?>> DOGWOOD_KEY = registerKey("dogwood");
    public static final RegistryKey<ConfiguredFeature<?,?>> DOGWOOD_SPAWN_KEY = registerKey("dogwood_spawn");

    public static final RegistryKey<ConfiguredFeature<?,?>> TANZANITE_GEODE_KEY = registerKey("tanzanite_geode");

    public static final RegistryKey<ConfiguredFeature<?,?>> BUTTERCUPS_KEY = registerKey("buttercups");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldCitrineOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.TANZANITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_TANZANITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherCitrineOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHERRACK_TANZANITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endCitrineOres =
                List.of(OreFeatureConfig.createTarget(endstoneReplaceables, ModBlocks.ENDSTONE_TANZANITE_ORE.getDefaultState()));

        register(context, DOGWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DOGWOOD_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.DOGWOOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, DOGWOOD_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(new RandomFeatureEntry(placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DOGWOOD_PLACED_KEY),
                        0.5f)), placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.DOGWOOD_PLACED_KEY)));

        register(context, TANZANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldCitrineOres, 12));
        register(context, NETHER_TANZANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherCitrineOres, 12));
        register(context, ENDSTONE_TANZANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endCitrineOres, 12));

        register(context, TANZANITE_GEODE_KEY, Feature.GEODE ,
                new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(Blocks.DEEPSLATE),
                        BlockStateProvider.of(ModBlocks.TANZANITE_ORE),
                        BlockStateProvider.of(Blocks.DIRT),
                        BlockStateProvider.of(Blocks.EMERALD_BLOCK),
                        List.of(ModBlocks.TANZANITE_BLOCK.getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackConfig(0.25D, 1.5D, 1),
                        0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 8),
                        UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                        -18, 18, 0.075D, 1));

        register(context, BUTTERCUPS_KEY, Feature.FLOWER,
                ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BUTTERCUPS)))));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
