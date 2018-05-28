package com.jeongmin.pb;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

class Bar_jeongmin {
	String test;
	int frameX1 = 80;
	int frameY1 = 80;
	int frameD = 400;
	int frameX2 = frameX1 + frameD;
	int frameY2 = frameY1 + frameD;
	int space = 5;
	int w = 100;			//바의 크기
	int h = 30;				//바의 높이
	int x1=230;				//바의 x좌표
	int y1=440;				//바의 y좌표
	int x2 = x1+w;			
	int y2 = y1+h;
	int dx=5;				//바의 속도
	int num=0;						//면의 번호
	int cx,cy;				//충돌 좌표
	int bx,by;				//공의 좌표
	
	
	public Bar_jeongmin() {}
	public void draw(Graphics g) {
		//super.paintComponent(g);
		g.drawRect(frameX1,frameY1,frameD,frameD);
		g.drawRect(x1, y1, w, h);
	}
	public void move(int a){
		System.out.println(x1+"  "+y1+" "+num);
		
		switch(a) {
		case 0:
			if(x1>frameX1&&x1<frameX2-w&&num==0) x1+=dx;
			if(y1>frameY1&&y1<frameY2-h&&num==1) y1-=dx;
			if(x1>frameX1&&x1<frameX2-w&&num==2) x1-=dx;
			if(y1>frameX1&&y1<frameX2-h&&num==3) y1+=dx;
			break;
		case 1:
			if(x1>frameX1&&x1<frameX2-w&&num==0) x1-=dx;
			if(y1>frameY1&&y1<frameY2-h&&num==1) y1+=dx;
			if(x1>frameX1&&x1<frameX2-w&&num==2) x1+=dx;
			if(y1>frameX1&&y1<frameX2-h&&num==3) y1-=dx;
			break;
		}
	
	}
	public void jump() {
		//0 -> 1
		if(x1>=frameX2-w&&num==0) {
			x1 = frameX2-h-space;
			y1 = frameY2-w-space;
			changewh();
			num=1;
		}
		//1 -> 2
		if(y1<=frameY1&&num==1) {
			x1 = frameX2-h-space;
			y1 = frameY1+space;
			changewh();
			num=2;
		}
		//2 -> 3
		if(x1<=frameX1&&num==2) {
			x1 = 90;
			y1 = 90;
			changewh();
			num=3;
		}//3 -> 0
		if(y1>=380&&num==3) {
			x1 = 90;
			y1 = 440;
			changewh();
			num=0;
		}
		//0 -> 3
		if(x1<=80&&num==0) {
			x1 = 90;
			y1 = 370;
			changewh();
			num=3;
		}
		//3 -> 2
		if(y1<=80&&num==3) {
			x1 = 90;
			y1 = 90;
			changewh();
			num=2;
		}
		//2 -> 1
		if(x1>=380&&num==2) {
			x1 = 440;
			y1 = 90;
			changewh();
			num=1;
		}
		//1 -> 0
		if(y1>=380&&num==1) {
			x1 = 370;
			y1 = 440;
			changewh();
			num=0;
		}
	}
	public void changewh() {
		int tmp;
		tmp = w;
		w=h;
		h=tmp;
	}
	public void crashPoint() {
		
	}
}