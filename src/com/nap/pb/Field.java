package com.nap.pb;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Field extends JPanel implements KeyListener {
   private int w, h;
   private BufferedImage image;
   Play play;
   Bar bar;
   Ball ball;

   Field(int wide, int high, Play play) { // Field 생성자
      addKeyListener(this);
      setFocusable(true);
      requestFocus();

      this.play = play;
      w = wide;
      h = high;

      try {
         image = ImageIO.read(new File("space_background.png"));
      } catch (IOException e) {
         System.out.println(e.getMessage());
         System.exit(0);
      }

      setSize(w, h);
      // setBackground(Color.white);
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

   public void keyPressed(KeyEvent e) {
      int keycode = e.getKeyCode();
      switch (keycode) {
      case KeyEvent.VK_RIGHT:
    	 play.bar.move("+");
         // repaint();
         break;
      case KeyEvent.VK_LEFT:
    	 play.bar.move("-");
         break;
      case KeyEvent.VK_SPACE:
         play.bar.setDx(50);
         break;
      case KeyEvent.VK_ENTER:
         play.ball.vx = -1;
         play.ball.vy = -2;
         break;
      case KeyEvent.VK_CONTROL:
         play.bar.teleport();
         break;
      }
   }

   public void keyReleased(KeyEvent e) {
      int keycode = e.getKeyCode();
      if (keycode == KeyEvent.VK_SPACE)
         play.bar.setDx(20);
   }

   public void keyTyped(KeyEvent arg0) {
   }

   public void paint(Graphics g) {
      super.paint(g);
      g.drawImage(image, 0, 0, null);

      play.ball.draw(g);
      play.bar.draw(g);
      for (int i = 0; i < 76; i++)
         play.brick[i].draw(g);
   }
}