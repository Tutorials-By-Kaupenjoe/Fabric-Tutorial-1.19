package net.kaupenjoe.tutorialmod.api.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.kaupenjoe.tutorialmod.api.rei.display.GemStationREIDisplay;
import net.kaupenjoe.tutorialmod.recipe.GemInfusingRecipe;

public class REICategoryIdentifiers {
    public static final CategoryIdentifier<GemStationREIDisplay> GEM_INFUSING = CategoryIdentifier.of(GemInfusingRecipe.Type.ID);

    private REICategoryIdentifiers() {

    }
}