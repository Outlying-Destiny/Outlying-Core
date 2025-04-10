package outlyingcore.config.client;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    public final IronJetpacksClientConfig IRON_JETPACKS;

    public ClientConfig(ForgeConfigSpec.Builder builder) {
        IRON_JETPACKS = new IronJetpacksClientConfig(builder);
    }
}