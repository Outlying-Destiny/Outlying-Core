package outlyingcore.mixin.enderio.machine;

import com.enderio.api.capacitor.CapacitorModifier;
import com.enderio.api.capacitor.ICapacitorScalable;
import com.enderio.api.capacitor.LinearScalable;
import com.enderio.machines.common.blockentity.WiredChargerBlockEntity;
import com.enderio.machines.common.config.MachinesConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import outlyingcore.config.Config;

@Mixin(WiredChargerBlockEntity.class)
public class WiredChargerBlockEntityMixin {
    private static final ICapacitorScalable LINEAR_ENERGY_CAPACITY = new LinearScalable(CapacitorModifier.ENERGY_CAPACITY, MachinesConfig.COMMON.ENERGY.WIRED_CHARGER_CAPACITY);
    private static final ICapacitorScalable LINEAR_ENERGY_USAGE_RATE = new LinearScalable(CapacitorModifier.ENERGY_USE, MachinesConfig.COMMON.ENERGY.WIRED_CHARGER_USAGE);

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/enderio/machines/common/blockentity/base/PoweredMachineBlockEntity;<init>"
                            + "(Lcom/enderio/api/io/energy/EnergyIOMode;Lcom/enderio/api/capacitor/ICapacitorScalable;Lcom/enderio/api/capacitor/ICapacitorScalable;"
                            + "Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V",
                    remap = false),
            index = 1)
    private static ICapacitorScalable outlyingcore$modifyEnergyCapacity(ICapacitorScalable energyCapacity) {
        return Config.COMMON.ENDER_IO.MACHINES.WIRED_CHARGER.USE_LINEAR_ENERGY_CAPACITY.get() ? LINEAR_ENERGY_CAPACITY : energyCapacity;
    }

    @ModifyArg(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/enderio/machines/common/blockentity/base/PoweredMachineBlockEntity;<init>"
                            + "(Lcom/enderio/api/io/energy/EnergyIOMode;Lcom/enderio/api/capacitor/ICapacitorScalable;Lcom/enderio/api/capacitor/ICapacitorScalable;"
                            + "Lnet/minecraft/world/level/block/entity/BlockEntityType;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V",
                    remap = false),
            index = 2)
    private static ICapacitorScalable outlyingcore$modifyEnergyUsageRate(ICapacitorScalable energyUsageRate) {
        return Config.COMMON.ENDER_IO.MACHINES.WIRED_CHARGER.USE_LINEAR_ENERGY_USAGE_RATE.get() ? LINEAR_ENERGY_USAGE_RATE : energyUsageRate;
    }
}