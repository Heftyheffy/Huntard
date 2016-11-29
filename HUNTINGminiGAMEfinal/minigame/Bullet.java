
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject implements EntityA{
	
	private Texture tex;
	private Hmg game;
	public String direction;

	public Bullet(double x, double y, Texture tex, Hmg game, String direction){
		super(x, y);
		this.tex = tex;
		this.game = game;
		this.direction = game.getlastKey(); 
	}
	public void tick(){
		if(direction == "up"){
			y-=10;
		}else if(direction == "down"){
			y+=10;
		}else if(direction == "left"){
			x-=10;
		}else if(direction == "right"){
			x+=10;
		}

		

	}
	public void render(Graphics g){
		g.drawImage( tex.bullet, (int)x, (int)y, null);
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
}