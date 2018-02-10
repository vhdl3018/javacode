package cn.tzs.solar;

import java.awt.Color;
import java.awt.Graphics;

import cn.tzs.util.GameUtil;

public class Planet extends Star{
	
	//除了图片，坐标，行星沿着某个椭圆运行：长轴、短轴、速度、角度 ，中心

	double longAxis;		//椭圆长轴
	double shortAxis;		//椭圆短轴
	double speed;			//行星运行速度 
	double degree;			//角度
	Star center;			//卫星的中心位置
	
	
	public void draw(Graphics g) {
		//g.drawImage(img, (int)x, (int)y, null);
		super.draw(g);
		
		drawTrace(g);
		move();
	}
	/**
	 * 画出行星运行的轨迹路线
	 * @param g
	 */
	public void drawTrace(Graphics g) {
		double _x,_y,_width,_height;
		
		//计算宽度
		_width = longAxis * 2;
		_height = shortAxis *2;
		_x = center.x + center.width/2 - longAxis;
		_y = center.y + center.height/2 - shortAxis;
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)_x, (int)_y, (int)_width, (int)_height);
		g.setColor(c);
	}
	/**
	 * 功能 ： 实现行星的运动
	 */
	public void move() {
		//沿着椭圆飞行 
		x = center.x + center.width / 2 +longAxis*Math.cos(degree);
		y = center.y + center.height / 2 +shortAxis*Math.sin(degree);
		
		degree += speed;
	}
	
	
	/**
	 * 功能：自动处理太阳的卫星
	 * @param imgPath
	 * @param longAxis
	 * @param shortAxis
	 * @param speed
	 * @param center
	 */
	public Planet(String imgPath, double longAxis, double shortAxis, double speed, Star center) {
		
		super(GameUtil.getImage(imgPath));
		this.center = center;					//行星的中心
		this.x = center.x + longAxis;   		//行星的初始位置--x
		this.y = center.y;						//行星的初始位置--y	
		 
		
		this.longAxis = longAxis;				//行星的运动轨迹长轴
		this.shortAxis = shortAxis;				//行星的运动轨迹短轴
		this.speed = speed;

	}	
	
	
	
	
	public Planet(){
		
	}

	public Planet(String imgPath, double x, double y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}


}
