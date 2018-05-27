package com.jueun.pb;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class Block {

      public int map[][]; //블럭
	  public int blockWidth; //블럭가로
      public int blockHeight; //블럭 세로
      
      public Block(int row,int col) {
    	  //블럭 상태값 설정
    	  map = new int[row][col];
    	  for(int i = 0; i < map.length; i++) {
    		  for(int j=0; j<map.length;j++) {
    		    map[i][j]=1;   // 0이 되면 안그려지도록 하기위해
    		  }
    	  }
    	  //블럭 크기 설정
    	  blockWidth = 200/row;
    	  blockHeight = 50/col;
      }
      
      public void draw(Graphics2D g) {
    	  for(int i =0; i < map.length;i++) {
    		  for(int j =0; j < map.length; j++){
    			  if(map[i][j] > 0) {  //블럭 상태 1일때
    				  //블럭 생성
    				  g.setColor(Color.ORANGE);
    				  g.fillRect(j*blockWidth+100,i*blockHeight+80,blockWidth,blockHeight);
    				  
    				  //경계선 생성
    				  g.setStroke(new BasicStroke(2)); //구분선폭 2
    			      g.setColor(Color.WHITE); //필드색과 일치시킴
                      g.drawRect(j*blockWidth+100,i*blockHeight+80,blockWidth,blockHeight); //경계선을 그린다
    			  }
    		  }
    	  }
    	  
      }
      public void setValue(int value, int row, int col) {
    	  //블럭상태를 설정하는 메소드
    	  map[row][col]= value;
      }
    }