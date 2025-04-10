package outlyingcore.util;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public final class ConfigUtils {
    private ConfigUtils() {}

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .preserveInsertionOrder()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }

    public static ForgeConfigSpec.BooleanValue addBooleanValue(ForgeConfigSpec.Builder builder, String path, boolean defaultValue, String... comments) {
        return builder.comment(comments).define(path, defaultValue);
    }

    public static ForgeConfigSpec.BooleanValue addDefaultFalseBooleanValue(ForgeConfigSpec.Builder builder, String path, String... comments) {
        return addBooleanValue(builder, path, false, comments);
    }

    public static ForgeConfigSpec.DoubleValue addDoubleValue(ForgeConfigSpec.Builder builder, String path, double defaultValue, double minValue, double maxValue, String... comments) {
        return builder.comment(comments).defineInRange(path, defaultValue, minValue, maxValue);
    }

    public static ForgeConfigSpec.DoubleValue addNonNegativeDoubleValue(ForgeConfigSpec.Builder builder, String path, double defaultValue, double maxValue, String... comments) {
        return addDoubleValue(builder, path, defaultValue, 0d, maxValue, comments);
    }
}