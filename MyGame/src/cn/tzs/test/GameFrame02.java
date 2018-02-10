package cn.tzs.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ����������˶�ˮƽ�ʹ�ֱ����
 * @author qsqxj
 *
 */
public class GameFrame02 extends Frame{
private Image imgString = GameUtil.getImage("images/sun.jpg");
	
	private double x=100,y=100;
	
	private boolean left;
	
	/**
	 * ���ܣ���ʼ������
	 */
	public void launchFrame(){
		//���ò���ʾ����
		this.setSize(500,500);
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
	 * ���ܣ��ڴ����л�ͼƬ
	 */
	public void paint(Graphics g){
		g.drawImage(imgString, (int)x, (int)y, null);
		//x+=3;
		//���������˶��ķ���
		if(left){
			x-=3;
		}else{
			x+=3;
		}
		
		if(x > 500-30){
			left = true;
		}else if(x<0){
			left =false;
		}
		
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
	
	
	public static void main(String[] args){
		GameFrame02 gfFrame=new GameFrame02();
		gfFrame.launchFrame();
	}

}