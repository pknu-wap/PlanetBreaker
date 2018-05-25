package com.jeongmin.pb;

import java.awt.*;

public class Brick_jeongmin {
	Field_jeongmin f;
	Ball_jeongmin b;
	int x;
	int y;
	int width;
	int height;

	Brick_jeongmin(Field_jeongmin f, Ball_jeongmin b, int x, int y) {
		this.f = f;
		this.x = x;
		this.y = y;
		this.b = b;
		width = 20;
		height = 20;
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
		intersect(b);
	}

	void intersect(Ball_jeongmin b) {
		double distance;
		distance = Math.pow((double) ((x + width / 2) - (b.x + b.radius)), 2.0);
		distance = distance + Math.pow((double) ((y + height / 2) - (b.y + b.radius)), 2.0);
		distance = Math.sqrt(distance);
		if (distance <= b.radius + (width / 2 + height / 2) / 2 + 5) {
			b.vx = -(b.vx);
			// b.vy = -(b.vy);
		}
	}
}
