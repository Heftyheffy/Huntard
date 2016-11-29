
import java.awt.Rectangle;
import java.awt.Graphics;

public class Hplayer extends GameObject implements EntityA{

	private double velX = 0;
	private double velY = 0;
	private Texture tex;
	Hmg game;
	Controller controller;

		public Hplayer(double x, double y, Texture tex, Hmg game, Controller controller){
			super(x, y);
			this.tex = tex;
			this.game = game;
			this.controller = controller;
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

			for(int i = 0; i < game.eb.size(); i++){
				EntityB tempEnt = game.eb.get(i);
				if(Physics.Collision(this, tempEnt)){
					controller.removeEntityB(tempEnt);
					Hmg.health -= 10;
					game.setEnemyKilled(game.getEnemyKilled() + 1);
				}
			}
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