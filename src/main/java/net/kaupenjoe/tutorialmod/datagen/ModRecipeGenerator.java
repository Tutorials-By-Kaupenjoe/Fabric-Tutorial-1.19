package net.kaupenjoe.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModBlocks.TANZANITE_ORE), ModItems.TANZANITE,
                3f, 300, "tanzanite");

        offerReversibleCompactingRecipes(exporter, ModItems.TANZANITE, ModBlocks.TANZANITE_BLOCK);

        ShapedRecipeJsonBuilder.create(ModItems.EIGHT_BALL)
                .pattern("###")
                .pattern("#I#")
                .pattern("###")
                .input('I', Items.IRON_INGOT)
                .input('#', ModItems.TANZANITE)
                .criterion(RecipeProvider.hasItem(Items.IRON_INGOT),
                        RecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(RecipeProvider.hasItem(ModItems.TANZANITE),
                        RecipeProvider.conditionsFromItem(ModItems.TANZANITE))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ModItems.EIGHT_BALL)));
    }
}
