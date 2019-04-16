package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    radar r;
    ShipDesign ship;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, 50, 50, 100, 50, "I am a button");
        mc = new MovingCircle(this, width / 2, height / 2, 50);
        r = new radar(this, width / 2, height / 2, 120);
        ship= new ShipDesign(this);
    }

    public void draw()
    {
        background(0);
        
		ship.design1();
       /* b.render();

        mc.update();
        mc.render();

        r.update();
        r.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }*/
    }
}

