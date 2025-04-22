package benji.moddingcore.item.custom;

import benji.moddingcore.config.CoreConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoreFoodItem extends Item {
    private final StatusEffectInstance statusEffect;

    public CoreFoodItem(Settings settings, StatusEffectInstance statusEffect) {
        super(settings);
        this.statusEffect = statusEffect;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (CoreConfig.getConfig().foodEffects) {
            user.addStatusEffect(statusEffect);
        }
        return super.finishUsing(stack, world, user);
    }
}