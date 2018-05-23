package com.jueun.pb;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Field extends JPanel implements ActionListener {
	
	private int totalBlock = 9; //총 블럭 수
	private Block block; 
	private int w,h;
	Ball b;
	
	Field(int wide, int high){	
		w = wide; h = high;		//폭, 높이
		setSize(w,h);
		setBackground(Color.white);
		b = new Ball(this);
		block = new Block(3,3);
	}
	
	
	int getLeft(){return 0;} 
	int getRight(){return w;}
	int getTop(){return 0;}
	int getBottom(){return h;}
	
	public void paint(Graphics g) {
		super.paint(g);
		b.draw(g);
		b.move();
		block.draw((Graphics2D)g);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		A: for(int i =0; i <block.map.length;i++) {
			for(int j=0;j<block.map[0].length;j++) {
				if(block.map[i][j] > 0) {
					int blockX = j*block.blockWidth + 100;
					int blockY = i*block.blockHeight + 80;
					int blockWidth = block.blockWidth;
					int blockHeight = block.blockHeight;
					
					Rectangle rect = new Rectangle(blockX, blockY, blockWidth,blockHeight);
					Rectangle ballRect = new Rectangle(b.x,b.y,10,10);
					Rectangle blockRect =rect;
				
					//충돌시 공은 계속 움직임
					if(ballRect.intersects(blockRect)) {
						block.setValue(0, i, j);
						totalBlock--;
						
		           if(b.x <= blockRect.x || b.x >= blockRect.x + blockRect.width) {
							b.vx = -b.vx;
			         		}else {
			         			b.vy = -b.vy;
					}
					break A;
				}
			}
		}
	}

	
	}
}

