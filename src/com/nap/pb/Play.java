package com.nap.pb;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;


import javax.imageio.ImageIO;
import javax.swing.*;


public class Play extends JFrame {
   Ball ball;
   Brick[] brick;
   Field field;
   Bar bar;
   int breaked_brick_number;
   private BufferedImage image,title;
   JPanel startPanel;
   JPanel gamePanel = new JPanel(null);
   JButton sb,eb;
   
   class SPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(title, 0, 0, 800, 800, null);
		}
	}
   public static void main(String[] args) {
      new Play();
   }

   Play() {
      try {
         title = ImageIO.read(new File("title.jpg"));
      } catch (IOException e) {
         System.out.println(e.getMessage());
         System.exit(0); 
      }
      field = new Field(800, 800, this);
      ball = new Ball(field,this);
      bar = new Bar(field);
      makeBricks();
      
      ButtonListener listener = new ButtonListener();
      startPanel = new SPanel();
      startPanel.setSize(785, 805);
      startPanel.setVisible(true);
      startPanel.setLayout(null);
      sb = new JButton("Game Start");
      sb.setBounds(330, 530, 120, 30);
      sb.addActionListener(listener);
      startPanel.add(sb);
      eb = new JButton("Exit");
      eb.setBounds(330, 600, 120, 30);
      eb.addActionListener(listener);
      startPanel.add(eb);
      add(startPanel);
      
      gamePanel.add(field);
      gamePanel.setVisible(false);
      field.setLocation(0, 0);
      
      
      add(gamePanel);
      
      setSize(785, 805);
      setVisible(true);
      setResizable(false);
      start();
      setTitle("Planet Breaker");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   void start() {
      breaking();
   }

   void breaking() {
      while (true) {
         if(breaked_brick_number==0)
            nextLevel();
         ball.move();
         field.repaint();
         try {
            Thread.sleep(10);
         } catch (Exception e) {
         }
      }
   }
   
   void nextLevel() {
      for(int i = 0;i<76;i++) {
         brick[i].basic_armor++;
         brick[i].armor = brick[i].basic_armor;
         brick[i].x = brick[i].basic_x;
         brick[i].y = brick[i].basic_y;
      }
      ball.x = ball.init_x;
      ball.y = ball.init_y;
      breaked_brick_number = 75;
   }
   private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == sb) { // 1����ư�� ������ ����
				startPanel.setVisible(false);
				gamePanel.setVisible(true);
				field.setVisible(true);
				field.requestFocus();
				setFocusable(true);
				
			} // ������ �ٽ� ����
			else if (e.getSource() == eb) { // 2����ư�� ������ ����
				System.exit(0);
			} // ������ ����
		}
	}
   void makeBricks() {
      int bx = 260;
      int D = 25;
      
      brick = new Brick[76];
      breaked_brick_number = 75;
      for (int i = 0; i < 4; i++)
         brick[i] = new Brick(field, ball, bx + D * i + 75, bx, 1);
      for (int i = 4; i < 10; i++) {
         brick[i] = new Brick(field, ball, bx + D * (i - 4) + 50, bx + D, 2);
         if (i == 4 || i == 9)
            brick[i].armor = 1;
      }
      for (int i = 10; i < 18; i++) {
         brick[i] = new Brick(field, ball, bx + D * (i - 10) + 25, bx + D * 2, 2);
         if (i == 10 || i == 17)
            brick[i].armor = 1;
         else if (i == 13 || i == 14)
            brick[i].armor = 3;
      }
      for (int i = 18; i < 28; i++) {
         brick[i] = new Brick(field, ball, bx +  D * (i - 18), bx + D * 3, 2);
         if (i == 18 || i == 27)
            brick[i].armor = 1;
         else if (i >= 21 && i <= 24)
            brick[i].armor = 3;
      }
      for (int i = 28; i < 38; i++) {
         brick[i] = new Brick(field, ball, bx + D * (i - 28), bx + D * 4, 3);
         if (i == 28 || i == 37)
            brick[i].armor = 1;
         else if (i == 29 || i == 36)
            brick[i].armor = 2;
         else if (i == 32 || i == 33)
            brick[i].armor = 4;
      }
      for (int i = 38; i < 48; i++) {
         brick[i] = new Brick(field, ball, bx + D * (i - 38), bx + D * 5, 3);
         if (i == 38 || i == 47)
            brick[i].armor = 1;
         else if (i == 39 || i == 46)
            brick[i].armor = 2;
         else if (i == 42 || i == 43)
            brick[i].armor = 4;
      }
      for (int i = 48; i < 58; i++) {
         brick[i] = new Brick(field, ball,   bx + D * (i - 48), bx + D * 6, 2);
         if (i == 48 || i == 57)
            brick[i].armor = 1;
         else if (i >= 51 && i <= 54)
            brick[i].armor = 3;
      }
      for (int i = 58; i < 66; i++) {
         brick[i] = new Brick(field, ball, bx + D * (i - 58) + 25, bx + D * 7, 2);
         if (i == 58 || i == 65)
            brick[i].armor = 1;
         else if (i == 61 || i == 62)
            brick[i].armor = 3;
      }
      for (int i = 66; i < 72; i++) {
         brick[i] = new Brick(field, ball, bx + D * (i - 66) + 50, bx + D * 8, 2);
         if (i == 66 || i == 71)
            brick[i].armor = 1;
      }
      for (int i = 72; i < 76; i++)
         brick[i] = new Brick(field, ball, bx + D * (i - 72) + 75, bx + D * 9, 1);
   }
}