package net.kaupenjoe.tutorialmod.api.rei;

import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.display.Display;

import net.minecraft.inventory.SimpleInventory;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Environment(EnvType.CLIENT)
public abstract class REIRecipeDisplay<T extends Recipe<SimpleInventory>> implements Display {
    protected final T recipe;
    protected List<EntryIngredient> inputs;
    protected EntryIngredient outputs;

    public REIRecipeDisplay(T recipe) {
        this.recipe = recipe;
        this.inputs = EntryIngredients.ofIngredients(recipe.getIngredients());
        this.outputs = EntryIngredients.of(recipe.getOutput().getItem());
    }

    @Override
    public @NotNull List<EntryIngredient> getInputEntries() {
        return this.inputs;
    }


    @Override
    public @NotNull List<EntryIngredient> getOutputEntries() {
        return Collections.singletonList(this.outputs);
    }

    @Override
    public Optional<Identifier> getDisplayLocation() {
        return Optional.empty();
    }
}