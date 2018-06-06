package com.nap.pb;

import java.awt.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Ball {
   Field field;
   Play play;
   int x, y; // 공 좌표
   int radius;
   double vx, vy; // 공 속도
   double stop_v;
   double vx1,vy1;
   double vx2,vy2;
   double vd;
   int num;
   int cx ;
   int cy ;
   int x1,y1,w,h,d;
   //초기화를 위한 변수들
   int init_x;
   int init_y;
   double init_vx;
   double init_vy;
   double init_vx1;
   double init_vy1;
   double init_vx2;
   double init_vy2;

   Ball(Field field,Play play) { // 공 생성자
      // x = field.getRight() / 2;
      // y = field.getBottom() / 2;
      x = 382;
      y = 550;
      vx = 0;
      vy = 0;
      vx1 = 2;
      vy1 = 2;
      vx2 = Math.sqrt(3);
      vy2 = Math.sqrt(9);
      stop_v = 0;
      
      init_vx1 = vx1;
      init_vy1 = vy1;
      init_x = x;
      init_y = y;
      init_vx = 0;
      init_vy = 2;
      init_vx2 = vx2;
      init_vy2 = vy2;
      
      this.field = field;
      this.play = play;
   }
   

   public void sound(String name) {  //효과음
	   try
	   {
	   AudioInputStream ais = AudioSystem.getAudioInputStream(new File(name));
	  Clip clip = AudioSystem.getClip();
	  clip.stop();
	  clip.open(ais);
	  clip.start();
	   }
	   catch (Exception ex)
	   {
	    } 
   }

   void draw(Graphics g) { // 공 그리기
      int radius = 5;
      g.setColor(Color.white);
      g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
   }

   void move() {
      x = x + (int) vx;
      y = y + (int) vy;
      bounce();
   }

   void checkBounds() { // 벽에 부딪혔는지 체크
      if (y < field.getTop()) {
         vy = -vy;
         y = 2 * field.getTop() - y;
      }
      if (y + 2 * radius > field.getBottom()) {
         vy = -vy;
         y = 2 * field.getBottom() - y;
      }
      if (x < field.getLeft()) {
         vx = -vx;
         x = 2 * field.getLeft() - x;
      }
      if (x + 2 * radius > field.getRight()) {
         vx = -vx;
         x = 2 * field.getRight() - x;
      }
   }

   int getX() {
      return x;
   }

   int getY() {
      return y;
   }
   
   void bounce() {
      x1 = play.bar.getX1();
      y1 = play.bar.getY1();
      w = play.bar.getWidth();
      h = play.bar.getHeight();
      num = play.bar.getNum();
      cx = x-radius;
      cy = y-radius;
      int d = 112/4;
   
      
      switch(num) {
      case 0:
         if(cy>=y1&&cy<=y1+5) {
            if(x1<=cx&&cx<x1+d) {
               vx=-Math.abs(vx1);
               vy =-Math.abs(vy1);
               sound("bar.wav");
            }else if(x1+d<=cx&&cx<x1+d*2) {
               vx=-Math.abs(vx2);
               vy =-Math.abs(vy2);
               sound("bar.wav");
            }else if(x1+d*2<=cx&&cx<x1+d*3) {
               vx=Math.abs(vx2);
               vy =-Math.abs(vy2);
               sound("bar.wav");
            }else if(x1+d*3<=cx&&cx<x1+w) {
               vx=Math.abs(vx1);
               vy=-Math.abs(vy1);
               sound("bar.wav");
            }
         }
         break;
      case 1:
         if(cx>=x1&&cx<=x1+5) {
            if(y1<=cy&&cy<y1+d) {
               vx=-Math.abs(vx1);
               vy=-Math.abs(vy1);
               sound("bar.wav");
            }else if(y1+d<=cy&&cy<y1+d*2) {
               vx=-Math.abs(vy2);
               vy=-Math.abs(vx2);
               sound("bar.wav");
            }else if(y1+d*2<=cy&&cy<y1+d*3) {
               vx=-Math.abs(vy2);
               vy=Math.abs(vx2);
               sound("bar.wav");
            }else if(y1+d*3<=cy&&cy<y1+h) {
               vx=-Math.abs(vx1);
               vy=Math.abs(vy1);
               sound("bar.wav");
            }
         }
         break;
      case 2:
         if(cy<=y1+h&&cy>=y1+h-5) {
            if(x1<=cx&&cx<x1+d) {
               vx=-Math.abs(vx1);
               vy =Math.abs(vy1);
               sound("bar.wav");
            }else if(x1+d<=cx&&cx<x1+d*2) {
               vx=-Math.abs(vx2);
               vy =Math.abs(vy2);
               sound("bar.wav");
            }else if(x1+d*2<=cx&&cx<x1+d*3) {
               vx=Math.abs(vx2);
               vy =Math.abs(vy2);
               sound("bar.wav");
            }else if(x1+d*3<=cx&&cx<x1+w) {
               vx=Math.abs(vx1);
               vy=Math.abs(vy1);
               sound("bar.wav");
            }
         }
         break;
      case 3:
         if(cx<=x1+w&&cx>=x1+w-5) {
            if(y1<=cy&&cy<y1+d) {
               vx=Math.abs(vx1);
               vy=-Math.abs(vy1);
               sound("bar.wav");
            }else if(y1+d<=cy&&cy<y1+d*2) {
               vx=Math.abs(vy2);
               vy=-Math.abs(vx2);
               sound("bar.wav");
            }else if(y1+d*2<=cy&&cy<y1+d*3) {
               vx=Math.abs(vy2);
               vy=Math.abs(vx2);
               sound("bar.wav");
            }else if(y1+d*3<=cy&&cy<y1+h) {
               vx=Math.abs(vx1);
               vy=Math.abs(vy1);
               sound("bar.wav");
            }
         }
      }
   }
}