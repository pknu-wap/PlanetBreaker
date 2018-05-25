package com.jeongmin.pb;

import java.awt.*;
import javax.swing.*;

public class Play_jeongmin {
	Ball_jeongmin ball;
	Brick_jeongmin[] brick;
	Field_jeongmin field;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Play_jeongmin();
	}

	Play_jeongmin() {
		field = new Field_jeongmin(320, 240, this);
		ball = new Ball_jeongmin(field);
		brick = new Brick_jeongmin[3];
		brick[0] = new Brick_jeongmin(field, ball, 40, 40);
		brick[1] = new Brick_jeongmin(field, ball, 70, 40);
		brick[2] = new Brick_jeongmin(field, ball, 40, 70);

		JPanel pan = new JPanel(null);
		pan.setBackground(Color.BLACK);
		pan.add(field);
		field.setLocation(20, 10);

		JFrame f = new JFrame("Planet Breaker");
		f.getContentPane().add(pan);
		f.setSize(320 + 65, 240 + 60);
		f.setVisible(true);
		f.setResizable(false);
		start(); // 시작
	}

	void start() {
		breaking();
	}

	void breaking() {
		while (true) {
			ball.move();
			field.repaint(); // paint 호출
			try {
				Thread.sleep(20);
			} catch (Exception e) {
			}
		}
	}
}
