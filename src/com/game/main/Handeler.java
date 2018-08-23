package com.game.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handeler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObj = object.get(i);

			tempObj.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObj = object.get(i);

			tempObj.render(g);
		}
	}

	public void addObj(GameObject obj) {
		this.object.add(obj);

	}

	public void removeObj(GameObject obj) {
		this.object.remove(object);
	}
}
