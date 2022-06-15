package site.gr8.mattis;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class INeedAwesomeScreen extends Screen {

	private int buttonWidth = 200;
	private int buttonHeight = 20;

	public INeedAwesomeScreen() {
		super(Text.of(""));
	}

	@Override
	public void init() {
		this.addDrawableChild(new ButtonWidget((this.width / 2) - (buttonWidth / 2), (this.height / 2) - (buttonHeight / 2), buttonWidth, buttonHeight,
				Text.of(returnText()), button -> {
			AutoFish.autoFish = !AutoFish.autoFish;
			button.setMessage(Text.of(returnText()));
		}));
	}



	public String returnText() {
		return AutoFish.autoFish ? "Auto fishing is enabled" : "Auto fishing is disabled";
	}


}
