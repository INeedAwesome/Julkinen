package site.gr8.mattis;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class INeedAwesomeScreen extends Screen {

	private Screen parent;

	private int buttonWidth = 200;
	private int buttonHeight = 20;

	public INeedAwesomeScreen(Screen parent) {
		super(Text.of(""));
		this.parent = parent;
	}

	@Override
	public void init() {
		this.addDrawableChild(new ButtonWidget((this.width / 2) - (buttonWidth / 2), (this.height / 2) - (buttonHeight / 2), buttonWidth, buttonHeight,
				Text.of(returnText()), button -> {
			AutoFish.autoFish = !AutoFish.autoFish;
			button.setMessage(Text.of(returnText()));
		}));
		this.addDrawableChild(new ButtonWidget((this.width / 2) - (buttonWidth / 2), (this.height / 2) - (buttonHeight / 2) + 30, buttonWidth, buttonHeight,
				Text.of("Back"), button -> {
			this.client.setScreen(this.parent);
		}));
		this.renderBackground( new MatrixStack());
	}



	public String returnText() {
		return AutoFish.autoFish ? "Auto fishing is enabled" : "Auto fishing is disabled";
	}


}
