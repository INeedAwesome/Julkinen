package site.gr8.mattis;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

public class ThrowEnderPearls {

	public static void tick(MinecraftClient client) {
		while (Julkinen.throwEnderPearlsKey.wasPressed()) {
			PlayerInventory inventory = client.player.getInventory();
			if (client.isInSingleplayer()) {
				MinecraftServer server = client.getServer();
				if (server == null) return;
				ServerPlayerEntity player = server.getPlayerManager().getPlayer(client.player.getUuid());
				dropEnderPearlsSinglePlayer(inventory, player);
			}
			else {

				//  --------- not working ---------
				//  |		server is null
				//  -------------------------------

				// TODO: 2022-06-18 Get an instance of minecraft server so that i can get ServerEntityPlayer.
				//MinecraftServer server = Julkinen.server;
				//ServerPlayerEntity serverPlayer = server.getPlayerManager().getPlayer(client.player.getUuid());
				//dropEnderPearlServer(inventory, serverPlayer);
			}

		}
	}

	private static void dropEnderPearlsSinglePlayer(PlayerInventory inventory, ServerPlayerEntity player) {
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack stack = inventory.getStack(i);
			if (stack.getItem() == Items.ENDER_PEARL) {
				player.getInventory().removeStack(i);
				player.dropItem(stack, false, false);
			}
		}
	}

	private static void dropEnderPearlServer(PlayerInventory inventory, ServerPlayerEntity player) {
		for (int i = 0; i < inventory.size(); i++) {
			ItemStack stack = inventory.getStack(i);
			if (stack.getItem() == Items.ENDER_PEARL) {
				player.getInventory().removeStack(i);
				player.dropItem(stack, false, false);
			}
		}
	}


}
