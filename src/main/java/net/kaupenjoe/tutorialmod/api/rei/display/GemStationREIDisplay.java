package net.kaupenjoe.tutorialmod.api.rei.display;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.recipe.GemInfusingRecipe;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GemStationREIDisplay extends BasicDisplay {

    public static final CategoryIdentifier<GemStationREIDisplay> ID = CategoryIdentifier.of(TutorialMod.MOD_ID, "gem_infusing");
    public GemStationREIDisplay(GemInfusingRecipe recipe) {
        this(EntryIngredients.ofIngredients(recipe.getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.getOutput())), Optional.ofNullable(recipe.getId()));
    }


    public GemStationREIDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Optional<Identifier> location) {
        super(inputs, outputs, location);
    }
    @Override
    public @NotNull CategoryIdentifier<?> getCategoryIdentifier() {
        return ID;
    }
}