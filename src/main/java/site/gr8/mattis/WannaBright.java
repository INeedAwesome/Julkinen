package site.gr8.mattis;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WannaBright implements ClientModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitializeClient() {

		LOGGER.info("Hello Fabric world!");
	}


}
