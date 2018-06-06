package com.nap.pb;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	Field f;
	Ball b;
	int x;
	int y;
	int width;
	int height;

	int after_striking_x;
	int after_striking_y;

	int basic_x;
	int basic_y;

	int armor; // armor만큼 부딪혀야 벽돌 사라짐
	int basic_armor;

	Brick(Field f, Ball b, int x, int y, int armor) {
		this.x = x;
		this.y = y;

		this.b = b;
		this.f = f;

		width = 20;
		height = 20;

		basic_x = x;
		basic_y = y;

		after_striking_x = 1000;
		after_striking_y = 1000;

		this.armor = armor;
		basic_armor = armor;
	}

	void draw(Graphics g) {
		if (armor == 6)
			g.setColor(Color.red);
		else if (armor == 5)
			g.setColor(Color.magenta);
		else if (armor == 4)
			g.setColor(Color.gray);
		else if (armor == 3)
			g.setColor(Color.darkGray);
		else if (armor == 2)
			g.setColor(Color.yellow);
		else if (armor == 1)
			g.setColor(Color.orange);
		g.fillRect(x, y, width, height);
		intersect(b);
	}

	void intersect(Ball b) {
		// 벽돌 왼쪽에 부딪혔을 경우
		if (b.vx >= 0) {
			if ((b.x >= x - 2 * b.radius && b.x <= x - 2 * b.radius + 1)
					&& (b.y <= y + height - b.radius + 1 && b.y >= y - b.radius - 1)) {
				b.vx = -(b.vx);
				armor--;
				b.sound("sound\\ball.wav");
				if (armor == 0) {
					x = after_striking_x;
					y = after_striking_y;
					f.play.breaked_brick_number--;
				}
			}
		}
		// 벽돌 오론쪽에 부딪혔을 경우
		if (b.vx <= 0) {
			if ((b.x >= x + width - 1 && b.x <= x + width)
					&& (b.y <= y + height - b.radius + 1 && b.y >= y - b.radius - 1)) {
				b.vx = -(b.vx);
				armor--;
				b.sound("sound\\ball.wav");
				if (armor == 0) {
					x = after_striking_x;
					y = after_striking_y;
					f.play.breaked_brick_number--;
				}
			}
		}

		// 벽돌 윗면에 부딪혔을 경우
		if (b.vy >= 0) {
			if ((b.x >= x - b.radius - 1 && b.x <= x + width - b.radius + 1)
					&& (b.y >= y - 2 * b.radius - 1 && b.y <= y - 2 * b.radius)) {
				b.vy = -(b.vy);
				armor--;
				b.sound("sound\\ball.wav");
				if (armor == 0) {
					x = after_striking_x;
					y = after_striking_y;
					f.play.breaked_brick_number--;
				}
			}
		}
		// 벽돌 아래면에 부딪혔을 경우
		if (b.vy <= 0) {
			if ((b.x >= x - b.radius - 1 && b.x <= x + width - b.radius + 1)
					&& (b.y >= y + height && b.y <= y + height + 1)) {
				b.vy = -(b.vy);
				armor--;
				b.sound("sound\\ball.wav");
				if (armor == 0) {
					x = after_striking_x;
					y = after_striking_y;
					f.play.breaked_brick_number--;
				}
			}
		}
	}
}