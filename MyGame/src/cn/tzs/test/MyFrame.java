package cn.tzs.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{

	/**
	 * ���ܣ���ʼ������
	 */
	public void launchFrame(){
		//���ò���ʾ����
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		this.setTitle("�ɻ���Ϸ");
		this.setLocation(400, 400);
		this.setVisible(true);
		
		//�����߳�
		new PaintThread().start();
		
		/**
		 * �رմ���
		 */
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	/**
	 * ����һ���ػ��߳��࣬��һ���ڲ��ࡣ
	 * @author qsqxj
	 *
	 */
	class PaintThread extends Thread {
		public void run(){
			while (true) {				
				repaint();
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}