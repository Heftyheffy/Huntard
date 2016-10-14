import java.awt.*;
import javax.swing.*;

public class BackgroundImage extends JComponent{
    private Image image;
    
    public BackgroundImage(Image image){
	this.image = image;
    }

    protected void paintComponent(Graphics g){
	super.paintComponent(g);
	g.drawImage(image, 0, 0, this);
    }
}
