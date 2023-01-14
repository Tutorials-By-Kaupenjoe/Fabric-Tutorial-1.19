package net.kaupenjoe.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup TANZANITE;

    public static void registerItemGroup() {
        TANZANITE = FabricItemGroup.builder(new Identifier(TutorialMod.MOD_ID, "tanzanite"))
                .displayName(Text.literal("Tanzanite Item Group"))
                .icon(() -> new ItemStack(ModItems.TANZANITE)).build();
    }
}
