package com.jin.pb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jin.pb.BackGround.GPanel;


class BackGround extends JFrame {
	private JPanel startPanel,gamePanel;
	private JButton sb, eb;
	private BufferedImage gimg, timg;
	

	public BackGround() {
		setTitle("PlanetBreaker");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			gimg = ImageIO.read(new File("bg.jpg")); // 이미지 읽기
			timg = ImageIO.read(new File("title.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0); // 오류발생시 메세지 출력 및 종료
		}

		ButtonListener listener = new ButtonListener();
		startPanel = new SPanel();
		startPanel.setSize(600, 600);
		startPanel.setVisible(true);
		startPanel.setLayout(null);
		sb = new JButton("Game Start");
		sb.setBounds(240, 400, 120, 30);
		sb.addActionListener(listener);
		startPanel.add(sb);
		eb = new JButton("Exit");
		eb.setBounds(240, 450, 120, 30);
		eb.addActionListener(listener);
		startPanel.add(eb);
		add(startPanel, BorderLayout.CENTER);
		
		gamePanel = new GPanel();
		gamePanel.setSize(600, 600);
		gamePanel.setBackground(Color.GRAY);
		gamePanel.setVisible(false);
		add(gamePanel, BorderLayout.CENTER);
		
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
			Graphics2D g2d = (Graphics2D) g;
			Rectangle2D rect = new Rectangle2D.Double(50, 50, 500, 500);
			g2d.setPaint(new TexturePaint(gimg, rect));
			Ellipse2D oval = new Ellipse2D.Double(50, 50, 500, 500);
			g2d.fill(oval);
		}
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == sb) { // 1번버튼을 누르면 실행
				startPanel.setVisible(false);
				gamePanel.setVisible(true);
			} // 게임을 다시 실행
			else if (e.getSource() == eb) { // 2번버튼을 누르면 실행
				System.exit(0);
			} // 게임을 종료
		}
	}
}

public class PlanetBreakerBg_Jin {

	public static void main(String[] args) {
		BackGround b = new BackGround();
	}

}
