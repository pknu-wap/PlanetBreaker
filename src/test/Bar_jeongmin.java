package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Bar_jeongmin {
/*	private int frameX1 = 20;
	private int frameY1 = 15;
	private int frameD = 550;
	private int frameX2 = frameX1 + frameD;
	private int frameY2 = frameY1 + frameD;
	private int space = 10;

	int w = 100; // 바의 크기
	int h = 20; // 바의 높이
	int x1 = frameX1 + frameD / 2 - w / 2; // 바의 x좌표
	int y1 = frameY2 - space - h; // 바의 y좌표
	int dx = 10; // 바의 속도
	int num = 0; // 면의 번호
	private int d;*/
	private BufferedImage ship0,ship1,ship2,ship3;
	
	private int frameX1 = 10;
	private int frameY1 = 10;
	private int frameD = 750;
	private int frameX2 = frameX1 + frameD;
	private int frameY2 = frameY1 + frameD;
	private int space = 15;
	
	private int w = 113;			//바의 크기
	private int h = 43;				//바의 높이
	private int x1=frameX1+frameD/2-w/2;				//바의 x좌표
	private int y1=frameY2-space-h;				//바의 y좌표
	private int dx=20;				//바의 속도
	private int num=0;				//면의 번호
	private int d;
	BufferedImage tmp;
	
	Field_jeongmin field;
	
	public Bar_jeongmin(Field_jeongmin field) {
		this.field = field;
		try {
			ship0 = ImageIO.read(new File("Ship0.png")); //비행기 이미지
			ship1 = ImageIO.read(new File("Ship1.png"));
			ship2 = ImageIO.read(new File("Ship2.png"));
			ship3 = ImageIO.read(new File("Ship3.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void draw(Graphics g) {
		// super.paintComponent(g);
		g.setColor(Color.red);
		g.drawRect(frameX1, frameY1, frameD, frameD);
		
		switch(num) {
		case 0:
			g.drawImage(ship0,x1,y1,null );
			break;
		case 1:
			g.drawImage(ship1,x1,y1,null );
			break;
		case 2:
			g.drawImage(ship2,x1,y1,null );
			break;
		case 3:
			g.drawImage(ship3,x1,y1,null );
			break;
		}
		
		
	}

	public void move(int a) {
		System.out.println(x1 + "  " + y1 + " " + num);

		switch(a) {
		case 0:case 2:
			if(num==0||num==2)	{
				x1 += dx;
				if (x1 >= frameX2 - w && num == 0) {
					x1 = frameX2 - h - space;
					y1 = frameY2 - w - space;
					changewh();
					num = 1;
				}//0 -> 1
				if (x1 >= frameX2 - w && num == 2) {
					x1 = frameX2 - h - space;
					y1 = frameY1 + space;
					changewh();
					num = 1;
				}// 2 -> 1
			}
			break;
		case 1:case 3:
			if(num==1||num==3)	{
				y1 -= dx;
				if (y1 <= frameY1 && num == 1) {
					x1 = frameX2 - h - space;
					y1 = frameY1 + space;
					changewh();
					num = 2;
				}// 1 -> 2
				if (y1 <= frameY1 && num == 3) {
					x1 = frameX1 + space;
					y1 = frameY1 + space;
					changewh();
					num = 2;
				}// 3 -> 2
				
			}
			break;
		case 0+4:case 2+4:
			if(num==0||num==2)	{
				x1 -= dx;
				if (x1 <= frameX1 && num == 2) {
					x1 = frameX1 + space;
					y1 = frameY1 + space;
					changewh();
					num = 3;
				} // 2 -> 3
				if (x1 <= frameX1 && num == 0) {
					x1 = frameX1 + space;
					y1 = frameY2 - w - space;
					changewh();
					num = 3;
				}// 0 -> 3
			}
			break;
		case 1+4:case 3+4:
			if(num==1||num==3)	{
				y1 += dx;
				if (y1 >= frameY2 - h && num == 3) {
					x1 = frameX1 + space;
					y1 = frameY2 - w - space;
					changewh();
					num = 0;
				}//3 -> 0
				if (y1 >= frameY2 - h && num == 1) {
					x1 = frameX2 - h - space;
					y1 = frameY2 - w - space;
					changewh();
					num = 0;
				}// 1 -> 0
			}
			break;
		}
	}
	public void teleport() {
		switch (num) {
		case 0:
			num = 2;
			y1 = frameY1 + space;
			break;
		case 1:
			num = 3;
			x1 = frameX1 + space;
			break;
		case 2:
			num = 0;
			y1 = frameY2 - space - h;
			break;
		case 3:
			num = 1;
			x1 = frameX2 - space - w;
			break;
		}
	}
	public void changeImage() {
		
		tmp = ship2;
		ship2 = ship3;
	}
	public void resetImage() {
		ship2 = tmp;
	}
	public void changewh() {
		int tmp;
		tmp = w;
		w = h;
		h = tmp;
	}
	
	int getX1() {
		return x1;
	}
	int getY1() {
		return y1;
	}
	int getWidth() {
		return w;
	}
	int getHeight() {
		return h;
	}
	int getNum() {
		return num;
	}
	int getD(int num) {
		if(num == 0||num==2)
			d = w/4;
		else if(num == 1||num == 3)
			d = h/4;
		return d;
	}
	void setDx(int dx) {
		this.dx = dx;
	}
}