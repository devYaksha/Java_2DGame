package object;

import javax.imageio.ImageIO;

public class OBJ_House extends SuperObject{
	
	public OBJ_House(){
	name = "House";
	
	try {
		
		image = ImageIO.read(getClass().getResourceAsStream("/tiles/033.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
