package com.jin.pb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlanetBreakerBg_Jin extends JFrame {
	Ball_jin ball;
	Brick_jin[] brick;
	Field_jin field;
	int breaked_brick_number;

	public static void main(String[] args) {
		PlanetBreakerBg_Jin pb = new PlanetBreakerBg_Jin();
	}
	private JPanel startPanel,gamePanel;
	private JButton sb,hb,eb;
	private BufferedImage gimg, timg, himg;
	private Image bg;
	private JLabel help;
	private JDialog h;
	
	
	public PlanetBreakerBg_Jin() {
		field = new Field_jin(500, 500, this);
		field.setLocation(50,50);
		field.setSize(100,100);
		ball = new Ball_jin(field);
		brick = new Brick_jin[20];
		breaked_brick_number = 0;
		
		brick[0] = new Brick_jin(field, ball, 40, 40);
		brick[1] = new Brick_jin(field, ball, 70, 40);
		brick[2] = new Brick_jin(field, ball, 100, 40);
		brick[3] = new Brick_jin(field, ball, 130, 40);
		brick[4] = new Brick_jin(field, ball, 160, 40);
		brick[5] = new Brick_jin(field, ball, 40, 70);
		brick[6] = new Brick_jin(field, ball, 70, 70);
		brick[7] = new Brick_jin(field, ball, 100, 70);
		brick[8] = new Brick_jin(field, ball, 130, 70);
		brick[9] = new Brick_jin(field, ball, 160, 70);
		brick[10] = new Brick_jin(field, ball, 40, 100);
		brick[11] = new Brick_jin(field, ball, 70, 100);
		brick[12] = new Brick_jin(field, ball, 100, 100);
		brick[13] = new Brick_jin(field, ball, 130, 100);
		brick[14] = new Brick_jin(field, ball, 160, 100);
		brick[15] = new Brick_jin(field, ball, 40, 130);
		brick[16] = new Brick_jin(field, ball, 70, 130);
		brick[17] = new Brick_jin(field, ball, 100, 130);
		brick[18] = new Brick_jin(field, ball, 130, 130);
		brick[19] = new Brick_jin(field, ball, 160, 130);
		
		setTitle("PlanetBreaker");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			gimg = ImageIO.read(new File("space_background.png")); // �̹��� �б�
			timg = ImageIO.read(new File("title.jpg"));
			himg = ImageIO.read(new File("조작키.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0); // �����߻��� �޼��� ��� �� ����
		}

		ButtonListener listener = new ButtonListener();
		startPanel = new SPanel();
		startPanel.setSize(600, 600);
		startPanel.setVisible(true);
		startPanel.setLayout(null);
		sb = new JButton();
		sb.setBounds(240, 400, 120, 30);
		ImageIcon si = new ImageIcon("start버튼.png");
		si.setImage(si.getImage().getScaledInstance(130, 30, Image.SCALE_SMOOTH));
		sb.setIcon(si);
		sb.addActionListener(listener);
		startPanel.add(sb);
		hb = new JButton();
		hb.setBounds(240, 450, 120, 30);
		ImageIcon hi = new ImageIcon("help버튼.png");
		hi.setImage(hi.getImage().getScaledInstance(130, 30, Image.SCALE_SMOOTH));
		hb.setIcon(hi);
		hb.addActionListener(listener);
		startPanel.add(hb);
		eb = new JButton();
		eb.setBounds(240, 500, 120, 30);
		ImageIcon ei = new ImageIcon("exit버튼.png");
		ei.setImage(ei.getImage().getScaledInstance(130, 30, Image.SCALE_SMOOTH));
		eb.setIcon(ei);
		eb.addActionListener(listener);
		startPanel.add(eb);
	
		JDialog.setDefaultLookAndFeelDecorated(true);
		h=new JDialog(this,"Help",true);
        h.setSize(400,400);
        h.setVisible(false);
		
		help = new JLabel();	
		ImageIcon t = new ImageIcon("조작키.png");
		t.setImage(t.getImage().getScaledInstance(390, 380, Image.SCALE_SMOOTH));
		help.setIcon(t);		//집게역할의 label을 만들고 그 위에 집게이미지를 삽입
		help.setSize(390, 380);//집게의 크기와 위치설정
		
        
		
		add(startPanel);
		gamePanel = new GPanel();
		gamePanel.add(field);
		gamePanel.setSize(600, 600);
		gamePanel.setBackground(Color.GRAY);
		gamePanel.setVisible(false);
		
		add(gamePanel);
		
		setVisible(true);
		setResizable(false);
	}

	class SPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(timg, 0, 0, 600, 600, null);
		}
	}

	class GPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			BufferedImage bf=new BufferedImage(600,600,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = bf.createGraphics();
			Rectangle2D rect = new Rectangle2D.Double(50, 50, 500, 500);
			g2d.setPaint(new TexturePaint(gimg, rect));
			Ellipse2D oval = new Ellipse2D.Double(50, 50, 500, 500);
			g2d.fill(oval);
			
		}
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == sb) { // 1����ư�� ������ ����
				startPanel.setVisible(false);
				gamePanel.setVisible(true);
				field.setVisible(true);
				requestFocus();
				setFocusable(true);
			} // ������ �ٽ� ����
			else if (e.getSource() == hb) {
				JDialog.setDefaultLookAndFeelDecorated(true);
				h=new JDialog(); 
				h.setVisible(true);
				h.setSize(400, 400);
		        h.setOpacity(1.0f);
		        h.setAlwaysOnTop(true);
		        h.setLocation(150, 100);
		        h.setBackground(new Color(0,255,255,50));
		        h.add(help);
			}
			else if (e.getSource() == eb) { // 2����ư�� ������ ����
				System.exit(0);
			} // ������ ����
		}
	}
	void start() {
		breaking();
	}

	void breaking() {
		while (true) {
			ball.move();
			field.repaint(); // paint ȣ��
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}
}

/*public class PlanetBreakerBg_Jin {
	Ball_jin ball;
	Brick_jin[] brick;
	Field_jin field;
	int breaked_brick_number;

	public static void main(String[] args) {
		BackGround b = new BackGround();
	}

}*/
