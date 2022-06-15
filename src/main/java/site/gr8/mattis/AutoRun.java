package site.gr8.mattis;

public class AutoRun {

	public static boolean run = false;

	public static void tick() {
		while (Julkinen.runKey.wasPressed()) {
			run = !run;
			Julkinen.LOGGER.info("Pressed run run="+run);
		}
	}
}
