package outlyingcore;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(OutlyingCore.MODID)
public class OutlyingCore {
    public static final String MODID = "outlyingcore";
    public static final String MOD_NAME = "Outlying Core";
    public static final Logger LOGGER = LogUtils.getLogger();

    public OutlyingCore() {
        LOGGER.info(MOD_NAME + " loaded");
    }
}