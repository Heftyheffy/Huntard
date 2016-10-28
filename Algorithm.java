import java.awt.*;
import javax.swing.*;

public class Algorithm{
    private int intelligence, strength, stealth, psychology;
    private int[] item;

    //int[] gun1, gun2, gun3, map, flashlight, radio, food, water, 
    public Algorithm(int strength, int stealth, int intelligence, int psychology, int[] item){
	this.strength = strength;
	this.stealth = stealth;
	this.intelligence = intelligence;
	this.psychology = psychology;
	this.item = item;
    }

    public int getNumber(int str, int ste, int intel, int psy, Object it){
	ImageIcon icon = (ImageIcon) it;
	String desc = icon.getDescription();
	int num;
	if(desc == "gunIcon1.png") num = 0;
	else if(desc == "gunIcon2.png") num = 1;
	else if(desc == "gunIcon3.png") num = 2;
	else if(desc == "mapIcon.png") num = 3;
	else if(desc == "flashlightIcon.png") num = 4;
	else if(desc == "radioIcon.png") num = 5;
	else if(desc == "foodIcon.png") num = 6;
	else num = 7;
	
	return (this.strength*str + this.stealth*ste + this.intelligence*intel + this.psychology*psy)* item[num];
    }
}
