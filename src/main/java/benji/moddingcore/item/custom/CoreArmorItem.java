package benji.moddingcore.item.custom;

import benji.moddingcore.config.CoreConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoreArmorItem extends ArmorItem {
    private final StatusEffectInstance statusEffect;

    public CoreArmorItem(ArmorMaterial material, Type type, Settings settings, StatusEffectInstance statusEffect) {
        super(material, type, settings);
        this.statusEffect = statusEffect;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player) && CoreConfig.getConfig().armorEffects) {
                    player.addStatusEffect(statusEffect);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        for (int i = 0; i < 4; i++) {
            Item item = player.getInventory().getArmorStack(i).getItem();
            if (!(item instanceof ArmorItem armor)) {
                return false;
            }
            if (armor.getMaterial() != this.material) {
                return false;
            }
        }
        return true;
    }
}
