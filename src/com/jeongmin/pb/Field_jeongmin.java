package com.jeongmin.pb;

import java.awt.*;
import javax.swing.*;

public class Field_jeongmin extends JPanel{
	private int w,h;
	Ball_jeongmin ball;
	Brick_jeongmin brick[];
	Field_jeongmin(int wide, int high){	//Field 생성자
		w = wide; h = high;		//폭, 높이
		setSize(w,h);
		setBackground(Color.white);
		ball = new Ball_jeongmin(this);
		
		brick = new Brick_jeongmin[5];
		int x = 30;
		for(int i = 0;i<brick.length;i++) {
			brick[i] = new Brick_jeongmin(this, ball, x, 50);
			x += 50;
		}
	}
	
	int getLeft(){return 0;} int getRight(){return w;}
	int getTop(){return 0;} int getBottom(){return h;}
	public void paint(Graphics g) {
		super.paint(g);
		ball.draw(g);
		ball.move();
		for(int i = 0;i<brick.length;i++)
		{
			brick[i].draw(g);
			brick[i].intersect(ball);
		}
	}
}
