package outlyingcore;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;
import outlyingcore.config.Config;
import outlyingcore.util.ConfigUtils;

@Mod(OutlyingCore.MODID)
public class OutlyingCore {
    public static final String MODID = "outlyingcore";
    public static final String MOD_NAME = "Outlying Core";
    public static final Logger LOGGER = LogUtils.getLogger();

    public OutlyingCore() {
        ModLoadingContext context = ModLoadingContext.get();
        context.registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);
        context.registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);

        ConfigUtils.loadConfig(Config.COMMON_SPEC, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));

        LOGGER.info(MOD_NAME + " loaded");
    }
}