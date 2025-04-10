package outlyingcore.config.client;

import net.minecraftforge.common.ForgeConfigSpec;
import outlyingcore.util.ConfigUtils;

public class IronJetpacksClientConfig {
    public final ForgeConfigSpec.BooleanValue USE_CUSTOM_JETPACK_TEXTURES;

    public IronJetpacksClientConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Iron Jetpacks").push("ironjetpacks");
            USE_CUSTOM_JETPACK_TEXTURES = ConfigUtils.addDefaultFalseBooleanValue(
                    builder,
                    "useCustomJetpackTextures",
                    "Use a custom texture for each Jetpack tier (path: ironjetpacks/textures/models/armor/<jetpack_id>.png).",
                    "If false, the default Jetpack texture is used for each tier."
            );
        builder.pop();
    }
}