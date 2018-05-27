package com.jeongmin.pb;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Field_jeongmin extends JPanel {
	private int w, h;
	private BufferedImage image;
	Play_jeongmin play;

	Field_jeongmin(int wide, int high, Play_jeongmin play) { // Field ������
		this.play = play;
		w = wide;
		h = high; // ��, ����
		
		try {
			image = ImageIO.read(new File("space_background.png")); // �̹��� �б�
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0); // �����߻��� �޼��� ��� �� ����
		}
		
		setSize(w, h);
		setBackground(Color.white);
	}

	int getLeft() {
		return 0;
	}

	int getRight() {
		return w;
	}

	int getTop() {
		return 0;
	}

	int getBottom() {
		return h;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, null);
		
		play.ball.draw(g);
		for(int i = 0;i<20;i++)
			play.brick[i].draw(g);
	}
}
