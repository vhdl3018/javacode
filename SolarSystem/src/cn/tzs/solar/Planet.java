package cn.tzs.solar;

import java.awt.Color;
import java.awt.Graphics;

import cn.tzs.util.GameUtil;

public class Planet extends Star{
	
	//����ͼƬ�����꣬��������ĳ����Բ���У����ᡢ���ᡢ�ٶȡ��Ƕ� ������

	double longAxis;		//��Բ����
	double shortAxis;		//��Բ����
	double speed;			//���������ٶ� 
	double degree;			//�Ƕ�
	Star center;			//���ǵ�����λ��
	
	
	public void draw(Graphics g) {
		//g.drawImage(img, (int)x, (int)y, null);
		super.draw(g);
		
		drawTrace(g);
		move();
	}
	/**
	 * �����������еĹ켣·��
	 * @param g
	 */
	public void drawTrace(Graphics g) {
		double _x,_y,_width,_height;
		
		//������
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
	 * ���� �� ʵ�����ǵ��˶�
	 */
	public void move() {
		//������Բ���� 
		x = center.x + center.width / 2 +longAxis*Math.cos(degree);
		y = center.y + center.height / 2 +shortAxis*Math.sin(degree);
		
		degree += speed;
	}
	
	
	/**
	 * ���ܣ��Զ�����̫��������
	 * @param imgPath
	 * @param longAxis
	 * @param shortAxis
	 * @param speed
	 * @param center
	 */
	public Planet(String imgPath, double longAxis, double shortAxis, double speed, Star center) {
		
		super(GameUtil.getImage(imgPath));
		this.center = center;					//���ǵ�����
		this.x = center.x + longAxis;   		//���ǵĳ�ʼλ��--x
		this.y = center.y;						//���ǵĳ�ʼλ��--y	
		 
		
		this.longAxis = longAxis;				//���ǵ��˶��켣����
		this.shortAxis = shortAxis;				//���ǵ��˶��켣����
		this.speed = speed;

	}	
	
	
	
	
	public Planet(){
		
	}

	public Planet(String imgPath, double x, double y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}


}
