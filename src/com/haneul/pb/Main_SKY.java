package com.haneul.pb;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Main_SKY extends JFrame{
	
	Bar_SKY bar = new Bar_SKY();
	public Main_SKY() {
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Planet Breaker");
		setResizable(false);
		
		add(bar);
		
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Main_SKY();
		
	}

}



