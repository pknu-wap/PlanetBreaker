package com.jeongmin.pb;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	Field f;
	int x;
	int y;
	int width;
	int height;
	
	Brick(Field f){
		x = 100;
		y = 100;
		width = 30;
		height = 20;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
	}
}
