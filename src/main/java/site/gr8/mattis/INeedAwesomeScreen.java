package site.gr8.mattis;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class INeedAwesomeScreen extends Screen {

	private Screen parent;

	private int buttonWidth = 200;
	private int smallerButtonWidth = 150;
	private int buttonHeight = 20;

	public INeedAwesomeScreen(Screen parent) {
		super(Text.of("Julkinen options"));
		this.parent = parent;
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
		super.render(matrices, mouseX, mouseY, delta);
	}

	@Override
	public void init() {
		this.addDrawableChild(new ButtonWidget((this.width / 2) - (buttonWidth / 2), (this.height / 2) - (buttonHeight / 2), buttonWidth, buttonHeight,
				Text.of(returnFishText()), button -> {
			AutoFish.autoFish = !AutoFish.autoFish;
			button.setMessage(Text.of(returnFishText()));
		}));
		this.addDrawableChild(new ButtonWidget((this.width / 2) - (buttonWidth / 2), (this.height / 2) - (buttonHeight / 2) - 25, buttonWidth, buttonHeight,
				Text.of(returnRunText()), button -> {
			AutoRun.run = !AutoRun.run;
			button.setMessage(Text.of(returnRunText()));
		}));
		this.addDrawableChild(new ButtonWidget((this.width / 2) - (buttonWidth / 2), (this.height / 2) - (buttonHeight / 2) + 50, buttonWidth, buttonHeight,
				Text.of("Back"), button -> {
			this.client.setScreen(this.parent);
		}));
	}



	public String returnFishText() {
		return AutoFish.autoFish ? "Auto fishing is enabled" : "Auto fishing is disabled";
	}

	public String returnRunText() {
		return AutoRun.run ? "Auto run is enabled" : "Auto run is disabled";
	}

}
