package com.jeongmin.pb;

import java.awt.*;

public class Ball {
	String test;
	Field f;
	int x,y;	//�� ��ǥ
	int radius;
	double vx, vy;	//�� �ӵ�
	
	Ball(Field f){ //�� ������
		x = f.getRight()/2;
	    y = f.getBottom()/2; 
	    vx = 3; 
	    vy = 3; 
	    this.f = f;
	    }

	void draw(Graphics g) {	//�� �׸���
		int radius = 5;
		g.setColor(Color.black);
		g.fillOval(x-radius,
				y-radius,
				radius*2, radius*2);
	}
	
	void move(){
		x = x + (int)vx; y = y + (int)vy;
		System.out.println("��(" + x + ", " + y + ").");
		checkBounds();					//ball �� ���� �ε��̸� ƨ��
	}
	
	void checkBounds(){	//ball �� ���� �ε����� �ݴ� �������� 
		if(y<f.getTop()){vy = -vy; y = 2*f.getTop()-y;}
		if(y+2*radius>f.getBottom()){vy = -vy; y = 2*f.getBottom()-y;}
		if(x<f.getLeft()){vx = -vx; x = 2*f.getLeft()-x;}
		if(x+2*radius>f.getRight()){vx = -vx; x = 2*f.getRight()-x;}
	}
	
	int getX(){return x;}
	int getY(){return y;}
}
