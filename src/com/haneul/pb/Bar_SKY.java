package com.haneul.pb;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

class Bar_SKY extends JPanel implements KeyListener{
	String test;
	private int w = 100;			//바의 크기
	private int h = 30;				//바의 높이
	private int x1=230;				//바의 x좌표
	private int y1=440;				//바의 y좌표
	private int x2 = x1+w;			
	private int y2 = y1+h;
	private int dx=5;				//바의 속도
	int num=0;						//면의 번호
	private int cx,cy;				//충돌 좌표
	private int bx,by;				//공의 좌표
	
	
	public Bar_SKY() {
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(80,80,400,400);
		g.drawRect(x1, y1, w, h);
	}
	public void move(int a){
		System.out.println(x1+"  "+y1+" "+num);
		int tmp;

		switch(a) {
		case 0:
			if(x1>=80&&x1<380&&num==0) x1+=dx;
			if(y1>80&&y1<380&&num==1) y1-=dx;
			if(x1>=80&&x1<380&&num==2) x1-=dx;
			if(y1>80&&y1<380&&num==3) y1+=dx;
			break;
		case 1:
			if(x1>=80&&x1<380&&num==0) x1-=dx;
			if(y1>80&&y1<380&&num==1) y1+=dx;
			if(x1>=80&&x1<380&&num==2) x1+=dx;
			if(y1>80&&y1<380&&num==3) y1-=dx;
			break;
		}
	
	}
	public void jump() {
		//0 -> 1
		if(x1>=380&&num==0) {
			x1 = 440;
			y1 = 370;
			changewh();
			num=1;
		}
		//1 -> 2
		if(y1<=80&&num==1) {
			x1 = 370;
			y1 = 90;
			changewh();
			num=2;
		}
		//2 -> 3
		if(x1<=80&&num==2) {
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

	public void keyPressed(KeyEvent e) {
		int keycode =  e.getKeyCode();
		switch(keycode) {
		case KeyEvent.VK_RIGHT:
			move(0);
			jump();
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			move(1);
			jump();
			repaint();
			break;
		case KeyEvent.VK_SPACE:
			dx = 30;
			repaint();
			break;
			
		}
	}
	public void keyReleased(KeyEvent e) {
		int keycode =e.getKeyCode();
		if(keycode == KeyEvent.VK_SPACE)
			dx = 5;
	}
	public void keyTyped(KeyEvent arg0) {}
}