package outlyingcore.config.common;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    public final EnderIOCommonConfig ENDER_IO;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
        ENDER_IO = new EnderIOCommonConfig(builder);
    }
}