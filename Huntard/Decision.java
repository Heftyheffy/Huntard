import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*;

public class Decision{
    
    String text;
    String[] options, endings;
    boolean simple;    
    JTextArea area;
    Algorithm algo;
    int[] used = new int[40];
    Decision d[];
    JPanel panel, lPanel, rPanel, nPanel, sPanel, main;
    JLabel day;
    JComboBox cBox, iBox;
    JButton enter, okay;
    ArrayList<Character> chars;
    ArrayList<Item> items;
    Character c;
    int decisionNum;
    int key;
    
    public Decision(String text, boolean simple, String[] options, String[] endings, Algorithm algo){
	this.text = text;
	this.simple = simple;
	this.options = options;
	this.endings = endings;
	this.algo = algo;
	this.decisionNum = 0;
    }

    public void getDecision(JPanel p, ArrayList<Character> chars, ArrayList<Item> items){
	area = new JTextArea();
	panel = new JPanel(new BorderLayout());
	lPanel = new JPanel();
	rPanel = new JPanel();
	nPanel = new JPanel();
	sPanel = new JPanel();
	enter = new JButton("Enter");
	okay = new JButton("Okay");	    
	enter.addActionListener(new ButtonListener());
	okay.addActionListener(new ButtonListener());

	this.chars = chars;
	this.items = items;
	
	sPanel.setPreferredSize(new Dimension(100, 100));
	sPanel.setBackground(Color.lightGray);

	nPanel.setPreferredSize(new Dimension(60, 60));
	nPanel.setBackground(Color.lightGray);
	
	lPanel.setPreferredSize(new Dimension(100, 100));
	lPanel.setBackground(Color.lightGray);
	
	rPanel.setPreferredSize(new Dimension(100, 100));
	rPanel.setBackground(Color.lightGray);
	
	day = new JLabel("Day 1");
	day.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	day.setForeground(Color.red);
	nPanel.add(day);	
	
	area.setText(d[decisionNum].text);
	if(d[decisionNum].simple){
	    cBox = new JComboBox(d[decisionNum].options);
	    cBox.setPreferredSize(new Dimension(600, 30));	    
	    sPanel.add(cBox);	    
	    sPanel.add(enter);	    
	}
	else{
	    ImageIcon[] cBoxIcons = new ImageIcon[chars.size()];	    
	    for(int i=0; i < chars.size(); i++){
		cBoxIcons[i] = chars.get(i).getIcon();
	    }
	    DefaultComboBoxModel<ImageIcon> icons = new DefaultComboBoxModel<ImageIcon>(cBoxIcons);
	    cBox = new JComboBox(icons);

	    ArrayList<ImageIcon> iBoxIconsList = new ArrayList<ImageIcon>();
	    for(int i=0; i <items.size(); i++){
		if(i == 0 || i == 1){
		    Resource a = (Resource)items.get(i);
		    if(a.getAmount() == 0) continue;
		}
		else if(i == 2) continue;
	        iBoxIconsList.add(items.get(i).getSmallIcon());
	    }
	    ImageIcon[] iBoxIcons = new ImageIcon[iBoxIconsList.size()];
	    for(int i=0; i<iBoxIconsList.size(); i++){
		iBoxIcons[i] = (ImageIcon)iBoxIconsList.get(i);
	    }
	    icons = new DefaultComboBoxModel<ImageIcon>(iBoxIcons);
	    iBox = new JComboBox(icons);

	    sPanel.add(cBox);
	    sPanel.add(enter);
	    sPanel.add(iBox);
	}
	area.setLineWrap(true);
	area.setWrapStyleWord(true);
	area.setBackground(Color.lightGray);
	area.setForeground(Color.red);	
	area.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	area.setEditable(false);
	panel.setPreferredSize(new Dimension(600, 400));
	area.setPreferredSize(new Dimension(450, 300));
	p.removeAll();
	panel.add(lPanel, BorderLayout.EAST);
	panel.add(rPanel, BorderLayout.WEST);
	panel.add(nPanel, BorderLayout.NORTH);
	panel.add(area, BorderLayout.CENTER);
	panel.add(sPanel, BorderLayout.SOUTH);
	p.add(panel);
	p.setOpaque(false);	
    }

    public Decision[] generateDecisions(){
	d = new Decision[50];
	int gun1, gun2, gun3, map, flash, radio, foodInt, waterInt;

	gun1 = 2;
	gun2 = 3;
	gun3 = 4;
	map = 0;
	flash = 0;
	radio = 0;
	foodInt = -100;
	waterInt = -1;
	
	//1,2,3,m,fl,r,f,w
	int[] itemInts = {gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};

	int str, ste, inte, psy;

	str = 3;
	ste = 1;
	inte = 2;
	psy = 0;

	//str, ste, int, psy, nums
	Algorithm rithm = new Algorithm(str, ste, inte, psy, itemInts);

	String food, water, bad, medium, good;
	
	food = "The monks gladly accepted your tithe\n-1 Food";
	water = "The monks gladly accepted your tithe\n-1 Water";
	bad = "The monks responded to your heresy with violence and you barely make it back alive\n-50 Health";
	medium = "The monks proved more formidable than you initially thought but you were able to make it out with only a scratch\n-20 Health";
	good = "The monks have ran away in terror from your might and dropped some resources on their way out\n+2 Food and Water";
	
	String[] e = {food, water, bad, medium, good};
	d[0] = new Decision("A roving band of monks of the new religious order proclaiming Harambe to be the gorilla jesus has appeared outside the shelter demanding tithe in the form of food and water. How should these people be dealt with?", false, null, e, rithm);
	////////////////////////////////////////
	gun1 = 3;
	gun2 = 2;
	gun3 = 1;
	map = 0;
	flash = 3;
	radio = 0;

	str = 0;
	ste = 3;
	inte = 2;
	psy = 1;

	food = "An enormous rat lunged out of the darkness at you! But luckily he went for your food and left you unscathed\n-1 Food";
	water = "An enormous rat lunged out of the darkness at you! But luckily he went for your food and left you unscathed\n-1 Water";
	bad = "An enormous rat jumped out of the darkness and attacked you! The rat only left you alone after you played dead.\n-40 Health";
	medium = "An enormous rat jumped out of the darkness and attacked you! Luckily you were able to scare it off before taking too much damage\n-10 Health";
	good = "Under the crawlspace you saw an enormous rat burrowing into the earth and luckily you were able to kill it. It looks delicious.\n+2 Food";

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm = new Algorithm(str, ste, inte, psy, itemInts);
	e = new String[]{food, water, bad, medium, good};
	d[1] = new Decision("A sound can be heard coming from the crawlspace underneath the shelter. Who should go investigate?", false, null, e, rithm);
	//////////////////////////////////////////////////////
	String o1, o2, o3;        

	o1 = "Yes, this rain is a blessing and we need to take advantage of it";
	o2  ="No, with the destruction the gorillas have caused the rain is probably incredibly polluted";

	bad = "The rain turned out to have a high acidity and drinking it caused everyone to lose some health\n-20 All Health";
	good = "Water from the sky is gross anyways\n+5 Nothing";

	String[] o = {o1, o2};
	e = new String[]{bad, good};
	d[2] = new Decision("A torrential rain has started outside, should you go out and try to collect some to drink?", true, o, e, null);
	/////////////////////////////////////////
	o1 = "Give them some candy";
	o2 = "Refuse to give them any candy";
	o3 = "Give them some food and water";

	good = "You didn't have any candy to give but they appreciated the thought and gave you a gift in return\n+1 Halloween Costume";
	bad = "Crazy people don't take lightly to being disrespected. They stormed the shelter and attacked everyone in it.\n-30 All Health";
	medium = "They may be crazy but they know what candy is and it isn't this. But they took it anyways. Unhappily\n-1 Food and Water";

	o = new String[]{o1, o2, o3};
	e = new String[]{good, bad, medium};
	d[3] = new Decision("A group of crazy people dressed in halloween costumes appeared outside asking for candy, what should you do?", true, o, e, null);
	////////////////////////////
	o1 = "Yes, we need to take every chance to get more supplies";
	o2 = "No, it's still too dangerous to go outside in the daylight";

	good = "Your search proved fruitful, you found food and water!\n+1 Food and Water";
	bad = "It remained quiet outside\n+5 Nothing";
	    
	o = new String[]{o1, o2};
	e = new String[]{good, bad};
	d[4] = new Decision("There's been no movement outside for a couple days now, should you go look around for supplies?", true, o, e, null);
	////////////////////////////////////////////////////
	gun1 = 0;
	gun2 = 1;
	gun3 = 2;
	map = 4;
	flash = 3;
	radio = 0;

	str = 2;
	ste = 3;
	inte = 3;
	psy = 2;

	food = "You wandered around aimlessly until you were cornered by a dog and forced to forfeit your food\n-1 Food";
	water = "You wandered around aimlessly until you were cornered by an armed hobo who took your water\n-1 Water";
	bad = "You wandered around aimlessly until you were attacked by a band of armed youths\n-40 Health";
	medium = "You wandered around, unable to find anything resembling entertainment, then you fell and scraped your knee\n-10 Health";
	good = "You found a couple old DVDs lying around but when you got back to the base you realized that you didn't have a DVD player, so everyone just looked at the cover and felt better\n+30 All Health";
	
	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm = new Algorithm(str, ste, inte, psy, itemInts);
	e = new String[]{food, water, bad, medium, good};
	d[5] = new Decision("Spirits are running low among in the group so they have resolved to go out and get some entertainment. Who should go?", false, null, e, rithm);
	///////////////////////
	o1 = "Yes, we need all the supplies we can get";
	o2 = "No, a random crate appearing is too odd for comfort";

	bad = "As soon as you leave the shelter you get jumped by a group of bandits and sustain heavy damage.\n-30 All Health";
	good = "Damn, I wonder what was in that crate. It was gone by the next day.\n+5 Nothing";

	o = new String[]{o1, o2};
	e = new String[]{bad, good};			 
	d[6] = new Decision("A crate has appeared outside the shelter overnight. Should someone go check it out?", true, o, e, null);
	/////////////////////////////////////////
	gun1=gun2=gun3=0;
	map=flash=radio=3;

	str= 0;
	ste = 2;
	inte = 1;
	psy = 3;

	food = "The ravers welcomed you and your food with open arms and after raving for a couple dozen hours you come back with no food\n -1 Food";
	water = "The ravers welcomed you and your water with open arms and after raving for a couple dozen hours you come back with no water\n -1 Water";
	bad = "Violence was not the way to deal with these people and you paid dearly for your violent ways.\n-40 Health";
	medium = "The ravers welcomed you but you couldn't handle the sheer intensity of the partying\n-20 Health";
	good = "The ravers welcomed you and you enjoyed hours of intense partying\n+40 Health";
	
	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm = new Algorithm(str, ste, inte, psy, itemInts);
	e = new String[]{food, water, bad, medium, good};
	d[7] = new Decision("Loud party music and strobe lights can be heard playing down the street. It sounds like a rave. Who should go check it out?", false, null, e, rithm);
	///////////////////////////////
	o1 = "Let him in. We have a duty to our country to defend against the gorilla menace.";
	o2 = "Pretend there's no one home. No good will come out of dying for our country.";

	bad = "The man comes in and chooses the person with the highest health to accompany him back to military HQ\n-1 Character";
	good = "The man shouts a little more from outside and then finally leaves\n+5 Nothing";

	o = new String[]{o1, o2};
	e = new String[]{bad, good};
	d[8] = new Decision("A person wearing a military uniform came to the door of the shelter talking about mandatory military service in our country's time of need. What should you do?", true, o, e, null);    
	/////////////////////////////////
	gun1 = 2;
	gun2 = 2;
	gun3 = 2;
	map = 3;
	flash = 2;
	radio = 0;

	str = 1;
	ste = 3;
	inte = 2;
	psy = 0;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "You tried finding vegetables by carrying around food but all it did was attract stray dogs that took your food away from you.\n-1 Food";
	water = "As soon as you left the shelter you tripped and spilled your water. And then you couldn't find any vegetables.\n-1 Water";
	bad = "You walked into an old grocery store and found some vegetables! Unfortunately they had been contaminated by something and they caused sever illness\n-30 All Health";
	medium = "You walked a little out of town and found a small farm. Unfortunately the farm only grew drugs, and not very good ones. They made you get slightly ill.\n-10 Health";
	good = "You went way out of town and found an extravagant farm with all kinds of healthy vegetables. Unfortunately they wouldn't sell you any, but you were able to steal a few.\n+3 Food";

	e = new String[]{food, water, bad, medium, good};

	d[9] = new Decision("Eating gorilla meat everyday has had a bad impact on the group's health. Who should go out to find some vegetables and quinoa?", false, null, e, rithm);
	////////////////////////////////
	o1 = "Go pet the doggy, if you don't it might die from loneliness";
	o2 = "No, why would there just be a cute doggy outside without some sort of motive?";

	good = "Everyone went outside to go pet the doggy and it made everyone feel better\n+30 All Health";
	bad = "The dog lingered outside for a while and then left looking unloved, but you know you made the right choice";

	o = new String[]{o1, o2};
	e = new String[]{good, bad};
	d[10] = new Decision("You can see a cute little dog from the window. He looks like he needs to be pet, should you go pet him?", true, o, e, null);
	///////////////////////////////////////////////////
	o1 = "No, stop being stupid. You know they're done for.";
	o2 = "Yes, even if there's the slightest chance that they're still alive you have to look";

	good = "You know you made the right decision.\n+5 Nothing";
	bad = "The healthiest character went out to search for everyone's loved ones.\n-1 Character";

	o = new String[]{o1, o2};
	e = new String[]{good, bad};
	d[11] = new Decision("You've really started to miss your family, should you go out and try to find them?", true, o, e, null);
	////////////////////////////////////////////
	o1 = "Of course, I love chicken sandwiches";
	o2 = "No, it's got to be a trick of some sort";

	good = "Well rather than a Chick-fil-a it turned out to be a crazy guy frying up zombie gorilla, but you still got a free sandwich\n+1 Food";	
	bad = "You stayed home and smelled the chicken frying from down the road\n+5 Nothing";

	o = new String[]{o1,o2};
	e = new String[]{good, bad};

	d[12] = new Decision("You heard that a new Chick-fil-a is having a grand opening down the street. Should you attend to try to get a free chicken sandwich?", true, o, e, null);
	////////////////////////////////////////
	gun1 = 2;
	gun2 = 2;
	gun3 = 2;
	map = 3;
	flash = 2;
	radio = 0;

	str = 1;
	ste = 3;
	inte = 2;
	psy = 0;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "Unfortunately the food didn't lead you in the right direction and you were unable to find any antibiotics\n-1 Character";
	water = "Unfortunately the water didn't lead you in the right direction and you were unable to find any antibiotics\n-1 Character";
	bad = "You wandered around the city until you went back to the shelter empty handed\n-1 Character";
	medium = "Well... You found something but it wasn't easy\n-20 Health";
	good = "You managed to find a cure all and it helped everyone's health\n+60 All Health";

	e = new String[]{food, water, bad, medium, good};

	d[13] = new Decision("A character has caught an infection. Who will go out to find antibiotics?", false, null, e, rithm);
	//////////////\\\\\\\\\\\\\\\\/////////////////\\\\\\\
	gun1 = 2;
	gun2 = 2;
	gun3 = 2;
	map = 3;
	flash = 2;
	radio = 0;

	str = 1;
	ste = 3;
	inte = 2;
	psy = 0;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "You were able to find someone to trade food with for a bag of coffee but it turns out the coffee they gave you was actually a bag of beetles\n-1 Food";
	water = "You were able to find someone to trade water with for a bag of coffee but it turns out the coffee they gave you was actually a bag of beetles\n-1 Water";
	bad = "You searched all the trashcans and gutters you could find but found no coffee, just a huge hole deep enough to break a leg if you fell into it\n-60 Health";
	medium = "You couldn't find any coffee, and now your feet hurt from walking around all day. You need new shoes\n-10 Health";
	good = "You searched everywhere you possibly could but found no coffee, but you did happen to find a new gun\n+1 Gun";

	e = new String[]{food, water, bad, medium, good};
	d[14] = new Decision("Waking up has been difficult for the team. They need coffee. Who will go get it?", false, null, e, rithm);
	///////////////////////////////////////
	gun1 = 2;
	gun2 = 3;
	gun3 = 4;
	map = 0;
	flash = 2;
	radio = 1;

	str = 3;
	ste = 2;
	inte = 1;
	psy = 0;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "You were attacked by the zombie gorillas but luckily you were able to take distract them with some food\n-1 Food";
	water = "You were attacked by the zombie gorillas but luckily you were able to take distract them by splashing some water on them\n-1 Water";
	bad = "You were unable to ward off the gorilla zombies as they attacked you and consequently sustained heavy damage\n-40 Health";
	medium = "You didn't really manage to make any repairs but you didn't get too badly hurt\n-20 Health";
	good = "The zombie gorillas showed up and interrupted your repairs but you were able to fend them off and gain some food in the process\n+3 Food";

	e = new String[]{food, water, bad, medium, good};
	
	d[15] = new Decision("The shelter has been getting bombarded by zombie gorillas lately. Repairs are needed and they need to be done in the short interval while it's still clear outside. Who will go?", false, null, e, rithm);
	///////////////////////////////////////////////
	o1 = "Nothing. Ghosts don't exist therefore nothing should be done";
	o2 = "Vacate the shelter immediately and search for a new place to live";
	o3 = "Set a ghost trap";

	bad = "Well it wasn't a ghost, but something definitely should've been done about it. The raccoon took all your food\n-All Food";
	medium = "You packed up all your stuff and left but you couldn't find anywhere else to go so you were forced to go back, but only after running into some street thugs\n-30 All Health";
	good = "Well you caught something, but it wasn't a ghost. But it looks delicious\n+2 Food";

	o = new String[]{o1, o2, o3};
	e = new String[]{bad, medium, good};
	d[16] = new Decision("You've been hearing noises at night. Everyone is saying that there's a ghost in the shelter. What should be done about this?", true, o, e, null);
	////////////////////////////////////////////
	o1 = "Clothes, we're more likely to find that than a heater";
	o2 = "A heater, it'll be much more effective than clothes";

	good = "You were only able to find a couple blankets. It was a cold winter\n-20 All Health";
	bad = "You found a heater! Unfortunately you don't have working electricity\n-50 All Health";

	o = new String[]{o1, o2};
	e = new String[]{good, bad};

	d[17] = new Decision("It's getting cold outside. Should you search for warm clothes or a heater?", true, o, e, null);
	//////////////////////////////////////
	o1 = "Play a board game! Some friendly competetion is always good";
	o2 = "Go for a walk and get some fresh air!";
	o3 = "Do nothing";

	medium = "Nobody likes losing, and sometimes it causes a fight to break out\n-10 All Health";
	bad = "Why would going outside in the middle of a zombie gorilla apocalypse be a good idea? You barely made it back to the base alive\n-50 All Health";
	good = "There's nothing like doing nothing to change up the pace a bit\n+5 Nothing";

	o = new String[]{o1, o2, o3};
	e = new String[]{medium, bad, good};

	d[18] = new Decision("Things have been getting pretty boring around the shelter. How should it be livened up?", true, o, e, null);
	///////////////////////////////////////////
	o1 = "Medkit, everyone is desperately in need of some medical assistance";
	o2 = "A gun, you need some extra protection";
	o3 = "A flashlight, you need some extra supplies";

	bad = "Somehow you managed to actually find one!\n+1 Medkit";
	medium = "Just as you gave up hope you managed to find a gun laying in the trash! It's a little dirty, but should still work properly\n+1 Gun";
	good = "It turns out there was actually a flashlight already under the couch\n+1 Flashlight";

	o = new String[]{o1, o2, o3};
	e = new String[]{bad, medium, good};
	
	d[19] = new Decision("You're feeling adventurous today. What should you go search for?", true, o, e, null);
	/////////////////////////////////////////////
	gun1 = 2;
	gun2 = 3;
	gun3 = 3;
	map = 2;
	flash = 3;
	radio = 0;

	str = 3;
	ste = 1;
	inte = 0;
	psy = 2;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "On your venture to get a Christmas tree you were attacked by wolves and your food was taken\n-1 Food";
	water = "You got the Christmas tree, but it was thirsty work so you drank your water\n-1 Water";
	bad = "As you were cutting down the tree a limb fell on you\n-40 Health";
	medium = "You found a beautiful huge Christmas tree but carrying it hurt your back\n-10 Health";
	good = "As you went out to look for a Christmas tree you found a Medkit on the ground!\n+1 Medkit";

	e = new String[]{food, water, bad, medium, good};
	
	d[20] = new Decision("It's Christmas eve, someone needs to go out and get a tree. Who should go get it?", false, null, e, rithm);
	///////////////////////////////////////////////////
	gun1 = 2;
	gun2 = 3;
	gun3 = 4;
	map = 3;
	flash = 2;
	radio = 0;

	str = 2;
	ste = 3;
	inte = 1;
	psy = 0;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "Because you brought food with you, you were able to stay out longer than usual. But that didn't help you find anything useful\n-1 Food";
	water = "Because you brought water with you, you were able to stay out longer than usual. But that didn't help you find anything useful\n-1 Water";
	bad = "You saw a lot of things while you were out. Zombie gorillas have destroyed this town. It was scary. You wanted to go back to the shelter, but as soon as you made that decision you were attacked. You don't even know by what. All you know is you barely made it back alive\n-50 Health";
	medium = "You were able to get a lot of exploring done. The town has really gone to hell, but they are still some supplies around\n+1 Water ";
	good = "You were able to avoid any major confrontations with the many enemies in the town, and eventually you ran into something good\n+3 Medkit";
	e = new String[]{food, water, bad, medium, good};
	
	d[21] = new Decision("Being cooped up in the shelter has started to get on everyone's nerves. Someone needst to go out to break up this monotony and maybe even bring something back. Who should go?", false, null, e, rithm);
	/////////////////////////////////////
	o1 = "Yes, they look fine";
	o2 = "No, you shouldn't take any weird risks";

	bad = "The mushrooms weren't too bad! Unfortunately they weren't good either. In fact they were bad\n-30 All Health";
	good = "You sat there brooding about the fact that you couldn't eat the mushrooms, and in the undergrowth you happened to see a map!\n+1 Map";

	o = new String[]{o1, o2};
	e = new String[]{bad, good};
	
	d[22] = new Decision("You found a huge patch of mushrooms growing under the shelter! They look delicious. Should you eat them?", true, o, e, null);
	/////////////////////////////////////////////////
	o1 = "Play a game of football!";
	o2 = "Monopoly!";
	o3 = "Let's play a friendly game of poker";

	good = "It's good to go outside for some sunshine and fresh air! It had the potential to turn out really badly but luckily today nothing bad happened!\n+30 All Health";
	bad = "Why would it ever be a good idea to play a game of Monopoly to help good spirits? Everyone ended up fighting over park place and several of the game tokens ended up in an orifice\n-30 All Health";
	medium = "Poker can be fun if one person isn't better than everyone else. But we were able to win a medkit off a passing hobo!\n+1 Medkit";
	o = new String[]{o1, o2, o3};
	e = new String[]{good, bad, medium};

	d[23] = new Decision("In these close quarters simple conversations seem to always turn into arguments. We need a change of pace in order to keep spirits up. What should you do?", true, o, e, null);
	////////////////////////////////////////////
	o1 = "Yes! It could be someone with good news";
	o2 = "No! Who knows who that could possibly be";

	bad = "Well nobody was there. Damn pranksters\n+5 Nothing";
	good = "You were too scared to open the door, but a couple hours later after the knocking had gone away you opened the door and found a radio!\n+1 Radio";

	o = new String[]{o1, o2};
	e = new String[]{bad, good};
	d[24] = new Decision("Loud banging can be heard coming from the back door to the shelter. It wasn't even thought that someone could get around to there given all the collapsed buildings. Should you open it?", true, o, e, null);
	/////////////////////////////////////////////
	o1 = "Yes, it might grow something that can sustain us for the rest of our lives!";
	o2 = "No, we can't afford to waste any water!";

	bad = "You planted the seed and now all you have to do is wait\n-1 water";
	good = "Turns out it was a peanut....\n+5 Nothing";

	o = new String[]{o1, o2};
	e = new String[]{bad, good};
	
	d[25] = new Decision("You were bored and searching through the supplies when you found something you hadn't noticed before! It was a small seed. It might bear fruit! But you'd have to use a bottle of water on it. Should you plant it?", true, o, e, null);
	//////////////////////////////////////////
	gun1 = 2;
	gun2 = 2;
	gun3 = 2;
	map = 3;
	flash = 2;
	radio = 0;

	str = 1;
	ste = 3;
	inte = 2;
	psy = 0;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "You were trying to stealthily sneak around but you found that the food allowed beasts to sniff you out so you decided to throw it\n-1 Food";
	water = "You were trying to stealthily sneak around but you found that the water made too much noise as its weight shifted back and forth so you decided to toss it\n-1 Water";
	bad = "You got loss and all you found was a giant cockroach that took a piece out of your shin\n-40 Health";
	medium = "On your way to the electronics store you were attacked by a zombie gorilla! Luckily you were able to take it down\n+1 Food";
	good = "You made it to Radio Shack! And there were actually radios there!\n+1 Radio";

	e = new String[]{food, water, bad, medium, good};
	d[26] = new Decision("You decide that you need to find a radio in order to catch any important news that might show up. Who should go out and look for it?", false, null, e, rithm);
	/////////////////////////////////////////////
	gun1 = 2;
	gun2 = 2;
	gun3 = 3;
	map = 0;
	flash = 4;
	radio = 2;

	str = 0;
	ste = 1;
	inte = 3;
	psy = 2;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "Food accomplished nothing\n-1 Food";
	water = "Water accomplished nothing\n-1 Water";
	bad = "You weren't able to catch the plane's attention and it flew by. But it seems you were able to catch the attention of some neaby zombie gorillas\n-30 Health";	
	medium = "You couldn't catch the plane's attention\n+5 Nothing";
	good = "As soon as the plane noticed you it tossed down a couple supplies\n+3 Food and Water";

	e = new String[]{food, water, bad, medium, good};
	d[27] = new Decision("You heard the sound of a plane flying around the area. What should you do?", false, null, e, rithm);
	///////////////////////////////////////////////
	o1 = "Yes! We need a taste of the old days";
	o2 = "No! We can't afford any unnecessary attention brought to us";

	good = "Some people were attracted by the sound and they were so impressed by the performance that they gave you a gun!\n+1 Gun";
	bad = "Another boring day passed in boredom\n+5 Nothing";

	o = new String[]{o1, o2};
	e = new String[]{good, bad};

	d[28] = new Decision("Someone found an old guitar in a nearby dumpster! Should you jam?", true, o, e, null);
	/////////////////////////////////////////////
	gun1 = 0;
	gun2 = 0;
	gun3 = 0;
	map = 4;
	flash = 2;
	radio = 2;

	str = 0;
	ste = 1;
	inte = 2;
	psy = 3;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "You gave him some food and nursed him back to health. He repayed you by giving you some medkits\n+3 Medkit";
	water = "You gave him some water and nursed him back to health. He repayed you by giving you some medkits\n+3 Medkit";
	bad = "You blew his brains out right there. You didn't particularly feel good about it. It made you feel sick to your stomach\n-10 Health";
	medium = "You didn't really bring out anything that would help the situation. But the company made the guy feel better. He rewarded you with a map\n+1 Map";
	good = "You waited with the man until he came around, then you helped him find his way back home. He rewarded you with a gun\n+1 Gun";

	e = new String[]{food, water, bad, medium, good};

	d[29] = new Decision("Someone can be seen outside, he seems to have passed out. What should be done?", false, null, e, rithm);
	//////////////////////////////////////
	o1 = "No, Spiderman doesn't exist";
	o2 = "He may not exist but you still want to check out what's going on";
	o3 = "Of course he exists. Go there in your Spiderman uniform!";

	bad = "Well he doesn't exist. Everyone was very disappointed\n+5 Nothing";
	medium = "Turns out he doesn't exist. Or at least he didn't show up. But you were able to steal a flashlight off of someone there\n+1 Flashlight";
	good = "Well Spiderman didn't show up. But because you came in your outfit everyone thought you were him and gave you a bunch of supplies to try to win your favor!\n+3 Food and Water";

	o = new String[]{o1, o2, o3};
	e = new String[]{bad, medium, good};
	
	d[30] = new Decision("There have been rumors going around that Spiderman is in the area and looking for a sidekick. Should you go see if you can make the cut?", true, o, e, null);
	/////////////////////////////////////////////////////
	gun1 = 2;
	gun2 = 2;
	gun3 = 1;
	map = 0;
	flash = 4;
	radio = 0;

	str = 0;
	ste = 3;
	inte = 1;
	psy = 2;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "A lizard slithered up from the depths and took the food right out of your hands\n-1 Food";
	water = "A lizard slithered out from the depths and scared you so bad you spilled all of your water!\n-1 Water";
	bad = "You wriggled into the crawlspace to dislodge the disgusting thing and were attacked by some sort of lizard! You weren't really able to do anything except try to wriggle back out while it destroyed your face\n-40 Health";
	medium = "You wriggled into the crawlspace to dislodge the disgusting thing and were attacked by some sort of lizard! Luckily you were able to kill it. It looks yummy\n+1 Food";
	good = "You wriggled into the crawlspace when you saw the shadow of something! But you shined your flashlight on it and managed to scare it away. You crawled farther in and found a huge rat carcass! And lying beside it you found some medkits!\n+2 Medkit";

	e = new String[]{food, water, bad, medium, good};
	d[31] = new Decision("Some terrible stench has been coming up from under the crawlspace for a while now and it's got everyone near death. Who should go take care of it?", false, null, e , rithm);
	////////////////////////////////////////////
	o1 = "Wal-Mart! They've got everything";
	o2 = "BestBuy! It's all about the tech";
	o3 = "Macy's! Need those clothes";

	bad = "You found food at Wal-Mart for a bargain!\n+2 Food";
	medium = "You found a new Radio at BestBuy for a bargain!\n+1 Radio";
	good = "You found nothing at Macy's. Deals must've been so good they all got taken before you got there\n+5 Nothing";

	o = new String[]{o1, o2, o3};
	e = new String[]{bad, medium, good};

	d[32] = new Decision("It's Black Friday! Where should you go for the best deals?", true, o, e, null);
	//////////////////////////////////////////////
	gun1 = 1;
	gun2 = 2;
	gun3 = 3;
	map = 0;
	flash = 3;
	radio = 0;

	str = 2;
	ste = 3;
	inte = 1;
	psy = 0;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "You couldn't hold the soap and the food so you dropped the food\n-1 Food";
	water = "You couldn't hold the soap and the water so you dropped the food\n-1 Water";
	bad = "The store was inhabited by really good smelling bandits and they drove you off before you could get anything\n-40 Health";	
	medium = "You saw some people in there but you were able to get some good soap before they ran you out and it really affected everyone's health\n+30 All Health";
	good = "You were able to sneak into the store undetected and found their map in the back!\n+1 Map";	

	e = new String[]{food, water, bad, medium, good};
	d[33] = new Decision("Everybody smells awful. The world may have been practically destroyed but there needs to be some sense of hygiene. There's a Bath and Body Works down the street, who's going?", false, null, e, rithm);
	////////////////////////////////////////////
	o1 = "Tell boring stories";
	o2 = "Get outside and do some manual labor to make yourself tired";
	o3 = "Eat a bunch of food and go into a food coma!";

	medium = "It worked! Everyone got a great sleep that night and it made them feel much better\n+30 All Health";
	good = "While you were outside you managed to find a flashlight!\n+1 Flashlight";
	bad = "Well it worked, but you lost a lot of food in the process\n-3 Food";

	o = new String[]{o1, o2, o3};
	e = new String[]{medium, good, bad};

	d[34] = new Decision("The constant tense atmosphere has made it difficult to sleep. What should be done to make it easier?", true, o, e, null);
	//////////////////////////////////////////////////
	gun1 = 2;
	gun2 = 3;
	gun3 = 4;
	map = 1;
	flash = 2;
	radio = 0;

	str = 3;
	ste = 2;
	inte = 0;
	psy = 1;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "You can't be a hero just using food\n-1 Food";
	water = "You can't be a hero just using water\n-1 Water";
	bad = "You couldn't quite live up to the hero expectation, not when you cry that easily\n-40 Health";
	medium = "You were able to stop a crouple evil-doers but it didn't really make much of an impact. Nevertheless a citizen rewarded you with some supplies\n+2 Food and Water";
	good = "You were made for this vigilante stuff! You did such a good job that the citizenry awarded you a new gun so that you might be able to do further good!\n+1 Gun";

	e = new String[]{food, water, bad, medium, good};

	d[35] = new Decision("There may have been an zombie gorilla apocalypse but that's no excuse for all the bandits that have been out lately. Who will take care these nuisances and become a hero for the city?", false, null, e, rithm);
	/////////////////////////////////////////////
	o1 = "Just throw some black pepper on it";
	o2 = "Make it into a curry, everyone loves curry";
	o3 = "Maybe making it really salty would help";

	good = "Simple but effective. The new taste gave everyone a positive outlook on the situation and did wonders for their gastronomy\n+30 All Health";
	bad = "It was delicious! But ridiculously hot. It literally burned everyone's insides\n-30 All Health";
	medium = "It tasted different. Not much better though. And it was so salty that everyone had to drink a bunch of water\n-3 Water";

	o = new String[]{o1, o2, o3};
	e = new String[]{good, bad, medium};

	d[36] = new Decision("Everyone is saying that the taste of the gorilla meat is becoming too monotonous. What should you do to spice it up a bit?", true, o, e, null);
	//////////////////////////////////////////////////
	gun1 = 1;
	gun2 = 2;
	gun3 = 3;
	map = 1;
	flash = 3;
	radio = 3;

	str = 0;
	ste = 3;
	inte = 1;
	psy = 2;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "The food just attracted them to you\n- Character ";
	water = "The water didn't really help you get away...\n- Character";
	bad = "You lured them away but you couldn't get away from them yourself\n- Character";
	medium = "You lured them away and were barely able to get out with your life\n-30 Health";
	good = "You lured them away and hid in a dumpster where you found some medkits!\n+2 Medkit";

	e = new String[]{food, water, bad, medium, good};

	d[37] = new Decision("The zombie gorillas seem to be pinpointing our hideout. Someone needs to go out there and lead them away from the base. Who should do it?", false, null, e, rithm);
	////////////////////////////////////////////
	o1 = "Eat it anyways, it's probably fine and we can't afford to waste food";
	o2 = "Throw it out. We can't let ourselves get sick off rancid meat";

	bad = "Well it didn't really taste that bad. But it definitely made you feel bad\n-60 All Health";
	good = "You threw it out. Hopefully you made the right decision\n-All Food";

	o = new String[]{o1, o2};
	e = new String[]{bad, good};

	d[38] = new Decision("The food has started to taste kinda nasty. It might've gone bad. What should you do?", true, o, e, null);
	/////////////////////////////////////////////////
	gun1 = 1;
	gun2 = 2;
	gun3 = 3;
	map = 3;
	flash = 0;
	radio = 0;

	str = 1;
	ste = 3;
	inte = 2;
	psy = 0;

	itemInts = new int[]{gun1, gun2, gun3, map, flash, radio, foodInt, waterInt};
	rithm  = new Algorithm(str, ste, inte, psy, itemInts);

	food = "Someone stole your food and your precious metals\n-1 Food";
	water = "Someone stole your water and your precious metals\n-1 Water";
	bad = "Someone stole your precious metals, but not without beating you severely first\n-40 Health";
	medium = "You got a bit ripped off, but at least you got something out of it\n+2 Medkit";
	good = "You really got some bang for your buck\n+1 Gun";

	e = new String[]{food, water, bad, medium, good};

	d[39] = new Decision("You found some precious metals in a safe under the stairwell and you think you could get some good stuff with it. Who should go out and try to sell it?", false, null, e, rithm);

	shuffle();
	return d;
    }

    public void updatePanel(int num){
	sPanel.removeAll();
	int index;
	if(d[decisionNum].simple){
	    index = num;
	    area.setText(d[decisionNum].endings[index]);
	    sPanel.add(okay);
	    panel.updateUI();
	}
	
	else{
	    if(num < -100) index = 0;
	    else if(num < 0) index = 1;
	    else if(num < 17) index = 2;
	    else if(num < 32) index = 3;
	    else index = 4;	
	    area.setText(d[decisionNum].endings[index]);
	    sPanel.add(okay);
	    panel.updateUI();
	}
	
	String action = d[decisionNum].endings[index].substring(d[decisionNum].endings[index].indexOf("\n"));	
	String amount = action.substring(1,action.indexOf(" "));
	amount = amount.trim();	
	action = action.substring(action.indexOf(" "));
	action = action.trim();        
	
        if(action.equals("Health")){
	    c.setHP(c.getHP()+Integer.valueOf(amount));
	    if(c.getHP() > 100) c.setHP(100);
	    if(Integer.valueOf(amount) < 0){
		int mState = c.getmState();
		c.setmState(mState + (Integer.valueOf(amount)/c.getPsychology()));
		System.out.println(c.getmState());
	    }
	}
	else if(action.equals("Food")){
	    Resource food = (Resource)items.get(0);
	    if(amount.equals("-All")) food.setAmount(0);
	    else food.addAmount(Integer.valueOf(amount));
	    if(food.getAmount() < 0) food.setAmount(0);
	}
	else if(action.equals("Water")){
	    Resource water = (Resource) items.get(1);
	    if(amount.equals("-All")) water.setAmount(0);
	    else water.addAmount(Integer.valueOf(amount));	 
	    if(water.getAmount() < 0) water.setAmount(0);
	}
	else if(action.equals("Food and Water")){
	    Resource food = (Resource)items.get(0);
	    Resource water = (Resource) items.get(1);
	    food.addAmount(Integer.valueOf(amount));
	    water.addAmount(Integer.valueOf(amount));
	    if(water.getAmount() < 0) water.setAmount(0);
	    if(food.getAmount() < 0) food.setAmount(0);
	}
	else if(action.equals("All Health")){
	    for(int i=0; i<chars.size(); i++){
		chars.get(i).setHP(chars.get(i).getHP()+Integer.valueOf(amount));
		if(chars.get(i).getHP() > 100) chars.get(i).setHP(100);
		if(Integer.valueOf(amount) < 0){
		    int mState = chars.get(i).getmState();
		    chars.get(i).setmState(mState + (Integer.valueOf(amount)/(chars.get(i).getPsychology()+1)));
		}
	    }
	}
	else if(action.equals("Character")){
	    if(amount.equals("-1")){
		Character c = chars.get(0);
		for(int i = 0; i < chars.size(); i++){
		    if(chars.get(i).getHP() > c.getHP()){
			c = chars.get(i);
		    }
		}
		chars.remove(c);
	    }
	    else{
		chars.remove(c);
	    }
	    for(int i = 0; i < chars.size(); i++){
		Character c = chars.get(i);
		int mState = c.getmState();
		int psych = c.getPsychology();
		c.setmState(mState - (5*(5-psych)));
	    }
	}
	else if(action.equals("Gun")){
	    boolean g1 = false, g2 = false, g3 = false;
	    for(int i=3; i < items.size(); i++){
		if(items.get(i).getName().equals("Pistol")) g1 = true;
		else if(items.get(i).getName().equals("Shotgun")) g2 = true;
		else if(items.get(i).getName().equals("Rifle")) g3 = true;
	    }
	    if(!g1){
		items.add(new Item("Pistol", new ImageIcon("gunIcon1.png"), new ImageIcon("gun1.png")));
	    }
	    else if(!g2){
		items.add(new Item("Shotgun", new ImageIcon("gunIcon2.png"), new ImageIcon("gun2.png")));
	    }
	    else if(!g3){
		items.add(new Item("Rifle", new ImageIcon("gunIcon3.png"), new ImageIcon("gun3.png")));
	    }
	    else{
		for(int i=3; i < items.size(); i++){		
		    if(items.get(i).getName().equals("Rifle")){
			items.get(i).setDurability(100);
		    }
		}
	    }		
	}

	else if(action.equals("Medkit")){
	    Resource medkit = (Resource)items.get(2);
	    medkit.addAmount(Integer.valueOf(amount));
	}

	else if(action.equals("Map")){
	    boolean map = false;
	    for(int i = 3; i < items.size(); i++){
		if(items.get(i).getName().equals("Map")){
		    map = true;
		    break;
		}
	    }
	    if(!map){
		items.add(new Item("Map", new ImageIcon("mapIcon.png"), new ImageIcon("map.png")));
	    }
	    else{
		for(int i = 3; i < items.size(); i++){
		    if(items.get(i).getName().equals("Map")){
			items.get(i).setDurability(100);
		    }
		}
	    }
	}

	else if(action.equals("Radio")){
	    boolean radio = false;
	    for(int i = 3; i < items.size(); i++){
		if(items.get(i).getName().equals("Radio")){
		    radio = true;
		    break;
		}
	    }
	    if(!radio){
		items.add(new Item("Radio", new ImageIcon("radioIcon.png"), new ImageIcon("radio.png")));
	    }
	    else{
		for(int i = 3; i < items.size(); i++){
		    if(items.get(i).getName().equals("Radio")){
			items.get(i).setDurability(100);
		    }
		}
	    }
	}
	else if(action.equals("Flashlight")){
	    boolean flash = false;
	    for(int i = 3; i < items.size(); i++){
		if(items.get(i).getName().equals("Flashlight")){
		    flash = true;
		    break;
		}
	    }
	    if(!flash){
		items.add(new Item("Flashlight", new ImageIcon("flashlightIcon.png"), new ImageIcon("flashlight.png")));
	    }
	    else{
		for(int i = 3; i < items.size(); i++){
		    if(items.get(i).getName().equals("Flashlight")){
			items.get(i).setDurability(100);
		    }
		}
	    }
	}
	decisionNum++;
    }

    public void shuffle(){
	Random rand = new Random();
	int[] nums = new int[40];
        int[] validKeys ={3,7,9,11,13,17,19,21,23,27,29,31,33};	
	key = validKeys[rand.nextInt(13)];
	Decision[] altD = new Decision[40];
	for(int i = 0; i < 40; i ++){	    
	    int num = (i+1)*key%40;	    
	    if(nums[num] == 1){
		num--;
	    }	    
	    else{
		nums[num] = 1;
	    }

	    altD[i] = d[num];
	    
	}
	
	for(int i = 0; i < 40; i ++){
	    if(altD[i] == null){
		System.out.println(i);
	    }
	}
	d = altD;	 
    }

    class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
	    String cmd = evt.getActionCommand();
	    if(cmd == "Enter"){
		if(d[decisionNum].simple){
		    updatePanel(cBox.getSelectedIndex());
		}
		else{
		    c = chars.get(cBox.getSelectedIndex());
		    int num = d[decisionNum].algo.getNumber(c.getStrength(), c.getStealth(), c.getIntelligence(), c.getPsychology(), iBox.getSelectedItem());
		    int index = iBox.getSelectedIndex();
		    if(index > 1){
			items.get(index+1).decDurability(20);
			if(items.get(index+1).getDurability() <= 0){ 
			    items.remove(index+1);
			}
			
		    }
		    
		    updatePanel(num);		    
		}
	    }
	    
	    else{
		area.setText("");
		area.setOpaque(false);
		panel.removeAll();
		panel.setOpaque(false);
		panel.updateUI();
		HuntardMainScreen.outsideUpdate();
	    }
	    
	}
    }
}
