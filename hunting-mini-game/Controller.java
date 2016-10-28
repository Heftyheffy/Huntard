import java.util.LinkedList;
import java.awt.Graphics;

public class Controller{
	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	Bullet tempBullet;
	Hmg game;
	public Controller(Hmg game){
		this.game = game;
	}
	public void tick(){
		for(int i = 0; i < b.size(); i++){
			tempBullet = b.get(i);
			if(tempBullet.getX() < 0)
				removeBullet(tempBullet);
			tempBullet.tick();
		}
	}
	public void render(Graphics g){
		for(int i = 0; i < b.size(); i++){
			tempBullet = b.get(i);
			tempBullet.render(g);
		}
	}
	public void addBullet(Bullet block){
		b.add(block);
	}
	public void removeBullet(Bullet block){
		b.remove(block);
	}
}