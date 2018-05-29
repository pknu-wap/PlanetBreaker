package com.jeongmin.pb;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Play_jeongmin {
	Ball_jeongmin ball;
	Brick_jeongmin[] brick;
	Field_jeongmin field;
	Bar_jeongmin bar;
	int breaked_brick_number;
	private BufferedImage image;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Play_jeongmin();
	}

	Play_jeongmin() {
		field = new Field_jeongmin(600, 580, this);
		ball = new Ball_jeongmin(field);
		bar = new Bar_jeongmin();
		brick = new Brick_jeongmin[76];
		breaked_brick_number = 75;
		for (int i = 0; i < 4; i++)
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * i + 75, 140, 1);
		for (int i = 4; i < 10; i++) {
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 4) + 50, 140 + 25, 2);
			if (i == 4 || i == 9)
				brick[i].armor = 1;
		}
		for (int i = 10; i < 18; i++) {
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 10) + 25, 140 + 25 * 2, 2);
			if (i == 10 || i == 17)
				brick[i].armor = 1;
			else if (i == 13 || i == 14)
				brick[i].armor = 3;
		}
		for (int i = 18; i < 28; i++) {
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 18), 140 + 25 * 3, 2);
			if (i == 18 || i == 27)
				brick[i].armor = 1;
			else if (i >= 21 && i <= 24)
				brick[i].armor = 3;
		}
		for (int i = 28; i < 38; i++) {
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 28), 140 + 25 * 4, 3);
			if (i == 28 || i == 37)
				brick[i].armor = 1;
			else if (i == 29 || i == 36)
				brick[i].armor = 2;
			else if (i == 32 || i == 33)
				brick[i].armor = 4;
		}
		for (int i = 38; i < 48; i++) {
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 38), 140 + 25 * 5, 3);
			if (i == 38 || i == 47)
				brick[i].armor = 1;
			else if (i == 39 || i == 46)
				brick[i].armor = 2;
			else if (i == 42 || i == 43)
				brick[i].armor = 4;
		}
		for (int i = 48; i < 58; i++) {
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 48), 140 + 25 * 6, 2);
			if (i == 48 || i == 57)
				brick[i].armor = 1;
			else if (i >= 51 && i <= 54)
				brick[i].armor = 3;
		}
		for (int i = 58; i < 66; i++) {
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 58) + 25, 140 + 25 * 7, 2);
			if (i == 58 || i == 65)
				brick[i].armor = 1;
			else if (i == 61 || i == 62)
				brick[i].armor = 3;
		}
		for (int i = 66; i < 72; i++) {
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 66) + 50, 140 + 25 * 8, 2);
			if (i == 66 || i == 71)
				brick[i].armor = 1;
		}
		for (int i = 72; i < 76; i++)
			brick[i] = new Brick_jeongmin(field, ball, 140 + 25 * (i - 72) + 75, 140 + 25 * 9, 1);

		try {
			image = ImageIO.read(new File("space_background.png")); // 배경화면
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		JPanel pan = new JPanel(null);
		pan.add(field);
		field.setLocation(0, 0);

		JFrame f = new JFrame("Planet Breaker");
		f.getContentPane().add(pan);
		f.setSize(600, 600);
		f.setVisible(true);
		f.setResizable(false);
		start();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void start() {
		breaking();
	}

	void breaking() {
		while (true) {
			ball.move();
			field.repaint();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}
	
	void nextLevel() {
		for(int i = 0;i<76;i++) {
			brick[i].basic_armor++;
			brick[i].armor = brick[i].basic_armor;
			brick[i].x = brick[i].basic_x;
			brick[i].y = brick[i].basic_y;
		}
	}
}
