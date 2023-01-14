package net.kaupenjoe.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModBlocks.TANZANITE_ORE), RecipeCategory.BUILDING_BLOCKS, ModItems.TANZANITE,
                3f, 300, "tanzanite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TANZANITE, RecipeCategory.DECORATIONS, ModBlocks.TANZANITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EIGHT_BALL)
                .pattern("###")
                .pattern("#I#")
                .pattern("###")
                .input('I', Items.IRON_INGOT)
                .input('#', ModItems.TANZANITE)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(ModItems.TANZANITE),
                        FabricRecipeProvider.conditionsFromItem(ModItems.TANZANITE))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.EIGHT_BALL)));
    }
}
