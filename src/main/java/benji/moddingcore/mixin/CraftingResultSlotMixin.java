package benji.moddingcore.mixin;

import benji.moddingcore.item.custom.CoreCraftingItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CraftingResultSlot.class)
public abstract class CraftingResultSlotMixin extends Slot {

    public CraftingResultSlotMixin() {
        super(null, 0, 0, 0);
    }

    @Inject(method = "onTakeItem", at = @At("TAIL"))
    private void damageItemOnCraft(PlayerEntity player, ItemStack stack, CallbackInfo ci) {
        if (!(this.inventory instanceof CraftingInventory craftingInventory)) {
            return;
        }

        for (int i = 0; i < craftingInventory.size(); i++) {
            ItemStack itemStack = craftingInventory.getStack(i);
            if (itemStack.getItem() instanceof CoreCraftingItem) {
                itemStack.damage(1, player.getRandom(), null);
                if (itemStack.getDamage() >= itemStack.getMaxDamage()) {
                    craftingInventory.setStack(i, ItemStack.EMPTY);
                }
            }
        }
    }
}
