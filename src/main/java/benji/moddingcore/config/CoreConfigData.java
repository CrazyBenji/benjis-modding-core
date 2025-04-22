package benji.moddingcore.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "moddingcore")
public class CoreConfigData implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    public boolean foodEffects = true;

    @ConfigEntry.Gui.CollapsibleObject
    public boolean armorEffects = true;
}
