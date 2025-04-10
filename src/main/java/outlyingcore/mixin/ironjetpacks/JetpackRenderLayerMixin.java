package outlyingcore.mixin.ironjetpacks;

import com.blakebr0.ironjetpacks.client.layer.JetpackRenderLayer;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import outlyingcore.config.Config;
import outlyingcore.util.IronJetpacksMixinUtils;

@Mixin(value = JetpackRenderLayer.class, remap = false)
public class JetpackRenderLayerMixin {
    @Final
    @Shadow
    private static ResourceLocation TEXTURE;

    @ModifyArg(
            method = "lambda$render$1",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/blakebr0/ironjetpacks/client/layer/JetpackRenderLayer;renderModel"
                            + "(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IZ"
                            + "Lnet/minecraft/client/model/Model;FFFLnet/minecraft/resources/ResourceLocation;)V"),
            index = 8)
    private ResourceLocation outlyingcore$modifyTexture(ResourceLocation texture, @Local(argsOnly = true) ItemStack curio) {
        if (!Config.CLIENT.IRON_JETPACKS.USE_CUSTOM_JETPACK_TEXTURES.get() || texture != TEXTURE) {
            return texture;
        }

        return IronJetpacksMixinUtils.getJetpackTexture(curio);
    }
}