package cn.tzs.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.tzs.util.Constant;
import cn.tzs.util.GameUtil;
import cn.tzs.util.MyFrame;

@SuppressWarnings("serial")
public class SolarFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2);
	
	public void paint(Graphics g) {
		g.drawImage(bg,0,0,null);
		sun.draw(g);
	}
	
	
	public static void main(String[] args){
		new SolarFrame().launchFrame();
	}
}
