package net.kaupenjoe.tutorialmod.api.rei.category;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kaupenjoe.tutorialmod.api.rei.display.GemStationREIDisplay;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.kaupenjoe.tutorialmod.api.rei.REIPlugin.*;


@Environment(EnvType.CLIENT)
public class GemStationREICategory implements DisplayCategory<GemStationREIDisplay> {
    private final EntryStack<ItemStack> gem_infusing_station = EntryStacks.of(new ItemStack(ModBlocks.GEM_INFUSING_STATION));

    @Override
    public CategoryIdentifier<GemStationREIDisplay> getCategoryIdentifier() {
        return GemStationREIDisplay.ID;
    }

    @Override
    public @NotNull Renderer getIcon() {
        return gem_infusing_station;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Gem Infusing Station");
    }

    @Override
    public List<Widget> setupDisplay(GemStationREIDisplay display, Rectangle bounds) {
        // Setup background
        Point startPoint = new Point(bounds.getCenterX() - 36, bounds.getCenterY() - 13);
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));

        // Add arrow
        widgets.add(createAnimatedArrow(startPoint.x + 27, startPoint.y + 4));

        //Add output slot
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(createOutputSlot(display, 0, startPoint.x + 61, startPoint.y + 5));

        // Add input slots
        int x = startPoint.x-14;
        int y = startPoint.y - 5;
        widgets.add(createInputSlot(display, 0, x, y));
        widgets.add(createInputSlot(display, 1, x+SLOT_SIZE, y));
        //widgets.add(createInputSlot(display, 2, x, y+SLOT_SIZE));
        //widgets.add(createInputSlot(display, 3, x+SLOT_SIZE, y+SLOT_SIZE));
        return widgets;
    }
}