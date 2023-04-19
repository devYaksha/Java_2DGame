package object;

import javax.imageio.ImageIO;

public class OBJ_Speed extends SuperObject{

public OBJ_Speed() {
		
		name = "Speed";
		
		try {
			
		image = ImageIO.read(getClass().getResourceAsStream("/objects/speed.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
