package site.gr8.mattis;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class AutoRun {

	public static boolean run = false;
	public static KeyBinding key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.wannabright.autorun", GLFW.GLFW_KEY_R, "category.wannabright.title"));

	public static void tick() {
		while (key.wasPressed()) {
			run = !run;
			WannaBright.LOGGER.info("Pressed run run="+run);
		}
	}
}
