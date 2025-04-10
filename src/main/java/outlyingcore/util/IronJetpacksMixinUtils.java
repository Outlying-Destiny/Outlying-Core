package outlyingcore.util;

import com.blakebr0.ironjetpacks.registry.Jetpack;
import com.blakebr0.ironjetpacks.util.JetpackUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public final class IronJetpacksMixinUtils {
    private static final Map<ResourceLocation, ResourceLocation> JETPACK_TEXTURES = new HashMap<> ();
    private static final String PREFIX = "textures/models/armor/";
    private static final String SUFFIX = ".png";

    private IronJetpacksMixinUtils() {}

    public static ResourceLocation getJetpackTexture(ItemStack stack) {
        Jetpack jetpack = JetpackUtils.getJetpack(stack);
        ResourceLocation id = jetpack.getId();

        if (!JETPACK_TEXTURES.containsKey(id)) {
            JETPACK_TEXTURES.put(id, id.withPrefix(PREFIX).withSuffix(SUFFIX));
        }

        return JETPACK_TEXTURES.get(id);
    }
}