package ru.panzergame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.panzergame.Constant;
import ru.panzergame.PanzerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constant.WIDTH;
		config.height = Constant.HEIGHT;
		config.title = Constant.TITLE;
		new LwjglApplication(new PanzerGame(), config);
	}
}
