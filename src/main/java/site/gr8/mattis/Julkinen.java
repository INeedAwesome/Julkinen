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
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static KeyBinding runKey;
	public static KeyBinding throwEnderPearlsKey;

	@Override
	public void onInitializeClient() {

		LOGGER.info("Hello Fabric world!");

		runKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.julkinen.autorun",
				GLFW.GLFW_KEY_Y,
				"category.julkinen.title"
		));
		throwEnderPearlsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.julkinen.throwEnderPearls",
				GLFW.GLFW_KEY_U,
				"category.julkinen.title"
		));

		ClientTickEvents.END_CLIENT_TICK.register(this::onClientEndTick);
	}

	private void onClientEndTick(MinecraftClient minecraftClient) {
		AutoFish.tick(minecraftClient);
		AutoRun.tick();
		ThrowEnderPearls.tick(minecraftClient);

	}

}
