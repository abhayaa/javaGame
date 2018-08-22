package com.game.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends Canvas{

	private static final long serialVersionUID = 2618658522386099128L;


	public Frame(int width, int height, String title, Game game){
		JFrame window = new JFrame(title); 
		
		window.setPreferredSize(new Dimension(width, height));
		window.setMaximumSize(new Dimension(width, height));
		window.setMinimumSize(new Dimension(width, height));
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.add(game);
		window.setVisible(true);
		game.start();
		
	}

}
