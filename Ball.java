package commain;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	public static final int SIZE=16;
	private int x,y;
	private int xvel , yvel;  //value either 1 or -1 (up or down)
	private int speed = 5;
	
    public Ball()
    {
    	reset();
    }

	private void reset() {
		//initial position
		x=Game.WIDTH / 2 - SIZE/2;
		y=Game.HEIGHT/2 - SIZE/2;
		
		//velocities
		xvel=Game.sign(Math.random()*2.0 - 1);
		yvel=Game.sign(Math.random()*2.0 - 1);
	}
	public void changeyDir()
	{
		yvel*= -1;
	}
	public void changexDir()
	{
		xvel*= -1;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, SIZE, SIZE);
		
	}

	public void update(Paddle p1, Paddle p2) {
		//update movement 
		x+=xvel*speed;
		y+=yvel*speed;
		
		//collisions
		
		if(y+SIZE>=Game.HEIGHT || y<=0)
			changeyDir();
		//with walls
		
		if(x+SIZE>= Game.WIDTH)
		{
			p1.addPoint();
			reset();
		}
		if(x<=0)
		{
			p2.addPoint();
			reset();
		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
