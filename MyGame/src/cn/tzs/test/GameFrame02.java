package cn.tzs.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试物体的运动水平和垂直运行
 * @author qsqxj
 *
 */
public class GameFrame02 extends Frame{
private Image imgString = GameUtil.getImage("images/sun.jpg");
	
	private double x=100,y=100;
	
	private boolean left;
	
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
		g.drawImage(imgString, (int)x, (int)y, null);
		//x+=3;
		//控制物体运动的方向
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
		GameFrame02 gfFrame=new GameFrame02();
		gfFrame.launchFrame();
	}

}
