package com.haneul.pb;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Main extends JFrame{
	Bar bar = new Bar();
	
	public Main() {
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Planet Breaker");
		
		add(bar);
		
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Main();
		
	}

}



