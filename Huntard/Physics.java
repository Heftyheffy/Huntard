import java.awt.Rectangle;
import java.util.LinkedList;

public class Physics{
	
	public static boolean Collision(EntityA entA, EntityB entB){
				if(entA.getBounds().intersects(entB.getBounds())){
					return true;		
			}

		return false;
	}
		public static boolean Collision(EntityB entB, EntityA entA){
			
				if(entB.getBounds().intersects(entA.getBounds())){
					return true;
				}
			

		return false;
	}
}