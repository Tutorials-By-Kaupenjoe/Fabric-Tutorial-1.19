package net.kaupenjoe.tutorialmod.recipe;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(TutorialMod.MOD_ID, GemInfusingRecipe.Serializer.ID),
                GemInfusingRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(TutorialMod.MOD_ID, GemInfusingRecipe.Type.ID),
                GemInfusingRecipe.Type.INSTANCE);
    }
}
