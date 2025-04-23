package benji.moddingcore.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CoreCraftingItem extends Item {
    public CoreCraftingItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack newStack = stack.copy();
        newStack.setDamage(newStack.getDamage() + 1);
        if (newStack.getDamage() >= newStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return newStack;
    }
}
