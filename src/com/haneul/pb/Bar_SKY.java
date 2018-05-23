package com.haneul.pb;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;

import javax.swing.JPanel;

class Bar_SKY extends JPanel implements KeyListener{
	int center = 200;
	int r = 100;
	double x = r*Math.cos(Math.toRadians(90))+center;
	double y = r*Math.sin(Math.toRadians(90))+center;
	private int seta=90;
	private double rseta;
	private double coss,sins;
	int A = -60;
	int B = -60;
	
	
	public Bar_SKY() {
		addKeyListener(this);
		requestFocus();
		this.setFocusable(true);
		
	}
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		switch(keycode) {
		case KeyEvent.VK_LEFT:
			if(seta==360) seta=0;
			
			seta+=10;
			degree();
			move();
			repaint();
			
			break;
		case KeyEvent.VK_RIGHT:
			if(seta==0) seta=360;
			
			seta -=10;
			degree();
			move();
			repaint();
			
			break;
		}
	}
	public void degree() {
		A=30-seta;
	}
	public void move() {
		rseta = Math.toRadians(seta);
		coss = Math.cos(rseta);
		sins = Math.sin(rseta);
		
		x =center + r*coss;
		y =center + r*sins;
	}
	
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
	
		g2.draw(new Arc2D.Float((int)x,(int)y,200,200,A,B,Arc2D.CHORD));
	
		
	}
	
}