package cn.tzs.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试物体的运动任意方向
 * 最后：实现台球运行
 * @author qsqxj
 *
 */
public class GameFrame3 extends Frame{
private Image imgString = GameUtil.getImage("images/sun.jpg");
	
	//定义小球的位置
	private double x=100,y=100;
	
	private double degree = 3.14/3;  //[0,2pi]
	
	private double speed = 10;
	
	
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
		
		//改变物体的运行速度
		if(speed > 0 ){
			speed -= 0.05;
		}else{
			speed = 0;
		}
		
		
		//x+=3;
		//控制物体运动的方向
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		//改变角度
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
		GameFrame3 gfFrame=new GameFrame3();
		gfFrame.launchFrame();
	}

}
