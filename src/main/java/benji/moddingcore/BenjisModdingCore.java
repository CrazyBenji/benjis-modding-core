package benji.moddingcore;

import benji.moddingcore.config.CoreConfig;
import benji.moddingcore.item.CoreItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BenjisModdingCore implements ModInitializer {
	public static final String MOD_ID = "moddingcore";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		if (FabricLoader.getInstance().isModLoaded("cloth-config2")) {
			CoreConfig.register();
		}
		CoreItems.initialize();
	}
}