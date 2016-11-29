import java.awt.*;
import javax.swing.*;

public class Resource extends Item{    
    private int amount;

    public Resource(String name, ImageIcon small, ImageIcon large, int amount){
	super(name, small, large);
	this.amount = amount;
    }

    public void setAmount(int a){
	this.amount = a;
    }

    public void addAmount(int a){
	this.amount += a;
    }

    public int getAmount(){
	return this.amount;
    }	
}
