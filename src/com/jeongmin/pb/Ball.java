package com.jeongmin.pb;

import java.awt.*;

public class Ball {
	Field f;
	int x,y;	//공 좌표
	int radius;
	double vx, vy;	//공 속도
	
	Ball(Field f){x = f.getRight()/2; y = f.getBottom()/2; vx = 3; vy = 3; this.f = f;}	//공 생성자
	
	void draw(Graphics g) {	//공 그리기
		int radius = 5;
		g.setColor(Color.black);
		g.fillOval(x-radius,
				y-radius,
				radius*2, radius*2);
	}
	
	void move(){
		x = x + (int)vx; y = y + (int)vy;
		System.out.println("공(" + x + ", " + y + ").");
		checkBounds();					//ball 이 벽에 부딪이면 튕김
	}
	
	void checkBounds(){	//ball 이 벽에 부딪히면 반대 방향으로 
		if(y<f.getTop()){vy = -vy; y = 2*f.getTop()-y;}
		if(y>f.getBottom()){vy = -vy; y = 2*f.getBottom()-y;}
		if(x<f.getLeft()){vx = -vx; x = 2*f.getLeft()-x;}
		if(x>f.getRight()){vx = -vx; x = 2*f.getRight()-x;}
	}
	
	int getX(){return x;}
	int getY(){return y;}
}
