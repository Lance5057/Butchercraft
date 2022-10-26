package com.lance5057.butchercraft;

import java.nio.file.Path;
import java.util.Objects;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;

public class ButchercraftConfig {
    private static ButchercraftConfig instance;

    private final ForgeConfigSpec spec;

    public ButchercraftConfig(ForgeConfigSpec.Builder builder) {
        this.spec = builder.build();
    }

    public static ForgeConfigSpec initialize() {
        ButchercraftConfig config = new ButchercraftConfig(new ForgeConfigSpec.Builder());
        instance = config;
        return config.getSpec();
    }

    public static ButchercraftConfig getInstance() {
        return Objects.requireNonNull(instance, "Called for Config before it's Initialization");
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave()
                .writingMode(WritingMode.REPLACE).build();

        configData.load();
        spec.setConfig(configData);
    }

    public ForgeConfigSpec getSpec() {
        return spec;
    }

}
