package com.jeongmin.pb;

import java.awt.*;

public class Ball_jeongmin {
	Field_jeongmin field;
	int x, y; // 공 좌표
	int radius;
	double vx, vy; // 공 속도

	Ball_jeongmin(Field_jeongmin field) { // 공 생성자
		//x = field.getRight() / 2;
		//y = field.getBottom() / 2;
		x = 130;
		y = 200;
		vx = 2;
		vy = 2;
		this.field = field;
	}

	void draw(Graphics g) { // 공 그리기
		int radius = 5;
		g.setColor(Color.black);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

	void move() {
		x = x + (int) vx;
		y = y + (int) vy;
		checkBounds();
	}

	void checkBounds() { // 공이 벽에 부딪히면 튕김
		if (y < field.getTop()) {
			vy = -vy;
			//y = 2 * field.getTop() - y;
		}
		if (y + 2 * radius > field.getBottom()) {
			vy = -vy;
			//y = 2 * field.getBottom() - y;
		}
		if (x < field.getLeft()) {
			vx = -vx;
			//x = 2 * field.getLeft() - x;
		}
		if (x + 2 * radius > field.getRight()) {
			vx = -vx;
			//x = 2 * field.getRight() - x;
		}
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}
}
