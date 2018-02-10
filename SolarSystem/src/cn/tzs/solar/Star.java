package cn.tzs.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.tzs.util.GameUtil;

public class Star {
	Image img;
	
	double x,y;
	
	public void draw(Graphics g){
		g.drawImage(img, (int)x,(int)y, null);
	}
	public Star(){
		
	}
	public Star(String imgPath, double x, double y ){
		this.img = GameUtil.getImage(imgPath);
		this.x = x;
		this.y = y;
	}
}
