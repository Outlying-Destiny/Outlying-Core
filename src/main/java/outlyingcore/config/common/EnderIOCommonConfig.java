package outlyingcore.config.common;

import net.minecraftforge.common.ForgeConfigSpec;
import outlyingcore.util.ConfigUtils;

import java.util.HashMap;
import java.util.Map;

public class EnderIOCommonConfig {
    public final MachinesConfig MACHINES;
    public final CapacitorsConfig CAPACITORS;

    public EnderIOCommonConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Ender IO").push("enderio");
            MACHINES = new MachinesConfig(builder);
            CAPACITORS = new CapacitorsConfig(builder);
        builder.pop();
    }

    public static class MachinesConfig {
        public final MachineConfig ALLOY_SMELTER;
        public final MachineConfig AVERSION_OBELISK;
        public final MachineConfig CRAFTER;
        public final MachineConfig DRAIN;
        public final MachineConfig IMPULSE_HOPPER;
        public final MachineConfig PAINTING_MACHINE;
        public final MachineConfig POWERED_SPAWNER;
        public final MachineConfig SAG_MILL;
        public final MachineConfig SLICER;
        public final MachineConfig SOUL_BINDER;
        public final MachineConfig WIRED_CHARGER;

        public MachinesConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Machines' settings").push("machines");
                ALLOY_SMELTER = new MachineConfig(builder, "Alloy Smelter");
                AVERSION_OBELISK = new MachineConfig(builder, "Aversion Obelisk");
                CRAFTER = new MachineConfig(builder, "Crafter");
                DRAIN = new MachineConfig(builder, "Drain");
                IMPULSE_HOPPER = new MachineConfig(builder, "Impulse Hopper");
                PAINTING_MACHINE = new MachineConfig(builder, "Painting Machine");
                POWERED_SPAWNER = new MachineConfig(builder, "Powered Spawner");
                SAG_MILL = new MachineConfig(builder, "SAG Mill");
                SLICER = new MachineConfig(builder, "Slicer");
                SOUL_BINDER = new MachineConfig(builder, "Soul Binder");
                WIRED_CHARGER = new MachineConfig(builder, "Wired Charger");
            builder.pop();
        }

        public static class MachineConfig {
            public final ForgeConfigSpec.BooleanValue USE_LINEAR_ENERGY_CAPACITY;
            public final ForgeConfigSpec.BooleanValue USE_LINEAR_ENERGY_USAGE_RATE;

            public MachineConfig(ForgeConfigSpec.Builder builder, String machineName) {
                builder.comment(machineName).push(machineName.toLowerCase().replace(" ", "_"));
                    USE_LINEAR_ENERGY_CAPACITY = ConfigUtils.addDefaultFalseBooleanValue(
                            builder,
                            "useLinearEnergyCapacity",
                            "Scale the machine's energy capacity linearly based on the Capacitor's base modifier value.",
                            "If false, the machine's energy capacity is scaled quadratically."
                    );
                    USE_LINEAR_ENERGY_USAGE_RATE = ConfigUtils.addDefaultFalseBooleanValue(
                            builder,
                            "useLinearEnergyUsageRate",
                            "Scale the machine's energy usage rate linearly based on the Capacitor's base modifier value.",
                            "If false, the machine's energy usage rate is scaled quadratically."
                    );
                builder.pop();
            }
        }
    }

    public static class CapacitorsConfig {
        private static final float DEFAULT_BASIC_CAPACITOR_BASE_MODIFIER = 1f;
        private static final float DEFAULT_DOUBLE_LAYER_CAPACITOR_BASE_MODIFIER = 2f;
        private static final float DEFAULT_OCTADIC_CAPACITOR_BASE_MODIFIER = 3f;

        private final Map<Float, ForgeConfigSpec.DoubleValue> CUSTOM_CAPACITOR_BASE_MODIFIERS = new HashMap<> ();

        public CapacitorsConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Capacitors' settings").push("capacitors");
                capacitorBaseModifierConfig(builder, "Basic", DEFAULT_BASIC_CAPACITOR_BASE_MODIFIER);
                capacitorBaseModifierConfig(builder, "Double Layer", DEFAULT_DOUBLE_LAYER_CAPACITOR_BASE_MODIFIER);
                capacitorBaseModifierConfig(builder, "Octadic", DEFAULT_OCTADIC_CAPACITOR_BASE_MODIFIER);
            builder.pop();
        }

        private void capacitorBaseModifierConfig(ForgeConfigSpec.Builder builder, String capacitorName, float defaultValue) {
            String path = capacitorName.substring(0, 1).toLowerCase() + capacitorName.substring(1).replace(" ", "") + "CapacitorBaseModifier";

            ForgeConfigSpec.DoubleValue customCapacitorBaseModifier = ConfigUtils.addNonNegativeDoubleValue(
                    builder,
                    path,
                    defaultValue,
                    500d,
                    capacitorName + " Capacitor's base modifier value."
            );

            CUSTOM_CAPACITOR_BASE_MODIFIERS.put(defaultValue, customCapacitorBaseModifier);
        }

        public float getCustomCapacitorBaseModifier(float defaultCapacitorBaseModifier) {
            ForgeConfigSpec.DoubleValue customCapacitorBaseModifier = CUSTOM_CAPACITOR_BASE_MODIFIERS.get(defaultCapacitorBaseModifier);

            return (customCapacitorBaseModifier != null ? customCapacitorBaseModifier.get().floatValue() : defaultCapacitorBaseModifier);
        }
    }
}