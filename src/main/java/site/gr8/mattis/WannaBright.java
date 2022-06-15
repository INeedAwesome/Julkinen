package site.gr8.mattis;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WannaBright implements ClientModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("wannabright");

	@Override
	public void onInitializeClient() {

		LOGGER.info("Hello Fabric world!");
		ClientTickEvents.END_CLIENT_TICK.register(this::onEndTick);
	}

	private void onEndTick(MinecraftClient minecraftClient) {
		AutoFish.tick(minecraftClient);
	}


}
