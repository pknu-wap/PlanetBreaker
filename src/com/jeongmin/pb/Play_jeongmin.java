package com.jeongmin.pb;

import java.awt.*;
import javax.swing.*;

public class Play_jeongmin {
	Ball_jeongmin ball;
	Brick_jeongmin[] brick;
	Field_jeongmin field;
	int breaked_brick_number;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Play_jeongmin();
	}

	Play_jeongmin() {
		field = new Field_jeongmin(320, 240, this);
		ball = new Ball_jeongmin(field);
		brick = new Brick_jeongmin[20];
		breaked_brick_number = 0;
		brick[0] = new Brick_jeongmin(field, ball, 40, 40);
		brick[1] = new Brick_jeongmin(field, ball, 70, 40);
		brick[2] = new Brick_jeongmin(field, ball, 100, 40);
		brick[3] = new Brick_jeongmin(field, ball, 130, 40);
		brick[4] = new Brick_jeongmin(field, ball, 160, 40);
		brick[5] = new Brick_jeongmin(field, ball, 40, 70);
		brick[6] = new Brick_jeongmin(field, ball, 70, 70);
		brick[7] = new Brick_jeongmin(field, ball, 100, 70);
		brick[8] = new Brick_jeongmin(field, ball, 130, 70);
		brick[9] = new Brick_jeongmin(field, ball, 160, 70);
		brick[10] = new Brick_jeongmin(field, ball, 40, 100);
		brick[11] = new Brick_jeongmin(field, ball, 70, 100);
		brick[12] = new Brick_jeongmin(field, ball, 100, 100);
		brick[13] = new Brick_jeongmin(field, ball, 130, 100);
		brick[14] = new Brick_jeongmin(field, ball, 160, 100);
		brick[15] = new Brick_jeongmin(field, ball, 40, 130);
		brick[16] = new Brick_jeongmin(field, ball, 70, 130);
		brick[17] = new Brick_jeongmin(field, ball, 100, 130);
		brick[18] = new Brick_jeongmin(field, ball, 130, 130);
		brick[19] = new Brick_jeongmin(field, ball, 160, 130);

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
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void start() {
		breaking();
	}

	void breaking() {
		while (true) {
			ball.move();
			field.repaint(); // paint 호출
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}
}
