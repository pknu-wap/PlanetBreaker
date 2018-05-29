package com.jeongmin.pb;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;


import javax.imageio.ImageIO;
import javax.swing.*;

public class Play_jeongmin extends JFrame{
	Ball_jeongmin ball;
	Brick_jeongmin[] brick;
	Field_jeongmin field;
	Bar_jeongmin bar;
	int breaked_brick_number;
	private BufferedImage image,title;
	JPanel startPanel = new SPanel();
	JPanel gamePanel = new JPanel(null);
	JButton sb,eb;
	
	class SPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(title,0,0,785,805,null);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Play_jeongmin();
	}

	Play_jeongmin() {
		try {
			title = ImageIO.read(new File("title.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0); 
		}
		field = new Field_jeongmin(800, 800, this);
		ball = new Ball_jeongmin(field,this);
		bar = new Bar_jeongmin(field);
		makeBricks();
		
		
		startPanel.setVisible(true);
		startPanel.setLayout(null);
		sb = new JButton("Game Start");
		sb.setBounds(330, 530, 120, 30);
		sb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				startPanel.setVisible(false);
				remove(startPanel);
				gamePanel.setVisible(true);
			}
		});
		startPanel.add(sb);
		eb = new JButton("Exit");
		eb.setBounds(330, 600, 120, 30);
		eb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		startPanel.add(eb);
		
		gamePanel.add(field);
		field.setLocation(0, 0);
		
		
		add(gamePanel);
		add(startPanel);
		setSize(785, 805);
		setVisible(true);
		setResizable(false);
		start();
		setTitle("Planet Breaker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void start() {
		breaking();
	}

	void breaking() {
		while (true) {
			if(breaked_brick_number==0)
				nextLevel();
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
		ball.x = ball.init_x;
		ball.y = ball.init_y;
		breaked_brick_number = 75;
	}
	void makeBricks() {
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
	}


	

}
