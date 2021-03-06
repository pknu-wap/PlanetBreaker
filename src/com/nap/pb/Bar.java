package com.nap.pb;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Bar {

	private BufferedImage ship0, ship1, ship2, ship3;

	private int frameX1 = 10;
	private int frameY1 = 10;
	private int frameD = 750;
	private int frameX2 = frameX1 + frameD;
	private int frameY2 = frameY1 + frameD;
	private int space = 15;

	int w = 113; // 바의 크기
	int h = 43; // 바의 높이
	int x1 = frameX1 + frameD / 2 - w / 2; // 바의 x좌표
	int y1 = frameY2 - space - h; // 바의 y좌표
	private int dx = 5; // 바의 속도
	int num = 0; // 면의 번호
	private int d;

	int init_x1 = x1;
	int init_y1 = y1;
	int init_num = num;
	int init_w = w;
	int init_h = h;

	BufferedImage tmp;

	String movedir = null; // +바가 움직일 방향

	Field field;

	public Bar(Field field) {
		this.field = field;
		try {
			ship0 = ImageIO.read(new File("image\\Ship0.png")); // 비행기 이미지
			ship1 = ImageIO.read(new File("image\\Ship1.png"));
			ship2 = ImageIO.read(new File("image\\Ship2.png"));
			ship3 = ImageIO.read(new File("image\\Ship3.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(frameX1, frameY1, frameD, frameD);

		move(movedir); // +움직임과 동시에 바를 그려줌

		switch (num) {
		case 0:
			g.drawImage(ship0, x1, y1, null);
			break;
		case 1:
			g.drawImage(ship1, x1, y1, null);
			break;
		case 2:
			g.drawImage(ship2, x1, y1, null);
			break;
		case 3:
			g.drawImage(ship3, x1, y1, null);
			break;
		}

	}

	public void move(String movedir) {
		// System.out.println(x1 + " " + y1 + " " + num);

		if (field.keepMove == true) // 방향키를 눌렸을 경우에만(방향키를 누르면 keepMove가 true값이 됨)
		{
			switch (movedir) {
			case "+":
				switch (num) {
				case 0:
					x1 += dx;
					if (x1 >= frameX2 - w) {
						num = 1;
						changewh();
						x1 = frameX2 - w - space;
						y1 = frameY2 - h;
					}
					break;
				case 1:
					y1 -= dx;
					if (y1 <= frameY1) {
						num = 2;
						changewh();
						x1 = frameX2 - w;
						y1 = frameY1 + space;
					}
					break;
				case 2:
					x1 -= dx;
					if (x1 <= frameX1) {
						num = 3;
						changewh();
						x1 = frameX1 + space;
						y1 = frameY1;
					}
					break;
				case 3:
					y1 += dx;
					if (y1 >= frameY2 - space - h) {
						num = 0;
						changewh();
						x1 = frameX1;
						y1 = frameY2 - space - h;
					}
					break;
				}
				break;
			case "-":
				switch (num) {
				case 0:
					x1 -= dx;
					if (x1 <= frameX1) {
						num = 3;
						changewh();
						x1 = frameX1 + space;
						y1 = frameY2 - h;
					}
					break;
				case 1:
					y1 += dx;
					if (y1 >= frameY2 - h) {
						num = 0;
						changewh();
						x1 = frameX2 - w;
						y1 = frameY2 - h - space;
					}
					break;
				case 2:
					x1 += dx;
					if (x1 >= frameX2 - w) {
						num = 1;
						changewh();
						x1 = frameX2 - w - space;
						y1 = frameY1;
					}
					break;
				case 3:
					y1 -= dx;
					if (y1 <= frameY1) {
						num = 2;
						changewh();
						x1 = frameX1;
						y1 = frameY1 + space;
					}
					break;
				}
			}
		}
	}

	public void teleport() {
		switch (num) {
		case 0:
			num = 2;
			y1 = frameY1 + space;
			break;
		case 1:
			num = 3;
			x1 = frameX1 + space;
			break;
		case 2:
			num = 0;
			y1 = frameY2 - space - h;
			break;
		case 3:
			num = 1;
			x1 = frameX2 - space - w;
			break;
		}
	}

	public void changewh() {
		int tmp;
		tmp = w;
		w = h;
		h = tmp;
	}

	int getX1() {
		return x1;
	}

	int getY1() {
		return y1;
	}

	int getWidth() {
		return w;
	}

	int getHeight() {
		return h;
	}

	int getNum() {
		return num;
	}

	int getD(int num) {
		if (num == 0 || num == 2)
			d = w / 4;
		else if (num == 1 || num == 3)
			d = h / 4;
		return d;
	}

	void setDx(int dx) {
		this.dx = dx;
	}
}