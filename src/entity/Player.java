package entity;

import main.KeyHandler;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 2;
        solidArea.y = 6;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 12;
        solidArea.width = 10;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 32;
        worldY = gp.tileSize * 24;
        speed = 4;
        direction = "down";
    }



    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/froth_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/froth_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/froth_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/froth_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/froth_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/froth_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/froth_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/froth_left_2.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
    	
    	if(keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed == true) {
            
    		if (keyH.upPressed == true) {
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
    		
    		// CHECK TILE COLLISION
    		collisionOn = false;
    		gp.cChecker.checkTile(this);
    		
    		// CHECK OBJECT COLLISION
    		int objIndex = gp.cChecker.checkObject(this, true);
    		
    		// IF COLLISION IS FALSE, PLAYER CAN MOVE
    		if(collisionOn == false) {
    			
    			switch(direction) {
    			case "up":
                    worldY -= speed;
    				break;
    			case "down":
                    worldY += speed;
    				break;
    			case "left":
                    worldX -= speed;
    				break;
    			case "right":
                    worldX += speed;
    				break;
    			}
    		}
            
            spriteCounter++;
            if(spriteCounter > 13) {
            	if(spriteNum == 1) {
            		spriteNum =2;
            	}
            	else if(spriteNum == 2) {
            		spriteNum = 1;
            	}
            	spriteCounter = 0;
            }
    	}

    }
    
    public void draw(Graphics2D g2) {
        
        //g2.setColor(Color.white);

        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch(direction) {
        case "up":
        	if(spriteNum == 1) {
        		image = up1;
        	}
            if(spriteNum == 2) {
            	image = up2;
            }
            break;
        case "down":
        	if(spriteNum == 1) {
        		image = down1;
        	}
            if(spriteNum == 2) {
            	image = down2;
            }
            
            break;
        case "left":
        	if(spriteNum == 1) {
                image = left1;
        	}
            if(spriteNum == 2) {
                image = left2;
            }

            break;
        case "right":
        	if(spriteNum == 1) {
                image = right1;
        	}
            if(spriteNum == 2) {
                image = right2;
            }
            break;

        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
