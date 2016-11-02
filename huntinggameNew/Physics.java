import java.awt.Rectangle;
import java.util.LinkedList;

public class Physics{
	
	public static boolean Collision(EntityA entA, LinkedList<EntityB> entB){
			for(int i=0; i<entB.size() ;i++){
				if(entA.getBounds().intersects(entB.get(i).getBounds())){
					return true;
				}
			}

		return false;
	}
}