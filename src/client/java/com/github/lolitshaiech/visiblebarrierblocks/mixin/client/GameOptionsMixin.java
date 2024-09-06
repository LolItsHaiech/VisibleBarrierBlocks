package com.github.lolitshaiech.visiblebarrierblocks.mixin.client;


import com.github.lolitshaiech.visiblebarrierblocks.client.init.KeyInputInit;
import com.github.lolitshaiech.visiblebarrierblocks.client.init.SettingsKeyInit;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.resource.ResourcePackManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public abstract class GameOptionsMixin {

    @Inject(at = @At("HEAD"), method = "accept")
    private void acceptMixin(GameOptions.Visitor visitor, CallbackInfo ci) {
        visitor.accept("visiblebarrierblocks.toggle", SettingsKeyInit.toggle);
    }
}
