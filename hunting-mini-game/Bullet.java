import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet{
	private double x;
	private double y;
	BufferedImage image;
	Hmg game;
	public Bullet(double x, double y, Hmg game){
		this.x = x;
		this.y = y;
		SpriteSheet ss = new SpriteSheet(game.getSS());
		image = ss.grabImage(2,1,32,32);
	}
	public void tick(){
		x-=10;
	}
	public void render(Graphics g){
		g.drawImage( image, (int)x, (int)y, null);
	}
	public double getX(){
		return x;
	}
}