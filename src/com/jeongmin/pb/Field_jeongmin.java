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
		play.brick[0].draw(g);
		play.brick[1].draw(g);
		play.brick[2].draw(g);
		play.brick[3].draw(g);
		play.brick[4].draw(g);
		play.brick[5].draw(g);
		play.brick[6].draw(g);
		play.brick[7].draw(g);
		play.brick[8].draw(g);
		play.brick[9].draw(g);
	}
}
