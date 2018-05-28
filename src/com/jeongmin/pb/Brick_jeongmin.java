package com.jeongmin.pb;

import java.awt.*;

public class Brick_jeongmin {
	Field_jeongmin f;
	Ball_jeongmin b;
	int x;
	int y;
	int width;
	int height;
	
	int after_striking_x;
	int after_striking_y;
	
	int basic_x;
	int basic_y;
	
	int armor;	//armor만큼 ball과 충돌해야 벽돌이 깨짐
	
	Brick_jeongmin(Field_jeongmin f, Ball_jeongmin b, int x, int y, int armor) {
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
	}

	void draw(Graphics g) {
		if(armor==4)
			g.setColor(Color.gray);
		else if(armor==3)
			g.setColor(Color.darkGray);
		else if(armor==2)
			g.setColor(Color.yellow);
		else if(armor==1)
			g.setColor(Color.orange);
		g.fillRect(x, y, width, height);
		intersect(b);
	}

	void intersect(Ball_jeongmin b) {
		//공이 벽돌의 왼쪽면에 부딪혔을 경우
		if(b.vx>=0) {
			if((b.x>=x-2*b.radius&&b.x<=x-2*b.radius+1)&&(b.y<=y+height-b.radius+1&&b.y>=y-b.radius-1))
				{
					b.vx = -(b.vx);
					armor--;
					if(armor==0) {
						x = after_striking_x;
						y = after_striking_y;
					}
				}
		}
		//공이 벽돌의 오른쪽면에 부딪혔을 경우
		if(b.vx<=0) {
			if((b.x>=x+width-1&&b.x<=x+width)&&(b.y<=y+height-b.radius+1&&b.y>=y-b.radius-1))
				{
					b.vx = -(b.vx);
					armor--;
					if(armor==0) {
						x = after_striking_x;
						y = after_striking_y;
					}
				}
		}
		
		//공이 벽돌의 윗면에 부딪혔을 경우
		if(b.vy>=0) {
			if((b.x>=x-b.radius-1&&b.x<=x+width-b.radius+1)&&(b.y>=y-2*b.radius-1&&b.y<=y-2*b.radius))
				{
					b.vy = -(b.vy);
					armor--;
					if(armor==0) {
						x = after_striking_x;
						y = after_striking_y;
					}
				}
		}
		//공이 벽돌의 아래면에 부딪혔을 경우
		if(b.vy<=0) {
			if((b.x>=x-b.radius-1&&b.x<=x+width-b.radius+1)&&(b.y>=y+height&&b.y<=y+height+1))
				{
					b.vy = -(b.vy);
					armor--;
					if(armor==0) {
						x = after_striking_x;
						y = after_striking_y;
					}
				}
		}
	}
}
