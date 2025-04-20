package net.wetnoodle.blahaj.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import net.wetnoodle.blahaj.BlConstants;
import org.jetbrains.annotations.NotNull;

// Made with Blockbench 4.12.4

public class BlahajModel extends EntityModel<EntityRenderState> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(BlConstants.id("blahaj"), "main");
    private final ModelPart bb_main;

    public BlahajModel(@NotNull ModelPart root) {
        super(root);
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -11.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition sidefin_2_r1 = bb_main.addOrReplaceChild("sidefin_2_r1", CubeListBuilder.create().texOffs(24, 0).addBox(-5.0F, -2.0F, -2.3F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.02F, -4.0F, 0.0F, 0.5236F, 0.0F));

        PartDefinition sidefin_1_r1 = bb_main.addOrReplaceChild("sidefin_1_r1", CubeListBuilder.create().texOffs(24, 5).addBox(-1.0F, -2.0F, -2.3F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.02F, -4.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition fin_top_r1 = bb_main.addOrReplaceChild("fin_top_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, -0.829F, 0.0F, 0.0F));

        PartDefinition tail_top_r1 = bb_main.addOrReplaceChild("tail_top_r1", CubeListBuilder.create().texOffs(14, 18).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 11.0F, 0.8727F, 0.0F, 0.0F));

        PartDefinition tail_bottom_r1 = bb_main.addOrReplaceChild("tail_bottom_r1", CubeListBuilder.create().texOffs(17, 27).addBox(-1.0F, -2.0F, -1.2F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 10.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition nub_thing_r1 = bb_main.addOrReplaceChild("nub_thing_r1", CubeListBuilder.create().texOffs(0, 18).addBox(0.5F, -1.3F, -1.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, 6.0F, -0.8727F, 0.0F, 0.0F));

        PartDefinition tail_base_r1 = bb_main.addOrReplaceChild("tail_base_r1", CubeListBuilder.create().texOffs(20, 18).addBox(-1.5F, -3.5F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition mid_section_r1 = bb_main.addOrReplaceChild("mid_section_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -4.0F, 2.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0436F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void setupAnim(EntityRenderState entityRenderState) {
        super.setupAnim(entityRenderState);
    }
}
