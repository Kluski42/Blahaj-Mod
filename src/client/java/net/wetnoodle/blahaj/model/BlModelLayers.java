package net.wetnoodle.blahaj.model;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.wetnoodle.blahaj.BlConstants;
import net.wetnoodle.blahaj.registry.BlEntityTypes;
import net.wetnoodle.blahaj.renderer.entity.BlahajRenderer;

public class BlModelLayers {
    public static final ModelLayerLocation BLAHAJ = new ModelLayerLocation(BlConstants.id("blahaj"), "main");

    public static void init() {
        EntityRendererRegistry.register(BlEntityTypes.BLAHAJ, BlahajRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(BLAHAJ, BlahajModel::createBodyLayer);
    }
}
