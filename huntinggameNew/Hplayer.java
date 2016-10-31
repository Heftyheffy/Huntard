
import java.awt.Rectangle;
import java.awt.Graphics;

public class Hplayer extends GameObject implements EntityA{

	private double velX = 0;
	private double velY = 0;
	private Texture tex;

		public Hplayer(double x, double y, Texture tex){
			super(x, y);
			this.tex = tex;
		}
		public void tick(){
			x+=velX;
			y+=velY;
			if(x<=0)
				x = 0;
			if(y<=0)
				y=0;
			if(x>=800 -32)
				x=800 -32;
			if(y>=600 -32)
				y=600 -32;
		}
		public void render(Graphics g){
			g.drawImage( tex.player, (int)x, (int)y, null);
		}
		public double getX(){
			return x;
		}
		public double getY(){
			return y;
		}
		public void setX(double x){
			this.x = x;
		}
		public void setY(double y){
			this.y = y;
		}
		public void setVelX(double velX){
			this.velX = velX;
		}
		public void setVelY(double velY){
			this.velY = velY;
		}
		public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
}