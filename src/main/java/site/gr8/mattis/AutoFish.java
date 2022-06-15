package site.gr8.mattis;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;

public class AutoFish {

	public static int recastRod = -1;

	public static void tick(MinecraftClient client) {
		if (recastRod > 0) {
			recastRod--;
		}
		if (recastRod == 0) {
			if (client.interactionManager != null) {
				client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
				recastRod =-1;
			}
		}
	}

	public static void setRecastRod(int countDown) {
		recastRod = countDown;
	}
}
