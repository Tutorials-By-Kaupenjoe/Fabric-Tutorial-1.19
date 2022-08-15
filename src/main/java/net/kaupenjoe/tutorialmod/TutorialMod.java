package net.kaupenjoe.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.entity.ModBlockEntities;
import net.kaupenjoe.tutorialmod.event.PlayerTickHandler;
import net.kaupenjoe.tutorialmod.fluid.ModFluids;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.networking.ModMessages;
import net.kaupenjoe.tutorialmod.painting.ModPaintings;
import net.kaupenjoe.tutorialmod.recipe.ModRecipes;
import net.kaupenjoe.tutorialmod.screen.ModScreenHandlers;
import net.kaupenjoe.tutorialmod.util.ModLootTableModifiers;
import net.kaupenjoe.tutorialmod.villager.ModVillagers;
import net.kaupenjoe.tutorialmod.world.feature.ModConfiguredFeatures;
import net.kaupenjoe.tutorialmod.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();
		ModOreGeneration.generateOres();

		ModLootTableModifiers.modifyLootTables();
		ModMessages.registerC2SPackets();

		ModFluids.register();
		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();
		ModRecipes.registerRecipes();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
	}
}
