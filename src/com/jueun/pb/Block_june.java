package com.jueun.pb;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class Block {

      public int map[][]; //��
	  public int blockWidth; //������
      public int blockHeight; //�� ����
      
      public Block(int row,int col) {
    	  //�� ���°� ����
    	  map = new int[row][col];
    	  for(int i = 0; i < map.length; i++) {
    		  for(int j=0; j<map.length;j++) {
    		    map[i][j]=1;   // 0�� �Ǹ� �ȱ׷������� �ϱ�����
    		  }
    	  }
    	  //�� ũ�� ����
    	  blockWidth = 200/row;
    	  blockHeight = 50/col;
      }
      
      public void draw(Graphics2D g) {
    	  for(int i =0; i < map.length;i++) {
    		  for(int j =0; j < map.length; j++){
    			  if(map[i][j] > 0) {  //�� ���� 1�϶�
    				  //�� ����
    				  g.setColor(Color.ORANGE);
    				  g.fillRect(j*blockWidth+100,i*blockHeight+80,blockWidth,blockHeight);
    				  
    				  //��輱 ����
    				  g.setStroke(new BasicStroke(2)); //���м��� 2
    			      g.setColor(Color.WHITE); //�ʵ���� ��ġ��Ŵ
                      g.drawRect(j*blockWidth+100,i*blockHeight+80,blockWidth,blockHeight); //��輱�� �׸���
    			  }
    		  }
    	  }
    	  
      }
      public void setValue(int value, int row, int col) {
    	  //�����¸� �����ϴ� �޼ҵ�
    	  map[row][col]= value;
      }
    }