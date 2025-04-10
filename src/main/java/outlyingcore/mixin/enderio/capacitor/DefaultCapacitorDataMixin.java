package outlyingcore.mixin.enderio.capacitor;

import com.enderio.base.common.capacitor.DefaultCapacitorData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import outlyingcore.config.Config;

@Mixin(DefaultCapacitorData.class)
public class DefaultCapacitorDataMixin {
    @ModifyConstant(method = "<clinit>")
    private static float outlyingcore$modifyCapacitorBaseModifier(float capacitorBaseModifier) {
        return Config.COMMON.ENDER_IO.CAPACITORS.getCustomCapacitorBaseModifier(capacitorBaseModifier);
    }
}