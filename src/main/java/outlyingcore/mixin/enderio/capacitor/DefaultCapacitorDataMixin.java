package outlyingcore.mixin.enderio.capacitor;

import com.enderio.base.common.capacitor.DefaultCapacitorData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = DefaultCapacitorData.class, remap = false)
public class DefaultCapacitorDataMixin {
    private static final float DEFAULT_OCTADIC_CAPACITOR_BASE = 3.0f;
    private static final float CUSTOM_OCTADIC_CAPACITOR_BASE = 3.5f;

    @ModifyConstant(method = "<clinit>")
    private static float outlyingcore$modifyOctadicCapacitorBase(float base) {
        return (base == DEFAULT_OCTADIC_CAPACITOR_BASE ? CUSTOM_OCTADIC_CAPACITOR_BASE : base);
    }
}