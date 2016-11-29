import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e){
		//empty
	}
	@Override
	public void mouseEntered(MouseEvent e){
		//empty
	}
	@Override
	public void mouseExited(MouseEvent e){
		//empty
	}
	@Override
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();

		if(mx >= Hmg.width / 2 + 120 && mx <= Hmg.width / 2 + 220){
			if(my>= 150 && my <= 200){
				//pressed return
				Hmg.State = Hmg.STATE.END;
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e){
		//empty
	}
	
}