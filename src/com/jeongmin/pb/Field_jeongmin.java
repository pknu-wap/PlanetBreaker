package com.jeongmin.pb;

import java.awt.*;
import javax.swing.*;

public class Field_jeongmin extends JPanel {
	private int w, h;
	Play_jeongmin play;

	Field_jeongmin(int wide, int high, Play_jeongmin play) { // Field 생성자
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
