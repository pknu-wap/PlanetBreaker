package com.jin.pb;

import java.awt.Color;
import java.awt.Graphics;

public class Brick_jin {
	Field_jin f;
	Ball_jin b;
	int x;
	int y;
	int width;
	int height;
	
	int after_striking_x;
	int after_striking_y;
	
	Brick_jin(Field_jin f, Ball_jin b, int x, int y) {
		this.f = f;
		this.x = x;
		this.y = y;
		this.b = b;
		width = 20;
		height = 20;
		after_striking_x = 1000;
		after_striking_y = 1000;
	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
		intersect(b);
	}

	void intersect(Ball_jin b) {
		//공이 벽돌의 왼쪽면에 부딪혔을 경우
		if(b.vx>=0) {
			if((b.x>=x-2*b.radius&&b.x<=x-2*b.radius+1)&&(b.y<=y+height-b.radius+1&&b.y>=y-b.radius-1))
				{
					b.vx = -(b.vx);
					x = after_striking_x;
					y = after_striking_y;
				}
		}
		//공이 벽돌의 오른쪽면에 부딪혔을 경우
		if(b.vx<=0) {
			if((b.x>=x+width-1&&b.x<=x+width)&&(b.y<=y+height-b.radius+1&&b.y>=y-b.radius-1))
				{
					b.vx = -(b.vx);
					x = after_striking_x;
					y = after_striking_y;
				}
		}
		
		//공이 벽돌의 윗면에 부딪혔을 경우
		if(b.vy>=0) {
			if((b.x>=x-b.radius-1&&b.x<=x+width-b.radius+1)&&(b.y>=y-2*b.radius-1&&b.y<=y-2*b.radius))
				{
					b.vy = -(b.vy);
					x = after_striking_x;
					y = after_striking_y;
				}
		}
		//공이 벽돌의 아래면에 부딪혔을 경우
		if(b.vy<=0) {
			if((b.x>=x-b.radius-1&&b.x<=x+width-b.radius+1)&&(b.y>=y+height&&b.y<=y+height+1))
				{
					b.vy = -(b.vy);
					x = after_striking_x;
					y = after_striking_y;
				}
		}
	}
}
