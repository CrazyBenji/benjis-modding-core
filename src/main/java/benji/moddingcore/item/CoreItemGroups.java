package benji.moddingcore.item;

import benji.moddingcore.BenjisModdingCore;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CoreItemGroups {
    public static final RegistryKey<ItemGroup> CORE_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(BenjisModdingCore.MOD_ID, "core_item_group"));
    public static final ItemGroup CORE_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CoreItems.ARMOR_CORE))
            .displayName(Text.translatable("itemGroup.core_item_group"))
            .build();
}
