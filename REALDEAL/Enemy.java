
import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.Random;

public class Enemy extends GameObject implements EntityB{
	
	private Texture tex;
	Random r = new Random();
	private Hmg game;
	private Controller c;
	Graphics gblood;

	private int speed = r.nextInt(3)+1;
	public Enemy(double x, double y, Texture tex, Controller c, Hmg game){
		super(x, y);
		this.tex=tex;
		this.c = c;
		this.game = game;
	}

	public void tick(){
		y+= speed;
		if( y > (Hmg.height * Hmg.scale)){
			y = 0;
			x = r.nextInt(Hmg.width * Hmg.scale);
		}
		if(Physics.Collision(this, game.ea)){
			c.removeEntityB(this);
			game.setEnemyKilled(game.getEnemyKilled() + 1);
		}
	}
	public void render(Graphics g){
			g.drawImage( tex.enemy, (int)x, (int)y, null);
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