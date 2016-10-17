import java.awt.*;
import javax.swing.JFrame;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;


public class Hmg extends Canvas implements Runnable{
	public static final int width = 400;
	public static final int height = 300;
	public static final int scale = 2;
	public final String title = "Hunting Mini-Game";

	private boolean running = false;
	private Thread thread;

	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	private BufferedImage sSheet = null;

	//TEST TIME*********************************************************************
	private BufferedImage p1;
	//TEST TIME*********************************************************************

	public void init(){
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			sSheet = loader.loadImage("spritesheet.png");
		}catch(IOException e){
			System.out.println("ya didnt get the sprites lad");
		}
		SpriteSheet ss = new SpriteSheet(sSheet);
		p1 = ss.grabImage(1,1,32,32);
	}
	//the core loop to run the game
	public void run(){
		init();
		//for the runnable stuffs
		long lastTime = System.nanoTime();
		final double tickFrame = 60.0;
		double ns = 1000000000 / tickFrame;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		//the variables above stay outside the loop to handle the games frame rate
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime=now;
			//the above code synchronizes the frames between when the variables are created and when the loop starts... because nano seconds and all.
			if(delta>=1){
				tick();
				updates++;
				delta--;
			}
		render();
		frames++;
		if(System.currentTimeMillis() - timer >1000){
			timer +=1000;
			System.out.println(updates + " < Ticks ||| FPS > " + frames);
			updates=0;
			frames = 0;
		}	
		}
			stop();	
	}
	private void tick(){

	}
	//method for making the pictures on the screen woooooo!!@$@#!$!@$
	private void render(){
		BufferStrategy bs = this.getBufferStrategy(); 

		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//Start loading graphics
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(p1,100,100,this);
		//Stop loading graphics
		g.dispose();
		bs.show();

	}
	//Starts the game, if the game is already running, the running variable is set to true and the method is exited.
	private synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	//stops the game and kills threads.
	private synchronized void stop(){
		if(!running)
			return;
		running = false;
		try{
			thread.join();
		}
		catch(InterruptedException e){
			System.out.println("THE THREADS ARE DEAD SEND HELP");
		}
		System.exit(1);
	}
	//temporary main method
	public static void main(String args[]){
		Hmg game = new Hmg();
		game.setPreferredSize(new Dimension(width*scale,height*scale));
		game.setMaximumSize(new Dimension(width*scale,height*scale));
		game.setMinimumSize(new Dimension(width*scale,height*scale));

		JFrame frame = new JFrame(game.title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}	
}