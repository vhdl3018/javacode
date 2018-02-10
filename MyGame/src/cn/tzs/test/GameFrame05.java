package cn.tzs.test;

import java.awt.Graphics;
import java.awt.Image;


public class GameFrame05 extends MyFrame{

private Image imgString = GameUtil.getImage("images/sun.jpg");
	
	//����С���λ��
	private double x=100,y=100;
	//����С�����еĽǶ�
	private double degree = 3.14/3;  //[0,2pi]
	//����С�����е��ٶ�
	private double speed = 10;
	
	

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
	

	
	
	public static void main(String[] args){
		GameFrame05 gfFrame=new GameFrame05();
		gfFrame.launchFrame();
	}
}
