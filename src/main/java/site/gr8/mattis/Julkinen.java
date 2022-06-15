package site.gr8.mattis;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Julkinen implements ClientModInitializer {

	public static final String MOD_ID = "julkinen";
	public static final Logger LOGGER = LoggerFactory.getLogger("julkinen");

	public static KeyBinding runKey;

	@Override
	public void onInitializeClient() {

		LOGGER.info("Hello Fabric world!");

		runKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.wannabright.autorun",
				GLFW.GLFW_KEY_R,
				"category.wannabright.title"
		));

		ClientTickEvents.END_CLIENT_TICK.register(this::onEndTick);
	}

	private void onEndTick(MinecraftClient minecraftClient) {
		AutoFish.tick(minecraftClient);
		AutoRun.tick();
	}


}
