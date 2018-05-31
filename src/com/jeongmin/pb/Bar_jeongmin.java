package com.jeongmin.pb;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

class Bar_jeongmin {
/*	private int frameX1 = 20;
	private int frameY1 = 15;
	private int frameD = 550;
	private int frameX2 = frameX1 + frameD;
	private int frameY2 = frameY1 + frameD;
	private int space = 10;

	int w = 100; // 바의 크기
	int h = 20; // 바의 높이
	int x1 = frameX1 + frameD / 2 - w / 2; // 바의 x좌표
	int y1 = frameY2 - space - h; // 바의 y좌표
	int dx = 10; // 바의 속도
	int num = 0; // 면의 번호
	private int d;*/
	
	
	private int frameX1 = 50;
	private int frameY1 = 50;
	private int frameD = 500;
	private int frameX2 = frameX1 + frameD;
	private int frameY2 = frameY1 + frameD;
	private int space = 10;
	
	private int w = 100;			//바의 크기
	private int h = 20;				//바의 높이
	private int x1=frameX1+frameD/2-w/2;				//바의 x좌표
	private int y1=frameY2-space-h;				//바의 y좌표
	private int dx=10;				//바의 속도
	private int num=0;				//면의 번호
	private int d;
	
	
	Field_jeongmin field;
	
	public Bar_jeongmin(Field_jeongmin field) {
		this.field = field;
	}

	public void draw(Graphics g) {
		// super.paintComponent(g);
		g.drawRect(frameX1, frameY1, frameD, frameD);
		g.drawRect(x1, y1, w, h);
	}

	public void move(int a) {
		System.out.println(x1 + "  " + y1 + " " + num);

		switch (a) {
		case 0:
			if (x1 > frameX1 && x1 < frameX2 - w && num == 0)
				x1 += dx;
			if (y1 > frameY1 && y1 < frameY2 - h && num == 1)
				y1 -= dx;
			if (x1 > frameX1 && x1 < frameX2 - w && num == 2)
				x1 -= dx;
			if (y1 > frameX1 && y1 < frameX2 - h && num == 3)
				y1 += dx;
			break;
		case 1:
			if (x1 > frameX1 && x1 < frameX2 - w && num == 0)
				x1 -= dx;
			if (y1 > frameY1 && y1 < frameY2 - h && num == 1)
				y1 += dx;
			if (x1 > frameX1 && x1 < frameX2 - w && num == 2)
				x1 += dx;
			if (y1 > frameX1 && y1 < frameX2 - h && num == 3)
				y1 -= dx;
			break;
		}
	}

	public void jump(int a) {
		switch (a) {
		case 0:
			// 0 -> 1
			if (x1 >= frameX2 - w && num == 0) {
				x1 = frameX2 - h - space;
				y1 = frameY2 - w - space;
				changewh();
				num = 1;
			}
			// 1 -> 2
			if (y1 <= frameY1 && num == 1) {
				x1 = frameX2 - h - space;
				y1 = frameY1 + space;
				changewh();
				num = 2;
			}
			// 2 -> 3
			if (x1 <= frameX1 && num == 2) {
				x1 = frameX1 + space;
				y1 = frameY1 + space;
				changewh();
				num = 3;
			} // 3 -> 0
			if (y1 >= frameY2 - h && num == 3) {
				x1 = frameX1 + space;
				y1 = frameY2 - w - space;
				changewh();
				num = 0;
			}
			break;
		case 1:
			// 0 -> 3
			if (x1 <= frameX1 && num == 0) {
				x1 = frameX1 + space;
				y1 = frameY2 - w - space;
				changewh();
				num = 3;
			}
			// 3 -> 2
			if (y1 <= frameY1 && num == 3) {
				x1 = frameX1 + space;
				y1 = frameY1 + space;
				changewh();
				num = 2;
			}
			// 2 -> 1
			if (x1 >= frameX2 - w && num == 2) {
				x1 = frameX2 - h - space;
				y1 = frameY1 + space;
				changewh();
				num = 1;
			}
			// 1 -> 0
			if (y1 >= frameY2 - h && num == 1) {
				x1 = frameX2 - h - space;
				y1 = frameY2 - w - space;
				changewh();
				num = 0;
			}
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
		if(num == 0||num==2)
			d = w/4;
		else if(num == 1||num == 3)
			d = h/4;
		return d;
	}
	void setDx(int dx) {
		this.dx = dx;
	}
}