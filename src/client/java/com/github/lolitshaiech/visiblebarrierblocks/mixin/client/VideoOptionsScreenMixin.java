package com.github.lolitshaiech.visiblebarrierblocks.mixin.client;


import com.github.lolitshaiech.visiblebarrierblocks.client.init.SettingsKeyInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(VideoOptionsScreen.class)
@Environment(EnvType.CLIENT)
public class VideoOptionsScreenMixin {


    @Inject(at = @At("RETURN"), method = "getOptions", cancellable = true)
    private static void getOptions(GameOptions gameOptions, CallbackInfoReturnable<SimpleOption<?>[]> cir) {
        ArrayList<SimpleOption<?>> list = new ArrayList<>(Arrays.asList(cir.getReturnValue()));
        list.add(SettingsKeyInit.toggle);
        cir.setReturnValue(list.toArray(new SimpleOption<?>[0]));
    }
}
