package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD implements GameMethods {

	public static int HEALTH = 100;

	public int clamp(int var, int min, int max) {

		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}

	public void tick() {
		HEALTH--;
		HEALTH = clamp(HEALTH, 0, 100);
	}

	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 10);

		g.setColor(Color.GREEN);
		g.fillRect(15, 15, HEALTH * 2, 10);

		g.setColor(Color.white);
		g.drawRect(15, 15, HEALTH * 2, 10);

	}

}
