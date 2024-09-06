package com.github.lolitshaiech.visiblebarrierblocks.mixin.client;

import com.github.lolitshaiech.visiblebarrierblocks.client.init.SettingsKeyInit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BarrierBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BarrierBlock.class)
@Environment(EnvType.CLIENT)
public class BarrierBlockMixin {

    @Inject(at = @At("HEAD"), method = "getRenderType", cancellable = true)
    public void getRenderType(BlockState state, CallbackInfoReturnable<BlockRenderType> cir) {
        cir.setReturnValue(SettingsKeyInit.toggle.getValue()?BlockRenderType.MODEL:BlockRenderType.INVISIBLE);
    }
}
