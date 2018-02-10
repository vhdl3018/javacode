package cn.tzs.test;

import java.awt.Graphics;
import java.awt.Image;


public class GameFrame05 extends MyFrame{

private Image imgString = GameUtil.getImage("images/sun.jpg");
	
	//定义小球的位置
	private double x=100,y=100;
	//定义小球运行的角度
	private double degree = 3.14/3;  //[0,2pi]
	//定义小球运行的速度
	private double speed = 10;
	
	

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
	

	
	
	public static void main(String[] args){
		GameFrame05 gfFrame=new GameFrame05();
		gfFrame.launchFrame();
	}
}
