package benji.moddingcore.datagen;

import benji.moddingcore.item.CoreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class CoreRecipeProvider extends FabricRecipeProvider {
    public CoreRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, CoreItems.CORRUPTED_NETHER_STAR, 1)
                .pattern("pnp")
                .pattern("nsn")
                .pattern("pnp")
                .input('p', Items.POPPED_CHORUS_FRUIT)
                .input('n', Items.NETHERITE_INGOT)
                .input('s', Items.NETHER_STAR)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, CoreItems.ARMOR_CORE, 1)
                .pattern("prp")
                .pattern("dcl")
                .pattern("pgp")
                .input('c', CoreItems.CORRUPTED_NETHER_STAR)
                .input('p', Items.PRISMARINE_SHARD)
                .input('l', Items.LAPIS_LAZULI)
                .input('d', Items.DIAMOND)
                .input('r', Items.REDSTONE)
                .input('g', Items.GOLD_INGOT)
                .criterion(hasItem(CoreItems.CORRUPTED_NETHER_STAR), conditionsFromItem(CoreItems.CORRUPTED_NETHER_STAR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, CoreItems.TESTER, 1)
                .input(CoreItems.ARMOR_CORE)
                .criterion(hasItem(CoreItems.ARMOR_CORE), conditionsFromItem(CoreItems.ARMOR_CORE))
                .offerTo(exporter);
    }
}
