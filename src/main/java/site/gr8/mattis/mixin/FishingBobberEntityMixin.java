package site.gr8.mattis.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import site.gr8.mattis.AutoFish;

@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin {

	@Shadow private boolean caughtFish;

	@Inject(method = "onTrackedDataSet", at = @At("TAIL"))
	public void onTrackedDataSet(TrackedData<?> data, CallbackInfo info) {

		MinecraftClient client = MinecraftClient.getInstance();
		ClientPlayerInteractionManager manager = client.interactionManager;

		if (caughtFish) {
			if (manager != null) {
				AutoFish.setRecastRod(20);
				manager.interactItem(client.player, Hand.MAIN_HAND);
			}
		}
	}

}
