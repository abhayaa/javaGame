package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject implements GameMethods {
	

	public Player(int x, int y, ID id) {
		super(x, y, id);

	}

	public int clamp(int var, int min, int max) {

		if (var >= max)
			return var = min;
		else if (var <= min)
			return var = max;
		else
			return var;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		x = clamp(x, 0, Game.WIDTH - 37);
		y = clamp(y, 0, Game.HEIGHT - 60);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);

	}

}
