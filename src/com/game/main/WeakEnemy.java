package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class WeakEnemy extends GameObject {

	public WeakEnemy(int x, int y, ID id) {
		super(x, y, id);
		velX = 5;
		velY = 5;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		if (y <= 0 || y >= Game.HEIGHT - 32)
			velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 32)
			velX *= -1;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 16, 16);

	}

}
