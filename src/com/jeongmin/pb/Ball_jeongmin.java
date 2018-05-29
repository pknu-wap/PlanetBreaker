package com.jeongmin.pb;

import java.awt.*;

public class Ball_jeongmin {
	Field_jeongmin field;
	Play_jeongmin play;
	int x, y; // 공 좌표
	int init_x = 265;
	int init_y = 500;
	int radius;
	double vx, vy; // 공 속도
	double stop_v;
	
	int num;
	int cx ;
	int cy ;
	int x1,y1,w,h,d;

	Ball_jeongmin(Field_jeongmin field,Play_jeongmin play) { // 공 생성자
		// x = field.getRight() / 2;
		// y = field.getBottom() / 2;
		x = 300;
		y = 400;
		vx = 0;
		vy = 0;
		stop_v = 0;
		this.field = field;
		this.play = play;
	}

	void draw(Graphics g) { // 공 그리기
		int radius = 5;
		g.setColor(Color.white);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

	void move() {
		x = x + (int) vx;
		y = y + (int) vy;
		checkBounds();
		bound();
	}

	void checkBounds() { // 벽에 부딪혔는지 체크
		if (y < field.getTop()) {
			vy = -vy;
			y = 2 * field.getTop() - y;
		}
		if (y + 2 * radius > field.getBottom()) {
			vy = -vy;
			y = 2 * field.getBottom() - y;
		}
		if (x < field.getLeft()) {
			vx = -vx;
			x = 2 * field.getLeft() - x;
		}
		if (x + 2 * radius > field.getRight()) {
			vx = -vx;
			x = 2 * field.getRight() - x;
		}
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}
	
	void bound() {
		x1 = play.bar.getX1();
		y1 = play.bar.getY1();
		w = play.bar.getWidth();
		h = play.bar.getHeight();
		num = play.bar.getNum();
		cx = x-radius;
		cy = y-radius;
	
		
		switch(num) {
		case 0:
			if((x1<cx&&cx<x1+w)&&cy==y1)
				vy = -vy;
			break;
		case 1:
			if((y1<cy&&cy<y1+h)&&cx==x1)
				vx = -vx;
			break;
		case 2:
			if((x1<cx&&cx<x1+w)&&cy==(y1+h))
				vy = -vy;
			break;
		case 3:
			if((y1<cy&&cy<y1+h)&&cx==x1+w)
				vx = -vx;
			break;
		}
	}
}
