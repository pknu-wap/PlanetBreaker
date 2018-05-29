package com.jin.pb;


import java.awt.*;
import javax.swing.*;

public class Field_jin extends JPanel {
	private int w, h;
	PlanetBreakerBg_Jin play;

	Field_jin(int wide, int high, PlanetBreakerBg_Jin play) { // Field 생성자
		this.play = play;
		w = wide;
		h = high; // 폭, 높이
		setSize(w, h);
		setBackground(Color.white);
	}

	int getLeft() {
		return 0;
	}

	int getRight() {
		return w;
	}

	int getTop() {
		return 0;
	}

	int getBottom() {
		return h;
	}

	public void paint(Graphics g) {
		super.paint(g);
		play.ball.draw(g);
		for(int i = 0;i<20;i++)
			play.brick[i].draw(g);
	}
}
