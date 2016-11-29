import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;


public class Score{

	public Rectangle returnButton = new Rectangle(Hmg.width / 2 + 120, 150, 100, 50);

	public void render(Graphics g){
			Graphics2D g2d = (Graphics2D) g;

		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Score Screen", Hmg.width / 2, 100);

		Font fnt1 = new Font("arial", Font.BOLD, 28);
		g.setFont(fnt1);
		g.drawString("Return",returnButton.x + 8, returnButton.y + 30);
		g2d.draw(returnButton);
	}

}