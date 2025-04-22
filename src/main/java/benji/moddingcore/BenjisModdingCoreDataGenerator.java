package benji.moddingcore;

import benji.moddingcore.datagen.CoreModelProvider;
import benji.moddingcore.datagen.CoreRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BenjisModdingCoreDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(CoreModelProvider::new);
		pack.addProvider(CoreRecipeProvider::new);
	}
}
