package net.wetnoodle.blahaj.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.wetnoodle.blahaj.entity.Blahaj;
import net.wetnoodle.blahaj.model.BlahajModel;
import net.wetnoodle.blahaj.renderer.entity.state.BlahajRenderState;
import org.jetbrains.annotations.NotNull;

public class BlahajRenderer extends LivingEntityRenderer<Blahaj, BlahajRenderState, BlahajModel> {
    public BlahajRenderer(EntityRendererProvider.Context context) {
        super(context, new BlahajModel(context.bakeLayer(BlahajModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(BlahajRenderState renderState) {
        return renderState.texture;
    }

    @Override
    public @NotNull BlahajRenderState createRenderState() {
        return new BlahajRenderState();
    }
}
