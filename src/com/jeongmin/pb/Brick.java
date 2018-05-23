package com.jeongmin.pb;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	Field f;
	Ball b;
	int x;
	int y;
	int width;
	int height;
	
	Brick(Field f){
		this.f = f;
		x = 100;
		y = 100;
		width = 30;
		height = 20;
	}
	
	Brick(Field f, Ball b,int x, int y){
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
	}
	
	void intersect(Ball b) {
		double distance;
		distance = Math.pow((double)((x+width/2)-(b.x+b.radius)), 2.0);
		distance = distance + Math.pow((double)((y+height/2)-(b.y+b.radius)), 2.0);
		distance = Math.sqrt(distance);
		if(distance<=b.radius+(width/2+height/2)/2+5)
		{
			b.vx = -(b.vx);
			//b.vy = -(b.vy);
		}
	}
}
