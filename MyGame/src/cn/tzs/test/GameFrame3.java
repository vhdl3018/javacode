package cn.tzs.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ����������˶����ⷽ��
 * ���ʵ��̨������
 * @author qsqxj
 *
 */
public class GameFrame3 extends Frame{
private Image imgString = GameUtil.getImage("images/sun.jpg");
	
	//����С���λ��
	private double x=100,y=100;
	
	private double degree = 3.14/3;  //[0,2pi]
	
	private double speed = 10;
	
	
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
		
		//�ı�����������ٶ�
		if(speed > 0 ){
			speed -= 0.05;
		}else{
			speed = 0;
		}
		
		
		//x+=3;
		//���������˶��ķ���
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		//�ı�Ƕ�
		if(y>500-40){
			degree = -degree;
		}else if(y<40){
			degree = -degree;
		}
		
		
		if(x<0){
			degree = Math.PI - degree;
		}
		
		if(x>500-30){
			degree = Math.PI - degree;
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
		GameFrame3 gfFrame=new GameFrame3();
		gfFrame.launchFrame();
	}

}