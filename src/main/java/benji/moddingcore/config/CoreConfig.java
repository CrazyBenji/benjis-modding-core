package benji.moddingcore.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class CoreConfig {
    public static CoreConfigData getConfig() {
        return AutoConfig.getConfigHolder(CoreConfigData.class).getConfig();
    }

    public static void saveConfig() {
        AutoConfig.getConfigHolder(CoreConfigData.class).save();
    }

    public static void register() {
        AutoConfig.register(CoreConfigData.class, JanksonConfigSerializer::new);
        ServerLifecycleEvents.START_DATA_PACK_RELOAD.register((s, m) -> AutoConfig.getConfigHolder(CoreConfigData.class).load());
    }
}
