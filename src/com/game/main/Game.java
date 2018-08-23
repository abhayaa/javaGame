package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private static final long serialVersionUID = -473349850293143017L;
	private Thread thread;
	private boolean running = false;
	private Handeler handeler;
	// private Random r;
	private HUD hud;

	public Game() {
		handeler = new Handeler();

		new Frame(WIDTH, HEIGHT, "Game Title", this);
		hud = new HUD();

		this.setFocusable(true);
		this.addKeyListener(new Controller(handeler));

		handeler.addObj(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player));

		handeler.addObj(new WeakEnemy(WIDTH / 2 - 10, HEIGHT / 2 - 10, ID.WeakEnemy));

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}

		}
		stop();
	}

	private void tick() {
		handeler.tick();
		hud.tick();
	}

	private void render() {
		BufferStrategy buff = this.getBufferStrategy();
		if (buff == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = buff.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handeler.render(g);
		hud.render(g);

		g.dispose();
		buff.show();
	}

	// public static int clamp(int var, int min, int max) {
	//
	// if (var >= max)
	// return var = min;
	// else if (var <= min)
	// return var = max;
	// else
	// return var;
	// }

	public static void main(String[] args) {
		new Game();

	}
}
