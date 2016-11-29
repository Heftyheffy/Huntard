import java.awt.Rectangle;
import java.awt.Graphics;

public interface EntityA{
	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();
	public double getX();
	public double getY();
}