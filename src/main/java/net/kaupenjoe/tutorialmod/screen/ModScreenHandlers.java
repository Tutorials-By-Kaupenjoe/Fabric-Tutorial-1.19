package net.kaupenjoe.tutorialmod.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<GemInfusingScreenHandler> GEM_INFUSING_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        GEM_INFUSING_SCREEN_HANDLER = new ScreenHandlerType<>(GemInfusingScreenHandler::new);
    }
}
