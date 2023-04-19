package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

		public int worldX, worldY;
		public int x,y;
		public int speed;
		public BufferedImage up1,up2,up3,up4,up5,up6,up7,up8,up9,up10,
		down1,down2,
		left1,left2,
		right1,right2;
		
		
		public String direction;
		public int spriteCounter = 0;
		public int spriteNum = 1;
		
		public Rectangle solidArea;
		public int solidAreaDefaultX, solidAreaDefaultY;
		
		public boolean collisionOn = false;
		
}
