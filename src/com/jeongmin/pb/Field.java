package com.jeongmin.pb;

import java.awt.*;
import javax.swing.*;

public class Field extends JPanel{
	private int x0,x1,y0,y1,w,h;
	Ball b;
	Field(int wide, int high){	//Field 생성자
		w = wide; h = high;		//폭, 높이
		setSize(w,h);
		setBackground(Color.white);
		x1 = w/2; x0 = -x1; 
		y1 = h/2; y0 = -y1;
		b = new Ball(this);
	}
	
	int getLeft(){return x0;} int getRight(){return x1;}
	int getTop(){return y0;} int getBottom(){return y1;}
	int getCx() {return x1;} int getCy() {return y1;}
	public void paint(Graphics g) {
		super.paint(g);
		b.draw(g);
		b.move();
	}
}
