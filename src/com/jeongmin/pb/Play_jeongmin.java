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
	int breaked_brick_number;
	private BufferedImage image;

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		new Play_jeongmin();
	}

	Play_jeongmin() {
		field = new Field_jeongmin(600, 580, this);
		ball = new Ball_jeongmin(field);
		brick = new Brick_jeongmin[20];
		breaked_brick_number = 0;
		brick[0] = new Brick_jeongmin(field, ball, 40, 40,4);
		brick[1] = new Brick_jeongmin(field, ball, 70, 40,4);
		brick[2] = new Brick_jeongmin(field, ball, 100, 40,4);
		brick[3] = new Brick_jeongmin(field, ball, 130, 40,4);
		brick[4] = new Brick_jeongmin(field, ball, 160, 40,4);
		brick[5] = new Brick_jeongmin(field, ball, 40, 70,3);
		brick[6] = new Brick_jeongmin(field, ball, 70, 70,3);
		brick[7] = new Brick_jeongmin(field, ball, 100, 70,3);
		brick[8] = new Brick_jeongmin(field, ball, 130, 70,3);
		brick[9] = new Brick_jeongmin(field, ball, 160, 70,3);
		brick[10] = new Brick_jeongmin(field, ball, 40, 100,2);
		brick[11] = new Brick_jeongmin(field, ball, 70, 100,2);
		brick[12] = new Brick_jeongmin(field, ball, 100, 100,2);
		brick[13] = new Brick_jeongmin(field, ball, 130, 100,2);
		brick[14] = new Brick_jeongmin(field, ball, 160, 100,2);
		brick[15] = new Brick_jeongmin(field, ball, 40, 130,1);
		brick[16] = new Brick_jeongmin(field, ball, 70, 130,1);
		brick[17] = new Brick_jeongmin(field, ball, 100, 130,1);
		brick[18] = new Brick_jeongmin(field, ball, 130, 130,1);
		brick[19] = new Brick_jeongmin(field, ball, 160, 130,1);
		
		try {
			image = ImageIO.read(new File("space_background.png")); // 이미지 읽기
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0); // 오류발생시 메세지 출력 및 종료
		}

		JPanel pan = new JPanel(null);
		pan.add(field);
		field.setLocation(0, 0);

		JFrame f = new JFrame("Planet Breaker");
		f.getContentPane().add(pan);
		f.setSize(600, 600);
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
