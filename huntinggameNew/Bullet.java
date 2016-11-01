
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject implements EntityA{
	
	private Texture tex;
	private Hmg game;
	public Bullet(double x, double y, Texture tex, Hmg game){
		super(x, y);
		this.tex = tex;
		this.game = game;
	}
	public void tick(){
		y-=10;

		if(Physics.Collision(this, game.eb)){
			System.out.println("eyy they hit each other");
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