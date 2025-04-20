package net.wetnoodle.blahaj.renderer.entity.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.wetnoodle.blahaj.BlConstants;

public class BlahajRenderState extends LivingEntityRenderState {
    private static final ResourceLocation DEFAULT_TEXTURE = BlConstants.id("textures/entity/blahaj/blahaj.png");
    public ResourceLocation texture = DEFAULT_TEXTURE;
}
