package com.nap.pb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player; // player�� ���ι��� ���̺귯������ ��������
	private boolean isLoop; // ���� ���� �ݺ� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop; // isLoop�ʱ�ȭ
			file = new File(name); // 파일 지정해줄거임
			fis = new FileInputStream(file); // 파일을 바이트로 입력받아 출력
			bis = new BufferedInputStream(fis); // 저장
			player = new Player(bis); //

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); // �ش� �����带 �������·� ����
	}

	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop); // isLoop�� true�� ���ѹݺ�
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
