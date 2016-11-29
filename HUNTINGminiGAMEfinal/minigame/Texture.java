

import java.awt.image.BufferedImage;

public class Texture{
	public BufferedImage player, bullet, enemy, blood;
	private SpriteSheet ss;
public Texture(Hmg game){
	ss = new SpriteSheet(game.getSS());
	getTextures();
}	
private void getTextures(){
	player = ss.grabImage(1, 1, 32, 32);
	bullet = ss.grabImage(2, 1, 32, 32);
	enemy = ss.grabImage(3, 1, 32, 32);
	blood = ss.grabImage(4, 1, 32, 32);

}
}