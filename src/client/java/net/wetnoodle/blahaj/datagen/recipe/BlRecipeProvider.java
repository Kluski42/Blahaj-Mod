package net.wetnoodle.blahaj.datagen.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.wetnoodle.blahaj.registry.BlItems;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BlRecipeProvider extends FabricRecipeProvider {
    public BlRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput exporter) {
        return new RecipeProvider(registries, exporter) {
            @Override
            public void buildRecipes() {
                this.shaped(RecipeCategory.DECORATIONS, BlItems.BLAHAJ)
                        .define('U', Items.LIGHT_BLUE_WOOL)
                        .define('B', Items.BLACK_WOOL)
                        .define('P', Items.PINK_WOOL)
                        .define('W', Items.WHITE_WOOL)
                        .pattern("UUU")
                        .pattern("UBU")
                        .pattern("PWW")
                        .unlockedBy(RecipeProvider.getHasName(Items.LIGHT_BLUE_WOOL), this.has(Items.LIGHT_BLUE_WOOL))
                        .save(exporter);

                this.shapeless(RecipeCategory.DECORATIONS, BlItems.BLAHAJ_BANNER_PATTERN)
                        .requires(Items.PAPER)
                        .requires(BlItems.BLAHAJ)
                        .unlockedBy(RecipeProvider.getHasName(BlItems.BLAHAJ), this.has(BlItems.BLAHAJ))
                        .save(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "BlRecipeProvider";
    }
}
