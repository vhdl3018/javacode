package cn.tzs.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.tzs.util.GameUtil;

public class Star {
	Image img;
	
	double x,y;
	int width,height;
	
	public void draw(Graphics g){
		g.drawImage(img, (int)x,(int)y, null);
	}
	public Star(){
		
	}
	/**
	 * 
	 * @param img
	 */
	public Star(Image img) {
		this.img = img;			
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	/**
	 * 
	 * @param img
	 * @param x
	 * @param y
	 */
	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @param imgPath
	 * @param x
	 * @param y
	 */
	public Star(String imgPath, double x, double y ){
		this(GameUtil.getImage(imgPath), x, y);

	}
}
