package cn.tzs.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
	
	private GameUtil(){}  //������ͨ��˽�л����캯��
	/**
	 * ���ܣ���ȡͼ����Դ
	 * @param pathString
	 * @return
	 */
	public static Image getImage(String pathString){
		URL u = GameUtil.class.getClassLoader().getResource(pathString);
		//System.out.println(u);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}
