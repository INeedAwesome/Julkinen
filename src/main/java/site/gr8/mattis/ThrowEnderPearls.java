package site.gr8.mattis;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class ThrowEnderPearls {

	public static void tick(MinecraftClient client) {
		while (Julkinen.throwEnderPearlsKey.wasPressed()) {
			PlayerInventory inventory = client.player.getInventory();
			if (client.isInSingleplayer()) {
				MinecraftServer server = client.getServer();
				ServerPlayerEntity player = server.getPlayerManager().getPlayer(client.player.getUuid());
				dropEnderPearlsSinglePlayer(inventory, player);
			}
			else {

				//  ------ not working !! ----------
				//  server is null
				//  --------------------------------

				//MinecraftServer server = client.getServer();
				//DedicatedServer dedicatedServer = (DedicatedServer) client.player.getServer();
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
