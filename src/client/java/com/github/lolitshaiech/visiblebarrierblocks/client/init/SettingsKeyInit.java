package com.github.lolitshaiech.visiblebarrierblocks.client.init;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.resource.ResourcePackManager;

import java.nio.file.OpenOption;

public class SettingsKeyInit {
    public static SimpleOption<Boolean> toggle = SimpleOption.ofBoolean("options.visiblebarrierblocks.toggle",
            false, resourcePackManager -> {
                MinecraftClient.getInstance().reloadResources();
            }
    );
}
