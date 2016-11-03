
import java.util.LinkedList;
import java.awt.Graphics;
import java.util.Random;

public class Controller{
	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private LinkedList<EntityB> eb = new LinkedList<EntityB>();

	EntityA entA;
	EntityB entB;
	private Texture tex; 
	Random r = new Random();
	private Hmg game;

	public Controller(Texture tex, Hmg game){
		this.tex = tex;
		this.game = game;
	}

	public void tick(){
		//Entity A class
		for(int i = 0; i<ea.size(); i++){
			entA = ea.get(i);

			entA.tick();
		}
		//Entity B class
			for(int i = 0; i<eb.size(); i++){
			entB = eb.get(i);

			entB.tick();
		}
	}
	public void render(Graphics g){
		//EntityA class
		for(int i = 0; i<ea.size(); i++){
			entA = ea.get(i);
			
			entA.render(g);
		}
		//Entityb class
		for(int i = 0; i<eb.size(); i++){
			entB = eb.get(i);
			
			entB.render(g);
		}

	}
	public void addEntityA(EntityA block){
		ea.add(block);
	}

	public void removeEntityA(EntityA block){
		ea.remove(block);
	}
	public void addEntityB(EntityB block){
		eb.add(block);
	}

	public void removeEntityB(EntityB block){
		eb.remove(block);
	}
	public void createEnemy(int enemyCount){
		for(int i=0;i<enemyCount;i++){
			addEntityB(new Enemy(r.nextInt(700), -10, tex, this, game));
		}
	}
	public LinkedList<EntityA> getEntityA(){
		return ea;
	}
	public LinkedList<EntityB> getEntityB(){
		return eb;
	}
}