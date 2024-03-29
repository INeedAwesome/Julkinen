package site.gr8.mattis.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import site.gr8.mattis.JulkinenScreen;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {

	public GameMenuScreenMixin(Text title) {
		super(title);
	}

	@Inject(method = "initWidgets", at = @At("TAIL"))
	private void initWidgets(CallbackInfo info) {
		this.addDrawableChild(new ButtonWidget(10, 10, 100, 20,
				Text.of("Julkinen"), button -> {
			this.client.setScreen(new JulkinenScreen(this));
		}));
	}

}
