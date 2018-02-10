package cn.tzs.solar;

import cn.tzs.util.GameUtil;

public class Planet extends Star{
	
	//����ͼƬ�����꣬��������ĳ����Բ���У����ᡢ���ᡢ�ٶȣ�����

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
