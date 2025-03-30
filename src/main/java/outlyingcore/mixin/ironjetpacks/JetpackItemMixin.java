package outlyingcore.mixin.ironjetpacks;

import com.blakebr0.ironjetpacks.item.JetpackItem;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import outlyingcore.util.IronJetpacksMixinUtils;

@Mixin(value = JetpackItem.class, remap = false)
public class JetpackItemMixin {
    @ModifyReturnValue(method = "getArmorTexture", at = @At("RETURN"))
    private String outlyingcore$modifyTexture(String texture, @Local(argsOnly = true) ItemStack stack, @Local(argsOnly = true) String type) {
        return (type == null ? IronJetpacksMixinUtils.getJetpackTexture(stack).toString() : texture);
    }
}