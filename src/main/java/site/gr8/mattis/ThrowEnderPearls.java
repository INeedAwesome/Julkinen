package site.gr8.mattis;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class ThrowEnderPearls {

	public static void tick(MinecraftClient client) {
		while (Julkinen.throwEnderPearlsKey.wasPressed()) {
			PlayerInventory inventory = client.player.getInventory();
			for (int i = 0; i < inventory.size(); i++) {

				ItemStack stack = inventory.getStack(i);
				String stackName = stack.getName().getString();

				if (stackName.equalsIgnoreCase("ender pearl")) {

					client.player.dropItem(stack, false, false);

					client.player.sendMessage(Text.of("Currently not able to throw ep"), true);
					// debug message to show if this got triggered

				}
			}
		}
	}
}
