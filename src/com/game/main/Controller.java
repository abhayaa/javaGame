package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Controller extends KeyAdapter {

	private Handeler handeler;

	public Controller(Handeler handeler) {
		this.handeler = handeler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handeler.object.size(); i++) {
			GameObject temp = handeler.object.get(i);

			if (temp.getID() == ID.Player) {
				// key events for player 1

				if (key == KeyEvent.VK_W)
					temp.setVelY(-5);
				if (key == KeyEvent.VK_S)
					temp.setVelY(5);
				if (key == KeyEvent.VK_A)
					temp.setVelX(-5);
				if (key == KeyEvent.VK_D)
					temp.setVelX(5);
			}

		}
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handeler.object.size(); i++) {
			GameObject temp = handeler.object.get(i);

			if (temp.getID() == ID.Player) {
				// key events for player 1

				if (key == KeyEvent.VK_W)
					temp.setVelY(0);
				if (key == KeyEvent.VK_S)
					temp.setVelY(0);
				if (key == KeyEvent.VK_A)
					temp.setVelX(0);
				if (key == KeyEvent.VK_D)
					temp.setVelX(0);
			}

		}
	}
}
