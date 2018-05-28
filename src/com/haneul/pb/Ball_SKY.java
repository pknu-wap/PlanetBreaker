package com.haneul.pb;

import java.awt.*;
import javax.swing.*;


public class Ball_SKY  {
	int x=300;
	int y=300;
	int dx=0;
	int dy=1;
	int r;
	
	public void draw(Graphics g) {
		g.drawOval(x, y, r, r);
	}
	
	public void ballmove() {
			
		
	}
}
