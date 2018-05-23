package com.jeongmin.pb;

import java.awt.*;

public class Ball {
	String test;
	Field f;
	int x,y;	//ï¿½ï¿½ ï¿½ï¿½Ç¥
	int radius;
<<<<<<< HEAD
	double vx, vy;	//ï¿½ï¿½ ï¿½Óµï¿½
=======
	double vx, vy;	//°ø ¼Óµµ
	int test;	//Å×½ºÆ®¸¦ À§ÇÑ ¾Æ¹«°Íµµ ¾Æ´Ñ º¯¼ö
>>>>>>> 019201acd319b0726ad69661f0dae2db73976cec
	
	Ball(Field f){ //ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
		x = f.getRight()/2;
	    y = f.getBottom()/2; 
	    vx = 3; 
	    vy = 3; 
	    this.f = f;
	    }

	void draw(Graphics g) {	//ï¿½ï¿½ ï¿½×¸ï¿½ï¿½ï¿½
		int radius = 5;
		g.setColor(Color.black);
		g.fillOval(x-radius,
				y-radius,
				radius*2, radius*2);
	}
	
	void move(){
		x = x + (int)vx; y = y + (int)vy;
		System.out.println("ï¿½ï¿½(" + x + ", " + y + ").");
		checkBounds();					//ball ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Îµï¿½ï¿½Ì¸ï¿½ Æ¨ï¿½ï¿½
	}
	
	void checkBounds(){	//ball ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½Îµï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ý´ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ 
		if(y<f.getTop()){vy = -vy; y = 2*f.getTop()-y;}
		if(y+2*radius>f.getBottom()){vy = -vy; y = 2*f.getBottom()-y;}
		if(x<f.getLeft()){vx = -vx; x = 2*f.getLeft()-x;}
		if(x+2*radius>f.getRight()){vx = -vx; x = 2*f.getRight()-x;}
	}
	
	int getX(){return x;}
	int getY(){return y;}
}
