package com.nap.pb;

import java.awt.*;

public class Ball {
   Field field;
   Play play;
   int x, y; // 공 좌표
   int init_x = 265;
   int init_y = 500;
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

   Ball(Field field,Play play) { // 공 생성자
      // x = field.getRight() / 2;
      // y = field.getBottom() / 2;
      x = 382;
      y = 550;
      vx = 0;
      vy = Math.sqrt(8);
      vx1 = 2;
      vy1 = 2;
      vx2 = Math.sqrt(3);
      vy2 = Math.sqrt(9);
      stop_v = 0;
      this.field = field;
      this.play = play;
   }

   void draw(Graphics g) { // 공 그리기
      int radius = 5;
      g.setColor(Color.white);
      g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
   }

   void move() {
      x = x + (int) vx;
      y = y + (int) vy;
      checkBounds();
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
         if(cy>=y1) {
            if(x1<=cx&&cx<x1+d) {
               vx=-Math.abs(vx1);
               vy =-Math.abs(vy1);
            }else if(x1+d<=cx&&cx<x1+d*2) {
               vx=-Math.abs(vx2);
               vy =-Math.abs(vy2);
            }else if(x1+d*2<=cx&&cx<x1+d*3) {
               vx=Math.abs(vx2);
               vy =-Math.abs(vy2);
            }else if(x1+d*3<=cx&&cx<x1+w) {
               vx=Math.abs(vx1);
               vy=-Math.abs(vy1);
            }
         }
         break;
      case 1:
         if(cx>=x1) {
            if(y1<=cy&&cy<y1+d) {
               vx=-Math.abs(vx1);
               vy=-Math.abs(vy1);
            }else if(y1+d<=cy&&cy<y1+d*2) {
               vx=-Math.abs(vy2);
               vy=-Math.abs(vx2);
            }else if(y1+d*2<=cy&&cy<y1+d*3) {
               vx=-Math.abs(vy2);
               vy=Math.abs(vx2);
            }else if(y1+d*3<=cy&&cy<y1+h) {
               vx=-Math.abs(vx1);
               vy=Math.abs(vy1);
            }
         }
         break;
      case 2:
         if(cy<=y1+h) {
            if(x1<=cx&&cx<x1+d) {
               vx=-Math.abs(vx1);
               vy =Math.abs(vy1);
            }else if(x1+d<=cx&&cx<x1+d*2) {
               vx=-Math.abs(vx2);
               vy =Math.abs(vy2);
            }else if(x1+d*2<=cx&&cx<x1+d*3) {
               vx=Math.abs(vx2);
               vy =Math.abs(vy2);
            }else if(x1+d*3<=cx&&cx<x1+w) {
               vx=Math.abs(vx1);
               vy=Math.abs(vy1);
            }
         }
         break;
      case 3:
         if(cx<=x1+w) {
            if(y1<=cy&&cy<y1+d) {
               vx=Math.abs(vx1);
               vy=-Math.abs(vy1);
            }else if(y1+d<=cy&&cy<y1+d*2) {
               vx=Math.abs(vy2);
               vy=-Math.abs(vx2);
            }else if(y1+d*2<=cy&&cy<y1+d*3) {
               vx=Math.abs(vy2);
               vy=Math.abs(vx2);
            }else if(y1+d*3<=cy&&cy<y1+h) {
               vx=Math.abs(vx1);
               vy=Math.abs(vy1);
            }
         }
      }
   }
}