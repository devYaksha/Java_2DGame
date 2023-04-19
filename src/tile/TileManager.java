package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	 public Tile[] tile;
	 public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[40];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/map01.txt");
	}

	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/000.png"));
			
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/001.png"));
			
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/002.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/003.png"));
			
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/004.png"));
			
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/005.png"));
			
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/006.png"));
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/007.png"));
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/008.png"));
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/009.png"));
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/010.png"));
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/011.png"));
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/012.png"));
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/013.png"));
			
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/014.png"));
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/015.png"));
			
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/016.png"));
			tile[16].collision = true;
			
			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/017.png"));
			
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/018.png"));
			tile[18].collision = true;
			
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/019.png"));
			tile[19].collision = true;
			
			
			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/020.png"));
			tile[20].collision = true;
			
			
			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/021.png"));
			tile[21].collision = true;
			
			
			tile[22] = new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/022.png"));
			tile[22].collision = true;
			
			
			tile[23] = new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/023.png"));
			tile[23].collision = true;
			
			tile[24] = new Tile();
			tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/024.png"));
			tile[24].collision = true;
			
			tile[25] = new Tile();
			tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/025.png"));
			tile[25].collision = true;
			
			tile[26] = new Tile();
			tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/026.png"));
			tile[26].collision = true;
			
			tile[27] = new Tile();
			tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/027.png"));
			tile[27].collision = true;
			
			tile[28] = new Tile();
			tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/028.png"));
			tile[28].collision = true;
			
			tile[29] = new Tile();
			tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/029.png"));
			tile[29].collision = true;
			
			tile[30] = new Tile();
			tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/030.png"));
			tile[30].collision = true;
			
			tile[31] = new Tile();
			tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/031.png"));
			tile[31].collision = true;
			
			tile[32] = new Tile();
			tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/032.png"));
			tile[32].collision = true;
			
			tile[33] = new Tile();
			tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/033.png"));
			
			
			tile[34] = new Tile();
			tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/034.png"));
			tile[34].collision = true;
			
			tile[35] = new Tile();
			tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/035.png"));
			tile[35].collision = true;
			
			tile[36] = new Tile();
			tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/036.png"));
			tile[36].collision = true;
			
			tile[37] = new Tile();
			tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/037.png"));
			tile[37].collision = true;
			
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
		
	public void loadMap(String mapPath) {
		try {
			InputStream is = getClass().getResourceAsStream(mapPath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
				
			}
			
			br.close();
			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;
		
		
		
		
		while(worldCol <gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if(		worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {		
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);}
				
				
			
			worldCol++;
			
			
			
			if(worldCol == gp.maxWorldCol) {
				
			worldCol = 0; 
			worldRow++;
			}
		}
		
	}
}
