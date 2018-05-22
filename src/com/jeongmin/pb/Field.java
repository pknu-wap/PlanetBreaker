package com.jeongmin.pb;

import java.awt.*;
import javax.swing.*;

public class Field extends JPanel{
	private int w,h;
	Ball ball;
	Brick brick;
	Field(int wide, int high){	//Field 생성자
		w = wide; h = high;		//폭, 높이
		setSize(w,h);
		setBackground(Color.white);
		ball = new Ball(this);
		brick = new Brick(this);
	}
	
	int getLeft(){return 0;} int getRight(){return w;}
	int getTop(){return 0;} int getBottom(){return h;}
	public void paint(Graphics g) {
		super.paint(g);
		ball.draw(g);
		ball.move();
		brick.draw(g);
	}
}
