package benji.moddingcore.datagen;

import benji.moddingcore.item.CoreItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class CoreModelProvider extends FabricModelProvider {
    public CoreModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator modelGenerator) {
        modelGenerator.register(CoreItems.CORRUPTED_NETHER_STAR, Models.GENERATED);
        modelGenerator.register(CoreItems.ARMOR_CORE, Models.GENERATED);
        modelGenerator.register(CoreItems.MANGROVE_KNIFE, Models.GENERATED);
    }
}
