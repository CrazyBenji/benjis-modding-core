package benji.moddingcore.item;

import benji.moddingcore.BenjisModdingCore;
import benji.moddingcore.item.custom.CoreCraftingItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreItems {
    public static final int TICKS_PER_SECOND = 20;
    public static final int SECONDS_PER_MINUTE = 60;

    private static final int ARMOR_CORE_MAX_DAMAGE = 4;

    public static final Item TESTER = register("tester", new Item(new FabricItemSettings()));
    public static final Item CORRUPTED_NETHER_STAR = register("corrupted_nether_star", new Item(new FabricItemSettings()));
    public static final Item ARMOR_CORE = register("armor_core", new CoreCraftingItem(new FabricItemSettings().maxDamage(ARMOR_CORE_MAX_DAMAGE)));

    public static void registerItems() {
        Registry.register(Registries.ITEM_GROUP, CoreItemGroups.CORE_ITEM_GROUP_KEY, CoreItemGroups.CORE_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CoreItemGroups.CORE_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CORRUPTED_NETHER_STAR);
            itemGroup.add(ARMOR_CORE);
        });
    }

    public static void initialize() {
        registerItems();
    }

    public static Item register(String id, Item item) {
        Identifier itemID = new Identifier(BenjisModdingCore.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }
}