package site.gr8.mattis.mixin;

import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import site.gr8.mattis.AutoRun;

@Mixin(KeyboardInput.class)
public class KeyboardInputMixin extends Input {

	@Redirect(method = "tick", at = @At(
			value = "FIELD",
			target = "net/minecraft/client/input/KeyboardInput.pressingForward:Z",
			opcode = Opcodes.GETFIELD,
			ordinal = 0))
	private boolean autorun(KeyboardInput input) {
		input.pressingForward = input.pressingForward || AutoRun.run;
		return input.pressingForward;
	}
}
