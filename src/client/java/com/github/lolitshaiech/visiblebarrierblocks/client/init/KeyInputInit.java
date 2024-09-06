package com.github.lolitshaiech.visiblebarrierblocks.client.init;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputInit {

    public static final String CATEGORY_KEY = "key.category.visiblebarrierblocks";
    public static boolean pressed = false;


    public static KeyBinding barrierVisibilityToggle = register(
            new KeyBinding("key.visiblebarrierblocks.toggle", InputUtil.Type.KEYSYM,
                    GLFW.GLFW_KEY_M, CATEGORY_KEY)
    );

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (barrierVisibilityToggle.isPressed() && !pressed) {
                pressed = true;
                SettingsKeyInit.toggle.setValue(!SettingsKeyInit.toggle.getValue());
                client.player.sendMessage(Text.translatable("key.visiblebarrierblocks.toggle." + (SettingsKeyInit.toggle.getValue()?"on":"off")));
            } else if(!barrierVisibilityToggle.isPressed()){
                pressed = false;
            }
        });
    }


    public static KeyBinding register(KeyBinding keyBinding) {
        return KeyBindingHelper.registerKeyBinding(keyBinding);
    }
}
