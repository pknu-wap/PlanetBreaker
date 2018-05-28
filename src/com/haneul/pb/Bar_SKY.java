package com.haneul.pb;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

class Bar_SKY extends JPanel implements KeyListener{
	//공간의 크기
	private int frameX1 = 80;
	private int frameY1 = 80;
	private int frameD = 400;
	private int frameX2 = frameX1 + frameD;
	private int frameY2 = frameY1 + frameD;
	private int space = 10;
	
	private int w = 100;			//바의 크기
	private int h = 20;				//바의 높이
	private int x1=frameX1+frameD/2;				//바의 x좌표
	private int y1=frameY2-h-space;				//바의 y좌표
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
	public void jump(int a) {
		switch(a) {
		case 0:
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
				x1 = frameX1+space;
				y1 = frameY1+space;
				changewh();
				num=3;
			}//3 -> 0
			if(y1>=frameY2-h&&num==3) {
				x1 = frameX1+space;
				y1 = frameY2-w-space;
				changewh();
				num=0;
			}
			break;
		case 1:
			//0 -> 3
			if(x1<=frameX1&&num==0) {
				x1 = frameX1+space;
				y1 = frameY2-w-space;
				changewh();
				num=3;
			}
			//3 -> 2
			if(y1<=frameY1&&num==3) {
				x1 = frameX1+space;
				y1 = frameY1+space;
				changewh();
				num=2;
			}
			//2 -> 1
			if(x1>=frameX2-w&&num==2) {
				x1 = frameX2-h-space;
				y1 = frameY1+space;
				changewh();
				num=1;
			}
			//1 -> 0
			if(y1>=frameY2-h&&num==1) {
				x1 = frameX2-h-space;
				y1 = frameY2-w-space;
				changewh();
				num=0;
			}
			break;
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
			jump(0);
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			move(1);
			jump(1);
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