package com.github.lolitshaiech.visiblebarrierblocks.client;

import com.github.lolitshaiech.visiblebarrierblocks.client.init.KeyInputInit;
import net.fabricmc.api.ClientModInitializer;

public class VisiblebarrierblocksClient implements ClientModInitializer {

    public static final String MOD_ID = "visiblebarrierblocks";
    public static final String MOD_NAME = "Visible Barrier Blocks";

    public static final boolean visible = true;

    @Override
    public void onInitializeClient() {

        KeyInputInit.init();
    }
}
