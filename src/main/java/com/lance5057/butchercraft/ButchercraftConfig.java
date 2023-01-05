package com.lance5057.butchercraft;

import java.nio.file.Path;
import java.util.Objects;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;

public class ButchercraftConfig {
    private static ButchercraftConfig instance;

    private final ForgeConfigSpec spec;
    
    public final General general;

    public ButchercraftConfig(ForgeConfigSpec.Builder builder) {
    	this.general = new General(builder);
    	
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

	public static class General {
		public final ForgeConfigSpec.ConfigValue<Float> breedingMultiplier;
		public final ForgeConfigSpec.ConfigValue<Float> ageMultiplier;
		public final ForgeConfigSpec.ConfigValue<Float> wildlifeBaseNutrition;

		General(ForgeConfigSpec.Builder builder) {
			breedingMultiplier = builder.comment("Amount to multiply breeding timer by after an animal is bred.")
					.translation("butchercraft.config.common.general.breeding").define("breedingMultiplier", 4f);
			ageMultiplier = builder.comment("Amount to multiply age timer by after an animal is born.")
					.translation("butchercraft.config.common.general.age").define("ageMultiplier", 4f);
			wildlifeBaseNutrition = builder.comment("Nutrition of wild animals.")
					.translation("butchercraft.config.common.general.wild_nutrition").define("ageMultiplier", 0.3f);
		}
	}
}
