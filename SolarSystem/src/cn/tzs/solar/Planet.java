package cn.tzs.solar;

import cn.tzs.util.GameUtil;

public class Planet extends Star{
	
	//除了图片，坐标，行星沿着某个椭圆运行：长轴、短轴、速度，中心

	double longAxis;
	double shortAxis;
	double speed;
	Star center;
	
	
	
	public Planet(String imgPath, double longAxis, double shortAxis, double speed, Star center) {
		
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		this.img = GameUtil.getImage(imgPath);
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;

	}	
	
	
	
	
	public Planet(){
		
	}

	public Planet(String imgPath, double x, double y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}


}
