package main;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import object.*;

import entity.Player;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class GamePanel extends JPanel implements Runnable{
	
	//Screen settings
	
	final int originalTileSize = 16; //16x16
    final int scale = 5;

    
    public final int tileSize = originalTileSize*scale; //48x48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol;
    public final int screenHeight = tileSize*maxScreenRow; //768x576
    
    
    //World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWIdth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    //fps
    final int FPS = 60;
   
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    // DECLARACAO DOS OBJETOS
    
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,keyH);
    public SuperObject[] obj = new SuperObject[10];
    Sound sound = new Sound();
    TileManager tileM = new TileManager(this);
    
    public void LoadNewMap(String string)
    {
    	tileM.loadMap(string);
    	
    }    
    
    //
    
    
    
        public GamePanel(){
            
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyH);
            this.setFocusable(true);
        }
        
    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
        
    }

    public void setupGame() {
    	aSetter.setObject();
    	playMusic(3);
    	Alert();
    	
    }
    
    public void run(){
        while(gameThread != null){
        	
        	double drawInterval = 1000000000/FPS; //0.01666
        	double nextDrawTime = System.nanoTime() + drawInterval;
        	
            // 1: Update information such as characters positions
            update();
            
            // 2: Draw the screen with the upload information
            repaint();
            
            
            try {
            	double remainingTime = nextDrawTime - System.nanoTime();
            	remainingTime = remainingTime/1000000;
            	
            	if(remainingTime <0) {remainingTime = 0;}
            	
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

        }

    }


    public void update(){
    	player.update();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        
        
        for(int i=0; i < obj.length; i++) {
        	if(obj[i] != null) {
        		obj[i].draw(g2, this);
        		
        	}
        }
        
        player.draw(g2);

        g2.dispose();

    }
    
    public void Alert() {
    	int justShowOnce = 0;
    	if (justShowOnce<=3) {
    	justShowOnce++;
    	JOptionPane.showMessageDialog(null, "Hello, player. To open this door u need to find 3 doors around the map.");
    	}
    	
    }
    
    public void playMusic(int i) {
    	sound.setFile(i);
    	sound.play();
    	sound.loop();
    }
    
    public void stopMusic() {
    	sound.stop();
    }
    
    public void playSE(int i) {
    	sound.setFile(i);
    	sound.play();
    	
    }
	
	
}
