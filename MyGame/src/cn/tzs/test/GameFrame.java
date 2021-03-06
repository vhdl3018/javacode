package cn.tzs.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏窗口类
 * @author qsqxj
 *
 */
public class GameFrame extends Frame{  //GUI编程：AWT，Swing等
	
	private Image imgString = GameUtil.getImage("images/sun.jpg");
	
	private double x=100,y=100;
	
	/**
	 * 功能：初始化窗口
	 */
	public void launchFrame(){
		//设置并显示窗口
		this.setSize(500,500);
		this.setTitle("飞机游戏");
		this.setLocation(400, 400);
		this.setVisible(true);
		
		//启动线程
		new PaintThread().start();
		
		/**
		 * 关闭窗口
		 */
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	/**
	 * 功能：在窗口中画图片
	 */
	public void paint(Graphics g){
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		g.drawString("我是杨哥", 200, 200);

		g.drawImage(imgString, (int)x, (int)y, null);
		//x+=3;
		y+=3;
	}
	
	/**
	 * 定义一个重画线程类，是一个内部类。
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
		GameFrame gfFrame=new GameFrame();
		gfFrame.launchFrame();
	}

}
