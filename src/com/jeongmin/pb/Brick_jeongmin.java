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
		//double distance;
		//distance = Math.pow((double) ((x + width / 2) - (b.x + b.radius)), 2.0);
		//distance = distance + Math.pow((double) ((y + height / 2) - (b.y + b.radius)), 2.0);
		//distance = Math.sqrt(distance);
		//if (distance <= b.radius + (width / 2 + height / 2) / 2 + 5) {
		//	b.vx = -(b.vx);
		//	// b.vy = -(b.vy);
		//}
			
		//공이 벽돌의 왼쪽면에 부딪혔을 경우
		if(b.vx>=0) {
			if((b.x>=x-2*b.radius&&b.x<=x-2*b.radius+1)&&(b.y<=y+height-b.radius+1&&b.y>=y-b.radius-1))
				b.vx = -(b.vx);
		}
		//공이 벽돌의 오른쪽면에 부딪혔을 경우
		if(b.vx<=0) {
			if((b.x>=x+width-1&&b.x<=x+width)&&(b.y<=y+height-b.radius+1&&b.y>=y-b.radius-1))
				b.vx = -(b.vx);
		}
		
		//공이 벽돌의 윗면에 부딪혔을 경우
		if(b.vy>=0) {
			if((b.x>=x-b.radius-1&&b.x<=x+width-b.radius+1)&&(b.y>=y-2*b.radius-1&&b.y<=y-2*b.radius))
				b.vy = -(b.vy);
		}
		//공이 벽돌의 아래면에 부딪혔을 경우
		if(b.vy<=0) {
			if((b.x>=x-b.radius-1&&b.x<=x+width-b.radius+1)&&(b.y>=y+height&&b.y<=y+height+1))
				b.vy = -(b.vy);
		}
	}
}
