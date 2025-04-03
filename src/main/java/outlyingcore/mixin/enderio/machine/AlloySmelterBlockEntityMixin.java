package outlyingcore.mixin.enderio.machine;

import com.enderio.api.capacitor.CapacitorModifier;
import com.enderio.api.capacitor.ICapacitorScalable;
import com.enderio.api.capacitor.LinearScalable;
import com.enderio.machines.common.blockentity.AlloySmelterBlockEntity;
import com.enderio.machines.common.config.MachinesConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AlloySmelterBlockEntity.class)
public class AlloySmelterBlockEntityMixin {
    private static final ICapacitorScalable LINEAR_USAGE = new LinearScalable(CapacitorModifier.ENERGY_USE, MachinesConfig.COMMON.ENERGY.ALLOY_SMELTER_USAGE);

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/enderio/machines/common/blockentity/base/PoweredMachineBlockEntity;<init>"
                            + "(Lcom/enderio/api/io/energy/EnergyIOMode;Lcom/enderio/api/capacitor/ICapacitorScalable;Lcom/enderio/api/capacitor/ICapacitorScalable;"
                            + "Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V",
                    remap = false),
            index = 2)
    private static ICapacitorScalable outlyingcore$modifyUsage(ICapacitorScalable usage) {
        return LINEAR_USAGE;
    }
}