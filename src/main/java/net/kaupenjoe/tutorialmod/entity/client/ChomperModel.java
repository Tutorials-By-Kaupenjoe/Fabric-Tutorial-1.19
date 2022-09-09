package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.custom.ChomperEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChomperModel extends AnimatedGeoModel<ChomperEntity> {
    @Override
    public Identifier getModelResource(ChomperEntity object) {
        return new Identifier(TutorialMod.MOD_ID, "geo/chomper.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChomperEntity object) {
        return new Identifier(TutorialMod.MOD_ID, "textures/entity/chomper_texture.png");
    }

    @Override
    public Identifier getAnimationResource(ChomperEntity animatable) {
        return new Identifier(TutorialMod.MOD_ID, "animations/chomper.animation.json");
    }
}
