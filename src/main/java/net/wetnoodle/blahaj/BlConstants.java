package net.wetnoodle.blahaj;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlConstants {
    public static final String MOD_ID = "blahaj";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static boolean UNSTABLE_LOGGING = FabricLoader.getInstance().isDevelopmentEnvironment();


    public static @NotNull ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static void log(String string) {
        log(string, UNSTABLE_LOGGING);
    }

    public static void log(String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info(string);
        }
    }

    public static void logWithModId(String string) {
        logWithModId(string, UNSTABLE_LOGGING);
    }

    public static void logWithModId(String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info(string + " " + MOD_ID);
        }
    }

    public static void warn(String string) {
        warn(string, UNSTABLE_LOGGING);
    }

    public static void warn(String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.warn(string);
        }
    }
}
