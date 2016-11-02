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
		public static boolean Collision(EntityB entB, LinkedList<EntityA> entA){
			for(int i=0; i<entA.size() ;i++){
				if(entB.getBounds().intersects(entA.get(i).getBounds())){
					return true;
				}
			}

		return false;
	}
}