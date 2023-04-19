package entity;

import main.*;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import main.GamePanel;
import main.KeyHandler;




public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	Sound sound = new Sound();
	
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	public int AlertCalled = 0;
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
		
	}
	
	public void setDefaultValues() {
		worldX = 12*gp.tileSize;
		worldY = 15*gp.tileSize;
		speed = 7;
		direction = "down";
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			/*up3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_4.png"));
			up5 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_5.png"));
			up6 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_6.png"));
			up7 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_7.png"));
			up8 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_8.png"));
			up9 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_9.png"));
			up10 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_10.png"));*/
			
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	
	
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true) {
			
			
		
		
		
		
		
		if(keyH.upPressed == true) {
    		
    		direction = "up";

    	
    	}
    	else if(keyH.downPressed == true) {
    		
    		direction = "down";

    	}
    	
    	else if(keyH.leftPressed == true) {
    		
    		direction = "left";

    	}
    	else if(keyH.rightPressed == true) {
    		
    		direction = "right";

    	}
		
		//check Collision
		collisionOn = false;
		gp.cChecker.checkTile(this);
		int objectIndex = gp.cChecker.checkObject(this, true);
		pickUpObject(objectIndex);
		
		
		 
		
		// if check Collision = false
		if(collisionOn == false) {
			switch(direction) {
			
			case "up":	worldY -= speed; break;
			
			case "down": worldY += speed; break;
			
			case "left": worldX -= speed; break;
			
			case "right": worldX += speed; break;
			
		}
		
		
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum==1) {
				spriteNum = 2;
			} 
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
		}
		
		
		
	}
	
	public void pickUpObject(int i) {
		if(i != 999) {
			
			String objName = gp.obj[i].name;
			
			switch(objName) {
			case "Key":
				System.out.println("Key");
				hasKey++;
				
				if (hasKey == 3) {
					gp.playSE(5);
					
				}
				else {
					gp.playSE(4);
				}
				
				gp.obj[i] = null;
				break;
				
			case "Door":
				
				if(hasKey == 3) {
				System.out.println("Door");
				gp.playSE(0);
				
				
				gp.obj[i] = null;
				}
				
				break;
				
			case "Chest":
				System.out.println("Chest");
				gp.playSE(1);
				gp.playSE(6);
				JOptionPane.showMessageDialog(null,"Mission Complete!");
				JOptionPane.showMessageDialog(null,"And you found...");
				gp.obj[i] = null;
				gp.stopMusic();
				gp.playSE(8);
				JOptionPane.showMessageDialog(null,"Bing Chilling!");
				gp.stopMusic();				
				break;
				
			case "Speed":
				gp.obj[i] = null;
				speed = 10;
				gp.playSE(2);
				break;
				
				
				
				
			case "House":
					gp.playSE(0);
					gp.playSE(7);
					JOptionPane.showMessageDialog(null,"A porta está fechada. :(");
					
					gp.obj[i] = null;
					gp.stopMusic();
				//gp.LoadNewMap("maps/indoor01.txt");

				
			}
			
			
		}
		
	}
		
		
	public void draw(Graphics2D g2) {
		   /*g2.setColor(Color.white);
	        g2.fillRect(x,y, gp.tileSize, gp.tileSize);*/
		
		BufferedImage image = null;
		switch(direction) {
		
		case "up":
			if(spriteNum==1) {
				image = up1;
			}
			if(spriteNum==2) {
				image = up2;
			}
			break;
		
		case "down":
			if(spriteNum==1) {
				image = down1;
			}
			if(spriteNum==2) {
				image = down2;
			}
			break;
		
		case "left":
			if(spriteNum==1) {
				image = left1;
			}
			if(spriteNum==2) {
				image = left2;
			}
			
			break;
		
		case "right":
			if(spriteNum==1) {
				image = right1;
			}
			if(spriteNum==2) {
				image = right2;
			}
			
			break;
		
		
		
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);
		
		
	}
}
